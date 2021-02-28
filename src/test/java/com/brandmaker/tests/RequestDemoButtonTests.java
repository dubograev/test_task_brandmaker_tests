package com.brandmaker.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Main Page")
@Story("\"Request a Demo\" button")
public class RequestDemoButtonTests extends TestBase{

    @Test
    @AllureId("1627")
    @DisplayName("Main page should contain \"Request a Demo\" button")
    public void requestDemoButtonExistsTest() {
        step("Open main page", ()-> open(""));

        step("Accept cookies", ()->
            $("#hs-en-cookie-confirmation-buttons-area").$(byText("Accept")).click());

        step("Verify that main page contains \"Request a Demo\" button", ()->
            $(".elementor-button-text", 2).scrollTo().shouldHave(text("Request a Demo")));
    }

    @Test
    @AllureId("1628")
    @DisplayName("\"Request a Demo\" button should lead to a proper page with \"Schedule Customized Demo\" title")
    public void requestDemoButtonClickTest() {
        step("Open main page", ()-> open(""));

        step("Accept cookies", ()->
            $("#hs-en-cookie-confirmation-buttons-area").$(byText("Accept")).click());

        step("Click on \"Request a Demo\" button", ()->
            $(".elementor-button-text", 2).scrollIntoView(false).click());

        step("Verify that \"Request a Demo\" button leads to \"Schedule Customized Demo\" page", ()->
            $("h1").shouldHave(text("Schedule Customized Demo")));
    }
}