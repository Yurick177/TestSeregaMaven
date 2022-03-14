import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DynamicControl;
import pageObject.DynamicElement;
import pageObject.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class TestLocation extends Util {
    public static DynamicControl dynamicControl;
    public static DynamicElement dynamicElement;
    public static LoginPage loginPage;
    public static WebDriver driver;
    public String expectedText = "This is where you can log into the secure area. Enter tomsmith for the username and " +
            "SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

    /*
        Конфигурации выносить в отдельный класс, название типо "DataFixture", в нем выполнять @Before, @After и тд.
        Создание объектов страниц (pageObject.DynamicElement, pageObject.DynamicControl) выполнять в самом тесте, а не в конфигурации.
        Класс Element убрать.
        Выпилить @FindBy
        После каждого теста закрывай драйвер driver.quit(), перед каждым тестом создавай новый экземпляр драйвера driver = new ChromeDriver().

    */
    @BeforeAll
    public static void before() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
        dynamicElement = new DynamicElement(driver);
//        dynamicControl = new DynamicControl();
    }

    @Test
    public void testPageAuthorizationPositive() {
        //Класс Util убрать, все данные хранить в файле testData.properties
        //https://devcolibri.com/%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B9-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%81-property-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0%D0%BC%D0%B8-%D0%B2-java/
        //Необходимые данные вынести в переменные, в шапку класса.

        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_POSITIVE, Util.LOGIN_PASSWORD_POSITIVE);

        //В тесте не надо работать с локаторами. Сделай метод в пэйдже, который будет возвращать то, что тебе необходимо в тесте.

        String actText = driver.findElement(By.className("subheader")).getText();
        String expeText = "Welcome to the Secure Area. When you are done click logout below.";
        Assertions.assertEquals(expeText, actText);
    }

    @Test
    public void testPageAuthorizationNegative() {
        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_NEGATIVE, Util.LOGIN_PASSWORD_NEGATIVE);
        driver.findElement(By.className("radius")).submit();

        //В тесте не надо работать с локаторами. Сделай метод в пэйдже, который будет возвращать то, что тебе необходимо в тесте.
        //Причем ту тстроки 48 и 60 абсолютно одинаковые, не должно быть дублирование кода, все в пэджобджект в метод.

        String actualText = driver.findElement(By.className("subheader")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void testPageLogoutFromAuthorization() {
        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_POSITIVE, Util.LOGIN_PASSWORD_POSITIVE);
        loginPage.clickLogOut();
        //Выше описал
        String actualText = driver.findElement(By.className("subheader")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }

//    @Test
//    public void testDynamicContent() throws InterruptedException {
//        //URL в property
//        driver.get("http://the-internet.herokuapp.com/dynamic_content?with_content=static");
//        PageFactory.initElements(driver, element);
//        boolean isDynamicElement = dynamicElement.resultDynamicContent(element.getElementList(), driver);
//        assertTrue(isDynamicElement);
//    }

    @Test
    public void testDynamicControl() {
        //URL в property
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void testDynamicElement() {
        driver.get("http://the-internet.herokuapp.com/dynamic_content");
        dynamicElement.hasDynamicContent();

    }
}
