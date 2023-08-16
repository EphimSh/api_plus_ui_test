package guru.qa.tests.demowebshop.tests;

import com.codeborne.selenide.Configuration;

import guru.qa.tests.demowebshop.config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
public class TestBase {

    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = config.getBaseUrl();
        RestAssured.baseURI = config.getBaseUrl();
    }


}