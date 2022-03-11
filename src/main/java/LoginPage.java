import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signInButton = By.xpath("//i[text()=' Login']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authorization(String name, String password) {
        driver.findElement(usernameField).sendKeys(name);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).submit();
    }

    public void LogoutFromAuthorization(){
//        driver.findElement(usernameField).sendKeys(name);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(signInButton).submit();
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
    }
}
