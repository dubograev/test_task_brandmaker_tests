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

@Tag("web")
@Feature("Main Page")
public class RequestDemoButtonTests extends TestBase{

    @Test
    @Story("\"Request a Demo\" button")
    @AllureId("#1627")
    @DisplayName("Main page should contain \"Request a Demo\" button")
    public void requestDemoButtonExistsTest() {
        open("");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();


        $(".elementor-button-text", 2).scrollTo().shouldHave(text("Request a Demo"));
    }

    @Test
    @Story("\"Request a Demo\" button")
    @AllureId("#1628")
    @DisplayName("\"Request a Demo\" button should lead to a proper page with \"Schedule Customized Demo\" title")
    public void requestDemoButtonClickTest() {
        open("");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();

        $(".elementor-button-text", 2).scrollIntoView(false).click();
        $("h1").shouldHave(text("Schedule Customized Demo"));
    }
}
