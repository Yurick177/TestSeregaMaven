import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
        driver = new ChromeDriver();
    }

    @AfterEach
    public void afterTest() {
        driver.quit();
    }

}

