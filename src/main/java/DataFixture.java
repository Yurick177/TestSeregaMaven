import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DynamicControl;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFixture {
    protected static WebDriver driver;
    protected static Properties property;
    protected static DynamicControl dynamicControl;

    public static void beforeAllTest() {
        driver = new ChromeDriver();
        dynamicControl = new DynamicControl(driver);
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
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
        driver.quit();
    }

}

