import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DataFixture {
    protected static WebDriver driver;
    protected static Properties property;

    @BeforeAll
    public static void beforeAllTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        property = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.out.println("Файл свойств отсутствует");
        }
    }

    @BeforeEach
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

