package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameField;
    private final By passwordField;
    //найди по другому локатору эту кнопку. По css например. И тут ты находишь по тегу i и его тексту и жмешь на элемент. Жми на кнопку, тег button
    //Если есть возможность просто найти не по тексту, то ищи не по тексту
    private final By signInButton;
    private final By logOutButton;
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameField = By.id("username");
        passwordField = By.id("password");
        signInButton = By.cssSelector(".radius");
        logOutButton = By.className("button secondary radius");
    }

    public void authorization(String name, String password) {
        driver.findElement(usernameField).sendKeys(name);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).submit();
    }

    public void clickLogOut() {
        //локатор также вынеси в шапку. Даже если он используется один раз, выглядит красивее и понятнее.
        //когда у тебя будет написано  driver.findElement(logOutButton).click() будет все достаточно ясно
        //ПО локатору лучше будет жать на css="a.button" или className="button", посмотришь в дереве страницы
        driver.findElement(logOutButton).click();
    }

    public String actualText() {
        return driver.findElement(By.className("subheader")).getText();
    }

}
