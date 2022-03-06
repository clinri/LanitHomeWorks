package api;

import io.restassured.RestAssured;
import model.*;
import org.testng.annotations.BeforeClass;
import sun.security.jca.GetInstance;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

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
        int port = Integer.parseInt(System.getProperty("port.uri"));
        if (port == 0) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"port.uri\"");
        }
        RestAssured.requestSpecification = Specifications.requestSpec(baseUri, port);
        // подготовлены глобальные преднастройки для запросов
        token = AuthTest.getToken();
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

//    public static void main(String[] args) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
//        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime when =
//                LocalDateTime.of(2016, Month.AUGUST, 12, 9, 38, 12, 123456789);
//        LocalDateTime time = LocalDateTime.parse("2022-03-05T06:16:49.018615");
//        LocalDateTime t2 = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
//        String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd";
//        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
//                .appendPattern(DATE_TIME_FORMAT_PATTERN)
//                .appendFraction(ChronoField.MICRO_OF_SECOND, 6, 6, true)
//                .toFormatter();
//        System.out.println(LocalDateTime.now().format(formatter1));
//        System.out.println(when.format(formatter1));
//        System.out.println(when.format(dtf));
//        System.out.println(time.format(dtf));
//
//        System.out.println(Instant.now().plus(1, ChronoUnit.DAYS));
//        System.out.println(Instant.now());
//        System.out.println(dtf1.format(t2));
//
//    }

}