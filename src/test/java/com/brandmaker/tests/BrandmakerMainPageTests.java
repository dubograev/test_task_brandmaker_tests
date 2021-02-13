package com.brandmaker.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@Tag("web")
public class BrandmakerMainPageTests {

    @Test
    @DisplayName("Main page should contain \"Unleash Your Marketing Superpowers!\" title")
    public void mainPageTitleTest() {
        open("https://www.brandmaker.com/");

        $("[data-widget_type='bm_header.default']").shouldHave(text("Unleash Your Marketing Superpowers!"));
    }

    @Test
    @Disabled
    @DisplayName("Console log should not contain any errors")
    public void mainPageConsoleLogTest() {
        open("https://www.brandmaker.com/");

       // String consoleLogs = getConsoleLogs();
       // assertThat(consoleLogs, not(containsString("SEVERE")));

    }

}
