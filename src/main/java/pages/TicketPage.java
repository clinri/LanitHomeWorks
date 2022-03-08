package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница отдельного тикета */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "")
    WebElement ticketTitle;

    // todo: остальные поля тикета

    @FindBy(xpath = "//th[text()='Submitter E-Mail']")
    WebElement email;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    /** Получить имя тикета */
    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    /** Получить адрес почты */
    public String getEmail() {
        // Получаем значение адреса почты
        return getValue(email);
    }

    // todo: остальные методы получения значений полей

    /**
     * Получить значение элемента таблицы
     *
     * @param columnElem элемент ячейки для которой нужно вернуть значение
     * @return текстовое значение ячейки рядом
     */
    private String getValue(WebElement columnElem) {
        return columnElem
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::td[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }

}
