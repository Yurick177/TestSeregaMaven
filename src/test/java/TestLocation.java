import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestLocation {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testPositive() {
        driver.get(Util.URL);
        driver.findElement(By.id("username")).sendKeys(Util.LOGIN_NAME_POSITIVE);
        driver.findElement(By.id("password")).sendKeys(Util.LOGIN_PASSWORD_POSITIVE);
        driver.findElement(By.xpath("//i[text()=' Login']")).submit();
        String actText = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        String expeText = "Welcome to the Secure Area. When you are done click logout below.";
        Assertions.assertEquals(expeText, actText);

    }

    @Test
    public void testNegative() {
        driver.get(Util.URL);
        driver.findElement(By.id("username")).sendKeys(Util.LOGIN_NAME_NEGATIVE);
        driver.findElement(By.id("password")).sendKeys(Util.LOGIN_PASSWORD_NEGATIVE);
        driver.findElement(By.xpath("//i[text()=' Login']")).submit();
        String actualText = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        String expectedText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
        Assertions.assertEquals(expectedText,actualText);

    }
    @Test
    public void testLogOut(){
        driver.get(Util.URL);
        driver.findElement(By.id("username")).sendKeys(Util.LOGIN_NAME_POSITIVE);
        driver.findElement(By.id("password")).sendKeys(Util.LOGIN_PASSWORD_POSITIVE);
        driver.findElement(By.xpath("//i[text()=' Login']")).submit();
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
        String actualText = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        String expectedText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
        Assertions.assertEquals(expectedText,actualText);
    }


}
