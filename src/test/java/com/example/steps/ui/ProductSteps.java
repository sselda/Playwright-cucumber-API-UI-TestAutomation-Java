package com.example.steps.ui;

import com.example.pages.ProductPage;
import com.microsoft.playwright.Page;
import context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    private Page page;
    private ProductPage productPage;

    public ProductSteps(TextContext context) {
        this.page = context.getPage();
        productPage = new ProductPage(page);
    }

    @Given("Admin is on product creation page")
        public void admin_is_on_product_creation_page() {
        page.navigate("https://your-url.com/product");
    }

    @When("Admin enters {int} as price")
        public void admin_enters_as_price(int enteredPrice) {
        productPage.enterPrice(String.valueOf(enteredPrice));
    }

    @And("Admin clicks Save button")
        public void admin_clicks_save_button() {
        productPage.clickSave();
    }

    @Then("Validation error message should be displayed")
        public void validation_error_message_should_be_displayed() {
        Assert.assertTrue(productPage.isValidationMessageDisplayed());
    }

    @When("Admin enters 256 characters product name")
        public void admin_enters_long_characters_product_name() {
        productPage.enterName("A".repeat(256));
    }

}
