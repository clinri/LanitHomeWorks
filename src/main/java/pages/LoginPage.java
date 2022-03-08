package pages;

import org.openqa.selenium.support.PageFactory;

/** Страница авторизации */
public class LoginPage extends HelpdeskBasePage {

    // todo: элементы страницы

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    public void login(String user, String password) {
        // todo: заполнить поля и нажать кнопку авторизации
    }

    // todo: методы работы с элементами

}
