import dynamicElements.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLocation extends Util {
    //
    public static DynamicControl dynamicControl;
    public static Element element;
    public static DynamicElement dynamicElement;
    public static LoginPage loginPage;
    public static WebDriver driver;
    public String expectedText = "This is where you can log into the secure area. Enter tomsmith for the username and " +
            "SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

    @BeforeAll
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        element = new Element();
        dynamicElement = new DynamicElement();
        dynamicControl = new DynamicControl();
    }

    @Test
    public void testPageAuthorizationPositive() {
        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_POSITIVE, Util.LOGIN_PASSWORD_POSITIVE);
        String actText = driver.findElement(By.className("subheader")).getText();
        String expeText = "Welcome to the Secure Area. When you are done click logout below.";
        Assertions.assertEquals(expeText, actText);
    }

    @Test
    public void testPageAuthorizationNegative() {
        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_NEGATIVE, Util.LOGIN_PASSWORD_NEGATIVE);
        driver.findElement(By.className("radius")).submit();
        String actualText = driver.findElement(By.className("subheader")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void testPageLogoutFromAuthorization() {
        driver.get(Util.URL);
        loginPage.authorization(Util.LOGIN_NAME_POSITIVE, Util.LOGIN_PASSWORD_POSITIVE);
        loginPage.LogoutFromAuthorization();
        String actualText = driver.findElement(By.className("subheader")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void testDynamicContent() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_content?with_content=static");
        PageFactory.initElements(driver, element);
        boolean isDynamicElement = dynamicElement.resultDynamicContent(element.getElementList(), driver);
        assertTrue(isDynamicElement);
    }

    @Test
    public void testDynamicControl(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

}
