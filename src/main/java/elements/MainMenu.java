package elements;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** Элемент главного меню */
public class MainMenu {

    private WebDriver driver;

    // Поиск элементов без аннотации
    private WebElement newTicketBtn = driver.findElement(By.xpath(""));

    // todo: остальные элементы меню

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void newTicket() {
        // todo: нажать кнопку создания нового тикета
    }

    public void logIn() {
        // todo: нажать кнопку авторизации
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */
    public MainMenu setSearch(String text) {
        // todo: ввести значение в поле поиска
        return this;
    }

    public void search() {
        // todo: нажать кнопку поиска
    }

}
