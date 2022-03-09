package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import model.*;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.given;

/**
 * Абстрактный класс, содержащий общие для всех тестов методы
 */
public abstract class BaseTest {
    protected static String token;

    @BeforeClass
    public void prepare() {
        System.out.println("Подготовка...");
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // системная переменная "base.uri" загружаются из "config.properties"
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .build();
        // подготовлены глобальные преднастройки для запросов
        token = getToken();
        System.out.println("Токен получен");
    }

    protected Ticket buildNewTicket(int status, int priority) {
        // todo: создать объект с тестовыми данными
        System.out.println("Генерируем тикет...");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dueLocalDate = LocalDateTime.now().plus(12, ChronoUnit.DAYS);
        String dueDate = dtf.format(dueLocalDate);
        return new Ticket(
                dueDate,
                "Тестовый заголовок проблемы",
                "test@ya.ru",
                status,
                false,
                "Тестовое описание проблемы",
                priority,
                1);
    }

    protected Ticket createTicket(Ticket ticket) {
        // todo: отправить HTTP запрос для создания тикета
        System.out.println("Отправляем тикет на HelpDesk");
        System.out.println("Имеющийся токен: " + token);
        Ticket ticketResponce = given()
                .header("Authorization", "token " + token)
                .body(ticket)
                .expect().statusCode(201)
                .when()
                .post(EndPoints.TICKETS)
                .then()
                .log().all()
                .extract().as(Ticket.class);
        System.out.println("Тикет отправлен на HelpDesk, и получен ответ с созданным Тикетом");
        return ticketResponce;
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
        AuthToken authToken = new AuthToken(name, password);
        return given()
                .body(authToken)
                .expect().statusCode(200)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .log().all()
                .extract().jsonPath().getString("token");
    }
}