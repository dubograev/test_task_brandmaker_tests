package com.brandmaker.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.brandmaker.config.ConfigHelper.*;


public class CustomWebDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        capabilities.setBrowserName(getWebBrowser());
        capabilities.setCapability("enableVNC", true);
        if (isVideoOn()) {
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("videoFrameRate", 24);
        }

        // todo implement for other drivers - opera, firefox, safari
        switch (getWebBrowser()) {
            case "chrome":
                capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
                WebDriverManager.chromedriver().setup();
                break;
            case "opera":
                // todo
                break;
        }

        if (isRemoteWebDriver()) {
            return getRemoteWebDriver(capabilities);
        } else {
            return getLocalChromeDriver(capabilities);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        if (!getWebMobileDevice().equals("")) {
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", getWebMobileDevice());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }
        chromeOptions.addArguments("--window-size=" + getWebBrowserScreenResolution());
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        // more options - https://github.com/puppeteer/puppeteer/blob/7a2a41f2087b07e8ef1feaf3881bdcc3fd4922ca/src/Launcher.js#L261

        return chromeOptions;
    }

//    private OperaOptions getOperaOptions() { // todo
//        ...
//    }

//    private FirefoxOptions getFirefoxOptions() { // todo
//        ...
//    }

//    private SafariOptions getSafariOptions() { // todo
//        ...
//    }

//    private InternetExplorerOptions getInternetExplorerOptions() { // not todo
//        ...
//    }

    @SuppressWarnings("deprecation")
    private WebDriver getLocalChromeDriver(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebdriverUrl(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }

    private URL getRemoteWebdriverUrl() {
        try {
            return new URL(getWebRemoteDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}