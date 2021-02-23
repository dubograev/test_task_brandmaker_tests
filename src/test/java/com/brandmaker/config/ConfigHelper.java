package com.brandmaker.config;

import org.aeonbits.owner.ConfigFactory;

import static java.lang.Boolean.parseBoolean;

public class ConfigHelper {

    public static String getPlatform() {
        return System.getProperty("platform");
    }

    public static boolean isWeb() {
        return getPlatform().equals("web");
    }

    public static boolean isAndroid() {
        return getPlatform().equals("android");
    }

    public static boolean isIos() {
        return getPlatform().equals("ios");
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getWebBrowserScreenResolution() {
        return getWebConfig().webBrowserScreenResolution();
    }

    public static String getWebMobileDevice() {
        return getWebConfig().webMobileDevice();
    }


    public static String getWebRemoteDriver() {
        return "https://" + getWebConfig().webRemoteDriverUser() + ":" +
                getWebConfig().webRemoteDriverPassword() + "@" +
                getWebConfig().webRemoteDriverUrl() + "/wd/hub";
    }

    public static boolean isRemoteWebDriver() {
        return getWebRemoteDriver().equals("");
    }

    public static String getWebVideoStorage() {
        return "https://" + getWebConfig().webVideoStorage() + "/video/";
    }

    // for web, ios, android
    public static boolean isVideoOn() {
        return parseBoolean(System.getProperty("video"));
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}