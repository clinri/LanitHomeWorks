package api;

import model.AuthClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class AuthTest extends BaseTest {
    @Test
    public void authSuccessTest() {
        String token = token();
        System.out.println(token);
        Assert.assertEquals(token,"c1803e6e3b12359683796496625e8518b2e082c3");
    }

    protected static String token() {
        String name = System.getProperty("name.login");
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"name.login\"");
        }
        String password = System.getProperty("password.login");
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"password.login\"");
        }
        AuthClass authClass = new AuthClass(name, password);
        responseSpecification = Specifications.responseSpecOK200();
        return given()
                .body(authClass)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .log().all()
                .extract().jsonPath().getString("token");
    }
}
