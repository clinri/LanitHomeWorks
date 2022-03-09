package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Создание и проверка тикета
 */
public class CreateTicketAutoTest extends BaseAutoTest {

    @Test
    public void createTicketTest() {
        // todo: создать тикет и проверить, что он находится в системе
        System.out.println("Запускается тест создания тикета...");
        Ticket ticket = createTicket(buildNewTicket(Status.OPEN.getCode(), 1));
        System.out.println(ticket.getTitle());
        Assert.assertEquals(ticket, getTicket(ticket.getId()));
    }

    protected Ticket getTicket(int id) {
        // todo: отправить HTTP запрос на получение тикета по его id
        System.out.println("Запущен метод получения тикета по id");
        Ticket[] ticket = given()
                .param("id",id)
                .expect().statusCode(200)
                .when()
                .get(EndPoints.TICKETS)
                .then()
                .log().all()
                .extract().as(Ticket[].class);
        System.out.println("Получили Тикет по id c HelpDesk");
        return ticket[0];
    }
}
