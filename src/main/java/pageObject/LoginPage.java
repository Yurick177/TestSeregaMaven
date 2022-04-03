package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = ".radius")
    private WebElement signInButton;

    @FindBy(className = "button")
    private WebElement logOutButton;

    @FindBy(className = "subheader")
    private WebElement loginPageText;

    @FindBy(className = "subheader")
    private WebElement logOutPageText;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void authorization(String name, String password) {
        usernameField.sendKeys(name);
        passwordField.sendKeys(password);
        signInButton.submit();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    public String getLoginPageText() {
        return loginPageText.getText();
    }

    public String getLogOutPageText() {
        return logOutPageText.getText();
    }

}
