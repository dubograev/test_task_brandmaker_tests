package com.brandmaker.helpers;

import com.brandmaker.drivers.CustomWebDriver;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.MobileBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.brandmaker.config.ConfigHelper.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class DriverHelper {

    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).savePageSource(true));

        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.baseUrl = getWebUrl();

        Configuration.timeout = 10000;
    }

    /*
        testid - good practice
        https://docs.google.com/presentation/d/1jgn_L3Sb5mPAVHO1xJGtkBc6g6XpuCfBYcYaBXj4LTs
        https://www.youtube.com/watch?v=w5EgCZgj5yE
     */
    public static By byTestId(String testId) {
        if (isWeb()) {
            return by("data-testid", testId);
        } else if (isAndroid()) {
            return MobileBy.xpath("//*[@content-desc='" + testId + "']");
        } else if (isIos()) {
            return MobileBy.id(testId);
        } else { // todo isDesktop
            return by("some-desktop-attribute-name", testId);
        }
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

//    public static String getNetworkLogs() {
//        todo https://ru.selenide.org/2019/12/18/advent-calendar-network-logs-with-proxy/
//    }

}