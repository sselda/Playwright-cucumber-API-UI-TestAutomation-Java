package com.example.steps.ui;
import com.example.hooks.Hooks;
import com.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeSteps {

    HomePage homePage;

    @Given("user opens the homepage")
    public void user_opens_the_homepage() {
        homePage = new HomePage(Hooks.page);
        homePage.open();
    }

    @Then("homepage title should contain {string}")
    public void homepage_title_should_contain(String text) {
        assertThat(homePage.getTitle()).containsIgnoringCase(text);
    }
}