package pages;

import models.Ticket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // Способ объявления элементы страницы, через аннотацию
    @FindBy(xpath = "")
    private WebElement inputProblemTitle;

    // todo: остальные элементы

    public CreateTicketPage() {
        // Необходимо инициализировать элементы класса, лучше всего это делать в конструкторе
        PageFactory.initElements(driver, this);
    }

    /** Создание тикета */
    public void createTicket(Ticket ticket) {
        setProblemTitle(ticket.getTitle());
        // todo: заполнение остальных полей
        createTicket();
    }

    /** Заполнение поля "Summary of the problem" */
    public void setProblemTitle(String text) {
        // todo: заполнить поле
    }

    // todo: методы заполнения остальных полей

    /** Зажатие кнопки "Submit Ticket" */
    public void createTicket() {
        // todo: нажать кнопку создания задания
    }

}
