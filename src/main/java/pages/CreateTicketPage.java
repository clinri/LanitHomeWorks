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
    //         Select queueSelect = new Select(webDriver.findElement(By.xpath("//select[@id='id_queue']")));
    //        queueSelect.getOptions().forEach(option -> {
    //            System.out.println(option.getText());
    //        });
    //        queueSelect.selectByValue("1");
    //        webDriver.findElement(By.xpath("//input[@id='id_title']")).sendKeys("Тестовое название ошибки");
    //        webDriver.findElement(By.xpath("//textarea[@id='id_body']")).sendKeys("Тестовое описание ошибки");
    //        Select prioritySelect = new Select(webDriver.findElement(By.xpath("//select[@id='id_priority']")));
    //        queueSelect.getOptions().forEach(option -> {
    //            System.out.println(option.getText());
    //        });
    //        prioritySelect.selectByValue("1");
    //        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //        LocalDateTime dueLocalDate = LocalDateTime.now().plus(5, ChronoUnit.DAYS);
    //        String dueDate = dtf.format(dueLocalDate);
    //        webDriver.findElement(By.xpath("//input[@id='id_due_date']")).sendKeys(dueDate + " 00:00:00");
    //        webDriver.findElement(By.xpath("//input[@id='id_submitter_email']")).sendKeys("test@ya.ru");

    /** Зажатие кнопки "Submit Ticket" */
    public void createTicket() {
        // todo: нажать кнопку создания задания
    }

}
