package pages;

import models.Ticket;
import org.openqa.selenium.support.PageFactory;

/** Страница со списком тикетов */
public class TicketsPage extends HelpdeskBasePage {

    // todo: элементы страницы поиска тикетов

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    /** Ищем строку с тикетом и нажимаем на нее */
    public void openTicket(Ticket ticket) {
        // todo: найти и открыть тикет
    }

}
