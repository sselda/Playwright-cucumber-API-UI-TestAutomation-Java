package com.example.steps.api;

import com.example.hooks.ApiHooks;
import com.example.hooks.Hooks;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import context.TextContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.InputStream;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UserApiSteps {

    public final TextContext context;
    private APIResponse response;
    private JsonNode responseBody;

    public UserApiSteps(TextContext context) {
        this.context = context;
    }

    @Then("response status should be {int}")
    public void response_status_should_be(int statusCode) {
        assertThat(response.status()).isEqualTo(statusCode);
    }

    @Then("response should contain field {string}")
    public void response_should_be_contain(String fieldName) {
        assertThat(responseBody.has(fieldName))
                .as("Response should contain field: " + fieldName)
                .isTrue();
    }

    @Then("first user email should be {string}")
    public void first_user_email_should_be(String expectedEmail) {
        String actualMail = responseBody
                .get("data")
                .get(0)
                .get("email")
                .asText();

        assertThat(actualMail)
                .as("Email should match")
                .isEqualTo(expectedEmail);
    }

    @Then("response should match schema {string}")
    public void response_should_match_schema(String schemaFile) throws Exception {

        InputStream schemaStream =
                getClass().getClassLoader()
                        .getResourceAsStream("schemas/"+ schemaFile);

        JsonSchemaFactory factory =
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        JsonSchema schema = factory.getSchema(schemaStream);

        Set<ValidationMessage> errors =
                schema.validate(responseBody);

        assertThat(errors)
                .as("Schema validation errors: " + errors)
                .isEmpty();
    }

    @When("user creates a new user via API")
    public void user_creates_user() throws Exception {

        String body = """
                {
                "name":"Selda",
                "job":"QA Engineer"
                }
                """;

        APIResponse response = ApiHooks.apiRequestContext.post(
                "/users",
                RequestOptions.create().setData(body)
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.text());

        context.setCreatedUserEmail("Selda");
    }

    @Then("created user should appear in UI")
    public void created_user_should_appear() {
        String email = context.getCreatedUserEmail();

        assertThat(Hooks.page.content())
                .contains(email);
    }

    @When("user logs in via API with {string} and {string}")
    public void user_logs_in_via_api(String email, String password) throws Exception {

        String body = """
                {
                "email":"%s",
                "password":"%s"
                }
                """.formatted(email,password);

        APIResponse response = ApiHooks.apiRequestContext.post(
                "/login",
                RequestOptions.create().setData(body)
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.text());

        String token = json.get("token").asText();
        context.setAuthToken(token);
    }

    @Given("user is authenticated in UI")
    public void user_is_authenticated_in_ui() {

        String token = context.getAuthToken();

        Hooks.page.navigate("https://your-app.com");
        Hooks.page.evaluate("""
                (token) => {(
                    localStorage.setItem("auth_token", token);
                    }
                """, token);

        Hooks.page.reload();
    }

}
