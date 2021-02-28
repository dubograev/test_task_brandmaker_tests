package com.brandmaker.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.brandmaker.helpers.DriverHelper.getConsoleLogs;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@Tag("web")
@Feature("Main Page")
public class BrandmakerMainPageTests extends TestBase {

    @Test
    @AllureId("1624")
    @DisplayName("Main page should contain \"Unleash Your Marketing Superpowers!\" title")
    public void mainPageTitleTest() {
        step("Open main page", () -> open(""));

        step("Accept cookies", () ->
                $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click());

        step("Verify that main page contains \"Unleash Your Marketing Superpowers!\" title", () ->
                $("[data-widget_type='bm_header.default']").shouldHave(text("Unleash Your Marketing Superpowers!")));
    }

    @Test
    @AllureId("1623")
    @DisplayName("Console log should not contain any errors")
    public void mainPageConsoleLogTest() {
        step("Open main page", () -> open(""));

        step("Accept cookies", () ->
                $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click());

        step("Main page should not have errors (SEVERE) in console", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}