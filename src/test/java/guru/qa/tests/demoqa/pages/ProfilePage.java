package guru.qa.tests.demoqa.pages;

import guru.qa.tests.demoqa.models.AuthModel;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfilePage {


    public ProfilePage openWithCookieDrop(AuthModel authModel) {
        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", authModel.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", authModel.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", authModel.getExpires()));
        open("/profile");
        return this;
    }

    public ProfilePage checkIfBookIsAdded(String cssSelector) {
        $(cssSelector).should(visible);
        System.out.println();
        return this;
    }

    public ProfilePage checkUsername(String userName) {
        $("#userName-value").shouldHave(text(userName));
        return this;
    }

    public ProfilePage noRowsCheck() {
        $("[class=rt-noData]").should(exist);
        return this;
    }
}
