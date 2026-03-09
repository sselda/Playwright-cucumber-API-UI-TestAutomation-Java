package com.example.pages;

import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    private String priceInput = "#price";
    private String nameInput = "#product-name";
    private String saveButton = "#save";
    private String validationMessage = "#.error-message";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void enterPrice(String price) {
        page.fill(priceInput, price);
    }

    public void enterName(String name) {
        page.fill(nameInput, name);
    }

    public void clickSave(){
        page.click(saveButton);
    }

    public boolean isValidationMessageDisplayed() {
        return page.isVisible(validationMessage);
    }

}
