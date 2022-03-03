package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpec(String baseUri, int port){
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setPort(port)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification responseSpecOK200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecERROR400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public static void installSpecification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
