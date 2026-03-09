package com.example.pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private Page page;

    private String addToCartButton = "#add-to-cart";
    private String cartItem = ".cart-item";
    private String removeButton = ".remove-item";
    private String quantityInput = "#quantity";
    private String cartEmptyMessage = ".cart-empty";

    public CartPage(Page page) {
        this.page = page;
    }

    public void clickAddToCart(){
        page.click(addToCartButton);
    }

    public boolean isProductVisibleInCart() {
        return page.isVisible(cartItem);
    }

    public void removeProduct() {
        page.click(removeButton);
    }

    public boolean isCartEmpty() {
        return page.isVisible(cartEmptyMessage);
    }

    public void setQuantity(String quantity){
        page.fill(quantityInput, quantity);
    }

    public String getQuantity() {
        return page.inputValue(quantityInput);
    }
}
