package guru.qa.tests.demoqa.tests;

import guru.qa.tests.demoqa.api.AuthorizationAPI;
import guru.qa.tests.demoqa.models.AuthModel;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.demoqa.tests.TestData.credentials;
import static guru.qa.tests.demoqa.tests.TestData.profilePage;


public class LoginTest extends TestBase {

    @Test
    void successfulLogin() {
        AuthModel authModel = AuthorizationAPI.login(credentials);

        profilePage.openWithCookieDrop(authModel);
        profilePage.checkUsername(credentials.getUserName());
    }
}
