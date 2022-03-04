package api;

import io.restassured.RestAssured;
import model.*;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

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
        RestAssured.requestSpecification = Specifications.requestSpec(baseUri,port);
        // подготовлены глобальные преднастройки для запросов
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными
        return null;
    }

    protected Ticket createTicket(Ticket ticket) {
        // todo: отправить HTTP запрос для создания тикета
        return null;
    }

}