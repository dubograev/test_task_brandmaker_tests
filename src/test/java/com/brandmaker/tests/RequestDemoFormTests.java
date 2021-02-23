package com.brandmaker.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
@Feature("\"Request a Demo\" form")
public class RequestDemoFormTests extends TestBase{

    @Test
    @AllureId("1641")
    @DisplayName("Request a demo with empty form - Negative scenario")
    public void requestDemoWithEmptyFormTest() {
        open("contact/request-demo/");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();

        $("[value=Submit]").click();
        $(".hs_firstname").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please complete this required field."));
        $(".hs_lastname").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please complete this required field."));
        $(".hs_email").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please complete this required field."));
        $(".hs_country").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please select an option from the dropdown menu."));
        $(".hs_company").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please complete this required field."));

        $(".hs-dependent-field").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please complete this required field."));
    }

    @Test
    @AllureId("1642")
    @DisplayName("Request a demo with non-business email - Negative scenario")
    public void requestDemoWithFormWithGmailEmailTest() {
        open("contact/request-demo/");
        $("#hs-en-cookie-confirmation-buttons-area").find(byText("Accept")).click();

       $("[id^=firstname]").setValue("Pit");
       $("[id^=firstname]").setValue("Thomson");
       $("[id^=email]").setValue("pit.thomson@gmail.com");
       $("[id^=country]").selectOption("Russia");
       $("[id^=company]").setValue("Brandmaker");
       $("[id^=jobtitle]").setValue("Tester");
       $("[id^=message]").setValue("Some text");
       $("[id^=LEGAL_CONSENT]").click();
       $("[value=Submit]").click();

       $(".hs_email").find(By.cssSelector(".hs-error-msg")).shouldHave(text("Please enter your business email address. This form does not accept addresses from gmail.com."));
    }
}
