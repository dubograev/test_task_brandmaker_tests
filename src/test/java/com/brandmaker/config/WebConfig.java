package com.brandmaker.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("web.browser")
    String webBrowser();

    @Key("web.browser.screen.resolution")
    String webBrowserScreenResolution();

    @Key("web.mobile.device")
    String webMobileDevice();

    @Key("web.remote.driver.url")
    String webRemoteDriverUrl();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();

    @Key("web.video.storage")
    String webVideoStorage();

}