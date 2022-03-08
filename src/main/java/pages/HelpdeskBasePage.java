package pages;

import elements.MainMenu;

/** Базовая страница с элементами, доступными на всех страницах наследниках */
public class HelpdeskBasePage extends AbstractPage {

    /** Доступ к элементам главного меню */
    public MainMenu mainMenu() {
        return new MainMenu(driver);
    }
}
