package guru.qa.tests.demoqa.api;

import guru.qa.tests.demoqa.models.CredentialsModel;
import guru.qa.tests.demoqa.models.AuthModel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {
    public static AuthModel login(CredentialsModel credentials) {
        return given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .statusCode(200)
                .extract()
                .as(AuthModel.class);
    }
}
