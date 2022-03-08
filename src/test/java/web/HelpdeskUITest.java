package web;

import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        // Заполняем объект класс Ticket необходимыми тестовыми данными
        ticket = buildNewTicket();
        // todo: открыть главную страницу
        driver.get(System.getProperty("site.url"));
        // todo: создать объект главной страницы и выполнить шаги по созданию тикета
        // todo: перейти к странице авторизации и выполнить вход
        // todo: найти созданный тикет и проверить поля

        // Закрываем текущее окно браузера
        driver.close();
    }

    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle("Тестовое название проблемы");
        // todo: заполнить остальные необходимые поля тикета
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dueLocalDate = LocalDateTime.now().plus(5, ChronoUnit.DAYS);
        String dueDate = dtf.format(dueLocalDate);
        ticket.setDue_date(dueDate);
        ticket.setSubmitter_email("test@ya.ru");
        ticket.setStatus(1);
        ticket.setDescription("Тестовое описание");
        ticket.setPriority(1);
        ticket.setQueue(1);
        return ticket;
    }

    @AfterTest
    public void close() {
        // Закрываем все окна браузера и освобождаем ресурсы
        driver.quit();
    }

}
