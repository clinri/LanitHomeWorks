package api;

import model.AuthClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class AuthTest extends BaseTest {
    @Test
    public void authSuccessTest() {
        if (token == null) {
            token = getToken();
            System.out.println("Токен получен");
        }
        Assert.assertEquals(token, "c1803e6e3b12359683796496625e8518b2e082c3");
    }

    protected static String getToken() {
        String name = System.getProperty("name.login");
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"name.login\"");
        }
        String password = System.getProperty("password.login");
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"password.login\"");
        }
        AuthClass authClass = new AuthClass(name, password);
        return given()
                .body(authClass)
                .expect().statusCode(200)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .log().all()
                .extract().jsonPath().getString("token");
    }
}
