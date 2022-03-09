package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Обновление тикета
 */
public class UpdateTicketTest extends BaseTest {

    @Test(expectedExceptions = java.lang.RuntimeException.class)
    //@Test()
    public void updateTicketTest() {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        Ticket ticket = createTicket(buildNewTicket(Status.CLOSED.getCode(), 3));
        ticket.setStatus(Status.OPEN.getCode());
        updateTicketNegative(ticket);
    }

    private void updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        System.out.println("Запущен метод обновления тикета");

        int statusCode = given()
                .header("Authorization", "token " + token)
                .body(ticket)
                .when()
                .put(EndPoints.TICKETS + "/" + ticket.getId())
                .then()
                .log().all()
                .extract().statusCode();
        System.out.println(statusCode);
        if (statusCode % 100 == 4) {
            throw new RuntimeException("статус код: " + statusCode);
        }
    }
}