package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;


public class LoginPage implements PageObject {

    private final SelenideElement usernameField = $(By.id("username"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement signInButton = $(By.cssSelector(".radius"));
    private final SelenideElement logOutButton = $(By.className("button"));
    private final SelenideElement loginPageText = $(By.className("subheader"));
    private final SelenideElement logOutPageText = $(By.className("subheader"));

    public LoginPage(String url) {
        Selenide.open(url);
    }


    // удобно использовать для пэйджобджэктов паттерн цепочка обязанностей https://refactoring.guru/ru/design-patterns/chain-of-responsibility
    //его суть в том, что метод может возвращать пэйджОбджэкт.
    //Например, если после вызова этого метода был неудачный логин, то вернуть LoginPage, иначе вернуть pageObject страницы успешного логина.
    //Для этого я создавал пустой интерфейс и мои ПО имплементили его.
    public PageObject authorization(String name, String password) {
        String loginPageUrl = url();
        usernameField.setValue(name);
        passwordField.setValue(password);
        signInButton.click();
        if (url().equals(loginPageUrl))
            return this;
        else
            return new MainPage();
    }

    //методы, которые используются только внутри класса делай приватными
    public void clickLogOut() {
        logOutButton.click();
    }

    public String getLoginPageText() {
        return loginPageText.text();
    }

    public String getLogOutPageText() {
        return logOutPageText.getText();
    }

}
