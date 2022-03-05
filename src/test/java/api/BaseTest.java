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

/**
 * Абстрактный класс, содержащий общие для всех тестов методы
 */
public abstract class BaseTest {
    protected static String token;

    @BeforeClass
    public void prepare() {
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
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными
//        Ticket ticket = new Ticket(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()),
//                "Test title",
//                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()),
//
//
//                )
        return null;
    }

    protected Ticket createTicket(Ticket ticket) {
        // todo: отправить HTTP запрос для создания тикета
        return null;
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime when =
                LocalDateTime.of(2016, Month.AUGUST, 12, 9, 38, 12, 123456789);
        LocalDateTime time = LocalDateTime.parse("2022-03-05T06:16:49.018615");
        String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
                .appendPattern(DATE_TIME_FORMAT_PATTERN)
                .appendFraction(ChronoField.MICRO_OF_SECOND, 6, 6, true)
                .toFormatter();
        System.out.println(LocalDateTime.now().format(formatter1));
        System.out.println(when.format(formatter1));
        System.out.println(when.format(dtf));
        System.out.println(time.format(dtf));

        System.out.println(Instant.now().plus(1, ChronoUnit.DAYS));

    }

}