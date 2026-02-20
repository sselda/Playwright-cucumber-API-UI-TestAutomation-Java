package com.example.steps.api;

import com.example.hooks.ApiHooks;
import com.microsoft.playwright.APIResponse;
import io.cucumber.java.en.When;

public class ApiRequestSteps {

    public APIResponse response;

    @When("user sends {string} request to {string}")
    public void user_sends_request(String method, String endpoint) {

        switch (method.toUpperCase()) {

            case "GET":
                response = ApiHooks.apiRequestContext.get(endpoint);
                break;

            case "POST":
                response = ApiHooks.apiRequestContext.post(endpoint);
                break;

            case "PUT":
                response = ApiHooks.apiRequestContext.put(endpoint);
                break;

            case "DELETE":
                response = ApiHooks.apiRequestContext.delete(endpoint);
                break;

            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
    }
}
