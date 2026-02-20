package com.example.steps.ui;

import com.example.hooks.Hooks;
import com.example.pages.HomePage;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomeSteps {

    HomePage homePage;

    @Then("homepage should be loaded")
    public void homepage_should_be_loaded() {

        assertThat(Hooks.page.url())
                .contains("/dashboard");

        assertThat(
                Hooks.page.locator("#user-profile").isVisible()
        ).isTrue();
    }
}
