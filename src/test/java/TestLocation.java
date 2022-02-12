import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestLocation {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\FAMILY\\Yura\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testPositive() {
        try {
            driver.get(Util.URL);
            driver.findElement(By.id("username")).sendKeys(Util.LOGIN_NAME_POSITIVE);
            driver.findElement(By.id("password")).sendKeys(Util.LOGIN_PASSWORD_POSITIVE);
            driver.findElement(By.xpath("//i[text()=\" Login\"]")).submit();
            wait.until(presenceOfElementLocated(By.xpath("//i[@class='icon-2x icon-signout']"))).click();
        } catch (Exception e) {
            System.out.println("ошибка");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testNegative() {
        try {
            driver.get(Util.URL);
            driver.findElement(By.id("username")).sendKeys(Util.LOGIN_NAME_NEGATIVE);
            driver.findElement(By.id("password")).sendKeys(Util.LOGIN_PASSWORD_NEGATIVE);
            driver.findElement(By.xpath("//i[text()=\" Login\"]")).submit();
        } catch (Exception e) {
            System.out.println("ошибка");
        } finally {
            driver.quit();
        }
    }

}
