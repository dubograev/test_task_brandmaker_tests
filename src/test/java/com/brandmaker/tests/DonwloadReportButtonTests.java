package com.brandmaker.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Main Page")
@Story("\"Download Report\" button")
public class DonwloadReportButtonTests extends TestBase{

    @Test
    @AllureId("1625")
    @DisplayName("Main page should contain \"Download Report\" button")
    public void downloadReportButtonExistsTest() {
        step("Open main page", ()-> open(""));

        step("Accept cookies", ()->
            $("#hs-en-cookie-confirmation-buttons-area").$(byText("Accept")).click());

        step("Verify that main page contains \"Download Report\" button", ()->
            $(".bm_header_gs_button").shouldHave(text("Download Report")));
    }

    @Test
    @AllureId("1626")
    @DisplayName("\"Download Report\" button should lead to a proper page with \"Download the full report\" button")
    public void downloadReportButtonClickTest() {
        step("Open main page", ()-> open(""));

        step("Accept cookies", ()->
            $("#hs-en-cookie-confirmation-buttons-area").$(byText("Accept")).click());

        step("Verify that main page contains \"Download Report\" button", ()->
            $(".bm_header_gs_button").shouldHave(text("Download Report")));

        step("Click on \"Download Report\" button", ()->
            $(byText("Download Report")).click());

        step("Verify that \"Download Report\" button leads to \"The Forrester Wave™ Report MRM\" page", ()->
            $("h1").shouldHave(text("The Forrester Wave™ Report MRM")));

        step("Verify that \"The Forrester Wave™ Report MRM\" page contains \"Download the full report\" button", ()->
            $(".bm_header_gs_button").shouldHave(text("Download the full report")));
    }
}