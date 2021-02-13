package com.brandmaker.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class RequestDemoButtonTests {

    @Test
    @DisplayName("Main page should contain \"Request a Demo\" button")
    public void requestDemoButtonExistsTest() {
        open("https://www.brandmaker.com/");

        $(".elementor-button-text", 2).scrollTo().shouldHave(text("Request a Demo"));
    }

    @Test
    @DisplayName("\"Request a Demo\" button should lead to a proper page with \"Schedule Customized Demo\" title")
    public void requestDemoButtonClickTest() {
        open("https://www.brandmaker.com/");

        $(".elementor-button-text", 2).scrollTo().shouldHave(text("Request a Demo"));
        $(byText("Request a Demo")).scrollTo().click();
        $("h1").shouldHave(text("Schedule Customized Demo"));
    }
}
