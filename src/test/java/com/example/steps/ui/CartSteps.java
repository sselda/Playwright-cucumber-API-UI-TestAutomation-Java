package com.example.steps.ui;

import com.example.pages.CartPage;
import com.microsoft.playwright.Page;
import context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartSteps {
    private Page page;
    private CartPage cartPage;

    public CartSteps(TextContext context) {
        this.page = context.getPage();
        cartPage = new CartPage(page);
    }

    @Given("User is on products page")
        public void user_is_on_products_page() {
        page.navigate("https://your-url.com/product");
    }

    @When("User clicks on Add to Cart button")
        public void user_clicks_on_add_to_cart_button() {
        cartPage.clickAddToCart();
    }

    @Then("Product should be visible in the cart")
        public void product_should_be_visible_in_the_cart() {
        Assert.assertTrue(cartPage.isProductVisibleInCart());
    }

    @And("Cart quantity should be {int}")
        public void cart_quantity_should_be(int expected) {
        Assert.assertEquals(String.valueOf(expected), cartPage.getQuantity());
    }

    @Given("Product is already in the cart")
        public void product_is_already_in_the_cart() {
        cartPage.isProductVisibleInCart();
    }

    @When("User removes the product from cart")
        public void user_removes_the_product_from_cart() {
        cartPage.removeProduct();
    }

    @Then("Cart should be empty")
        public void cart_should_be_empty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @When("User decreases quantity to {int}")
        public void user_decreases_quantity_to(int reduced) {
        cartPage.setQuantity(String.valueOf(reduced));
    }

    @Then("Quantity should remain {int}")
        public void quantity_should_remain(int expected) {
        Assert.assertEquals(String.valueOf(expected), cartPage.getQuantity());
    }



}
