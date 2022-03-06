package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

/**
 * Обновление тикета
 */
public class UpdateTicketTest extends BaseTest {

    @Test (expectedExceptions = Exception.class)
    public void updateTicketTest() throws Exception {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        Ticket ticket = createTicket(buildNewTicket(Status.CLOSED.getCode(), 3));
        ticket.setStatus(Status.OPEN.getCode());
        updateTicketNegative(ticket);
    }

    private void updateTicketNegative(Ticket ticket) throws Exception {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        System.out.println("Запущен метод обновления тикета");
        RequestSpecification httpRequest = RestAssured.given()
                .body(ticket)
                .param("id", String.valueOf(ticket.getId()));
        Response response = httpRequest.put(EndPoints.TICKETS);
        int statusCode = response.getStatusCode();
        if (statusCode % 100 == 4){
            System.out.println(statusCode);
            throw new Exception();
        }
    }
}