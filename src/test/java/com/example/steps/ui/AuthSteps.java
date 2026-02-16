package com.example.steps.ui;

import com.example.hooks.Hooks;
import com.example.pages.LoginPage;
import com.microsoft.playwright.BrowserContext;
import io.cucumber.java.en.Given;

import java.nio.file.Path;

public class AuthSteps {

    @Given("user is logged in")
    public void user_is_logged_in() {
        LoginPage loginPage = new LoginPage(Hooks.page);
        loginPage.isLoggedIn();
        loginPage.login("demo","demo123");

        //Login nur einmal ausführen und Session speichern
        Hooks.context.storageState(
                new BrowserContext.StorageStateOptions()
                        .setPath(Path.of("src/test/resources/auth/state.js"))
        );
    }

}
