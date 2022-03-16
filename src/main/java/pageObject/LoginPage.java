package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signInButton = By.cssSelector(".radius");
    private final By logOutButton = By.className("button");
    private final By loginPageText = By.className("subheader");
    private final By logOutPageText = By.className("subheader");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authorization(String name, String password) {
        driver.findElement(usernameField).sendKeys(name);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).submit();
    }

    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }

    public String getLoginPageText() {
        return driver.findElement(loginPageText).getText();
    }

    public String getLogOutPageText(){
        return driver.findElement(logOutPageText).getText();
    }

}
