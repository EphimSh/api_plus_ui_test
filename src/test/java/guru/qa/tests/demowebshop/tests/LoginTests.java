package guru.qa.tests.demowebshop.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase {

    @Test
    void loginWithUITest(){
        step("open login page", () ->{
           open("/login");
        });
        step("Fill login form", ()->{
           $("#Email").setValue(config.getLogin());
           $("#Password").setValue(config.getPassword())
                   .pressEnter();
        });
        step("Verify successful authorization", () ->{
           $(".account").shouldHave(text(config.getLogin()));
        });
    }

    @Test
    void loginWithAPITest() {
        step("Get auth-cookie by api and set it to browser", () -> {
            String authCookieKey = "NOPCOMMERCE.AUTH";
            String authorizationCookieValue = given()
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("Email", config.getLogin())
                    .formParam("Password", config.getPassword())
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .statusCode(302)
                    .extract()
                    .cookie(authCookieKey);

            open("/Content/jquery-ui-themes/smoothness/images/ui-bg_flat_75_ffffff_40x100.png");
            Cookie authCookie = new Cookie(authCookieKey, authorizationCookieValue);
            getWebDriver().manage().addCookie(authCookie);
        });

        step("open main page", () -> {
            open("");
        });

        step("Verify successful authorization", () -> {
            $(".account").shouldHave(text(config.getLogin()));
        });
    }
}
