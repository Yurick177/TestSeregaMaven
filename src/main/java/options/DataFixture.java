package options;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFixture {
//    protected static WebDriver driver;
    protected static Properties property;

    @BeforeAll
    public static void beforeAllTest() {
//        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "chrome";
//        Configuration.driverManagerEnabled = true;
//        Configuration.browserSize = "1920x1080";
//        Configuration.headless = true; // false если не хотим чтобы отображалось то, что делается во время теста в браузере
//       driver = new ChromeDriver();
//        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        property = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.out.println("Файл свойств отсутствует");
        }
    }

    @AfterAll
    public static void afterTest() {
        Selenide.closeWebDriver();
//        driver.close();
    }

}

