package com.example.steps.ui;

import com.example.hooks.Hooks;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page(){
        loginPage = new LoginPage(Hooks.page);
        loginPage.isLoggedIn();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        assertThat(loginPage.isLoggedIn())
                .as("User should be redirected to dashboard")
                .isTrue();
    }
}
