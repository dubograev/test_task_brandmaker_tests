package com.brandmaker.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class BrandmakerMainPageTests extends TestBase{

    @Test
    @DisplayName("Main page should contain \"Unleash Your Marketing Superpowers!\" title")
    public void mainPageTitleTest() {
        open("");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();


        $("[data-widget_type='bm_header.default']").shouldHave(text("Unleash Your Marketing Superpowers!"));
    }

    @Test
    @Disabled
    @DisplayName("Console log should not contain any errors")
    public void mainPageConsoleLogTest() {
        open("");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();


        // String consoleLogs = getConsoleLogs();
       // assertThat(consoleLogs, not(containsString("SEVERE")));

    }

}
