import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Run {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\FAMILY\\Yura\\webDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("http://the-internet.herokuapp.com/login");
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.xpath("//i[text()=\" Login\"]")).submit();
        } catch (Exception e) {
            System.out.println("ошибка");
        } finally {
//            driver.quit();

        }

    }
}
