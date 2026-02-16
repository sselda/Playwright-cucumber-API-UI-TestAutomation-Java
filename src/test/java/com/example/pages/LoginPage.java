package com.example.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    //Locators
    private final String usernameInput = "#username";
    private final String passwordInput = "#password";
    private final String loginButton = "#login";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public boolean isLoggedIn(){
        return page.url().contains("/dashboard");
    }


}
