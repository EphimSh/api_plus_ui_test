package guru.qa.tests.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources("classpath:config/local.properties")
public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("114.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
    @Key("baseUrl")
    String getBaseUrl();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String getPageLoadStrategy();


    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

}
