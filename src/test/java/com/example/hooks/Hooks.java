package com.example.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    private static final Path STATE_PATH =
            Path.of("src/test/resources/auth/state.json");

    @Before ("@ui")
    public void setUpUi() throws Exception {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        if (Files.exists(STATE_PATH)) {
            context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setStorageStatePath(STATE_PATH)
            );
        } else {
            context = browser.newContext();
        }

        page = context.newPage();
    }

}
