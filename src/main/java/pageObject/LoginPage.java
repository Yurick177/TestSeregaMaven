package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement usernameField = $(By.id("username"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement signInButton = $(By.cssSelector(".radius"));
    private final SelenideElement logOutButton = $(By.className("button"));
    private final SelenideElement loginPageText = $(By.className("subheader"));
    private final SelenideElement logOutPageText = $(By.className("subheader"));

    public LoginPage(String url) {
        Selenide.open(url);
    }

    public void authorization(String name, String password) {
        usernameField.setValue(name);
        passwordField.setValue(password);
        signInButton.click();
    }

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
