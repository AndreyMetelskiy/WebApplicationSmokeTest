import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPageTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @BeforeClass
    public static void keeper() {
        //URL удаленного веб-драйвера
        Configuration.remote = "http://selenoid.intexsoft.by:4444/wd/hub/";
        //Определяем какой браузер использовать
        Configuration.browser = "chrome";
        //Размер окна браузера
        Configuration.browserSize = "1920x1080";
        //Создаём объект класса DesiredCapabilities, используются как настройка вашей конфигурации с помощью пары ключ-значение.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC", true);
        //Включение записи видео в процессе выполнения тестов
        capabilities.setCapability("enableVideo", true);
        //Переопределяем Browser capabilities
        capabilities.setCapability("enableLog", true);
        Configuration.browserCapabilities = capabilities;
        //Property baseurl, которое находится в классе Configuration и будет являтся базовым url
        baseUrl = "https://expkeeper.intexsoft.by";
        open("/");
    }

    @Before
    public void before() {
        open("/");
        System.out.println("START TEST");
    }

    @Test
    public void buttonLoginTest() { //Теси доступности кнопки log in
        authorizationPage.buttonLoginAvailability();
    }

    @Test
    public void userAuthorizationTest() { // Тест на проверку возможности авторизации пользователя
        authorizationPage.fillingName();
        authorizationPage.fillingPassword();
        authorizationPage.clickLoginBtn();
        authorizationPage.employeesCheck();
    }

    @Test
    public void userAuthorizationTest2() { // Тест на проверку возможности авторизации пользователя
        authorizationPage.fillingName();
        authorizationPage.fillingPassword();
        authorizationPage.urlCheck();
    }

    @Test
    public void validationMessagePasswordTest() { // Тест на проверку появления валидационного сообщения при вводе некорректного пароля
        authorizationPage.fillingName();
        authorizationPage.fillingIncorrectPassword();
        authorizationPage.clickLoginBtn();
        authorizationPage.validationMessage();
    }

    @Test
    public void validationMessageNameTest() { // Тест на проверку появления валидационного сообщения при вводе некорректного имени
        authorizationPage.fillingIncorrectName();
        authorizationPage.fillingPassword();
        authorizationPage.clickLoginBtn();
        authorizationPage.validationMessage();
    }

    @Test
    public void eKeeperLinkTestEnabled() { //Тестирование доступности ссылки на странице авторизации
        authorizationPage.eKeeperLinkEnabled();
    }

    @Test
    public void eKeeperLinkTestCorrect() { //Тестирование корректности ссылки на странице авторизации
        authorizationPage.eKeeperLinkCorrect();
    }

    @Test
    public void eKeeperLinkTestClick() { //Тестирование кликабельности ссылки на странице авторизации
        authorizationPage.eKeeperLinkClick();
    }

    @Test
    public void hamburgerMenuAvailability() { //Тестирование доступности кнопки меню на странице авторизации
        authorizationPage.hamburgerMenuAvailability();
    }

    @Test
    public void hamburgerMenuClick() { //Тестирование кликабельности кнопки меню на странице авторизации
        authorizationPage.hamburgerMenuClick();
    }

    @Test
    public void hamburgerMenuWork() { //Тестирование работы кнопки меню на странице авторизации
        authorizationPage.containerOpen();
        authorizationPage.hamburgerMenuClick();
        authorizationPage.containerClose();
    }
}

