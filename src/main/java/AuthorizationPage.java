import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AuthorizationPage {
    {
        Configuration.baseUrl = "https://expkeeper.intexsoft.by";
    }

    SelenideElement authorizationForm = $x("//body/app[1]/div[1]/div[1]/ng-component[1]/div[1]/form[1]");
    SelenideElement usernameField = $x("//input[@id='username']");
    SelenideElement passwordField = $x("//input[@id='password']");
    SelenideElement loginButton = $x("//button[contains(text(),'Log in')]");
    SelenideElement expertiseKeeperLink = $x("//app-header/div[1]/div[1]/a[1]");
    SelenideElement hamburgerMenu = $x("//app-header/nav[1]/icon[1]/span[1]");
    SelenideElement invalidLogin = $x("//div[contains(text(),'Invalid login')]");
    SelenideElement menuContainer = $x("/html[1]/body[1]/app[1]/app-header[1]/div[1]");
    SelenideElement menuContainerOpen = $x("//app-header[1]/nav[1]/icon[@class='menu-btn icon icon--medium menu-btn-opened']");
    SelenideElement menuContainerClose = $x("//app-header[1]/nav[1]/icon[@class='menu-btn icon icon--medium']");
    SelenideElement menuContainerEmployees = $x("//span[contains(text(),'Employees')]");

    public void fillingName() { // Заполняем поля login
        usernameField.append("name");
    }

    public void fillingPassword() { // Заполняем поля password
        passwordField.append("password");
    }

    public void fillingIncorrectName() { // Заполняем поля login некорректно
        usernameField.append("error");
    }

    public void fillingIncorrectPassword() { // Заполняем поля password некорректно
        passwordField.append("error");
    }

    public void clickLoginBtn() { //Кликаем по кнопке log in
        loginButton.hover().click();
    }

    public void buttonLoginAvailability() { //Проверяем доступность кнопки log in
        loginButton.isEnabled();
    }

    public void validationMessage() { // Проверяем наличие валидационного сообщения при попытке авторизации и неверно введенных данных
        authorizationForm.find(String.valueOf(invalidLogin));
    }

    public void hamburgerMenuAvailability() { //Проверяем доступность кнопки меню
        hamburgerMenu.isEnabled();
    }

    public void hamburgerMenuClick() { //Проверяем кликабельность кнопки меню
        hamburgerMenu.hover().click();
    }

    public void eKeeperLinkCorrect() { //Проверяем правильность ссылки
        expertiseKeeperLink.shouldHave(href("https://expkeeper.intexsoft.by"));
    }

    public void eKeeperLinkEnabled() { //Проверяем доступность ссылки
        expertiseKeeperLink.isEnabled();
    }

    public void eKeeperLinkClick() { //Проверяем работу ссылки
        expertiseKeeperLink.click();
        String a = "https://expkeeper.intexsoft.by/";
        String pageUrl1 = getWebDriver().getCurrentUrl();
        assertEquals(a, pageUrl1);
    }

    public void containerOpen() { //Проверяем открытие меню
        menuContainer.find(String.valueOf(menuContainerOpen));
    }

    public void containerClose() { //Проверяем закрытие меню
        menuContainer.find(String.valueOf(menuContainerClose));
    }

    public void employeesCheck() { //Проверяем наличие элемента на странице сотрудника после авторизации
        menuContainer.shouldHave((Condition) element(menuContainerEmployees));
    }

    public void urlCheck() { //Проверяем Url на соответствие
        loginButton.hover().click();
        String a = "https://expkeeper.intexsoft.by/employee";
        String pageUrl = getWebDriver().getCurrentUrl();
        assertEquals(a, pageUrl);
    }
}




