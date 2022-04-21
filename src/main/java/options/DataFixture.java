package options;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFixture {

    protected static Properties property;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true; // true если не хотим чтобы отображалось то, что делается во время теста в браузере
        property = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.out.println("Файл свойств отсутствует");
        }
    }

    @BeforeAll
    public static void start() {
        setUp();
    }

    public static void afterTest() {
        Selenide.closeWebDriver();
//        driver.close();
    }

}

