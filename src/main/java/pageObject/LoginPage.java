package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import options.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $x("username");
    private final SelenideElement passwordField = $x("password");
    private final SelenideElement signInButton = $x(".radius");
    private final SelenideElement logOutButton = $x("button");
    private final SelenideElement loginPageText = $x("subheader");
    private final SelenideElement logOutPageText = $x("subheader");

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
