package com.example.hooks;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApiHooks {

    public static Playwright playwright;
    public static APIRequestContext apiRequestContext;

    @Before("api")
    public void setUpApi() {
        playwright = Playwright.create();

        apiRequestContext = playwright.request().newContext(
        new APIRequest.NewContextOptions()
                .setBaseURL("https://reqres.in/api")
                .setExtraHTTPHeaders(
                        java.util.Map.of("Content-Type", "application/json")
                )
        );
    }

    @After("api")
    public void tearDownApi() {
        apiRequestContext.dispose();
        playwright.close();
    }


}
