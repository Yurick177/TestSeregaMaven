import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObject.LoginPage;

public class TestLoginAndLogout extends DataFixture {

    public static LoginPage loginPage;
    public final String loginPageUrl = property.getProperty("loginPageUrl");
    public final String positiveLogin = property.getProperty("positiveLogin");
    public final String positivePassword = property.getProperty("positivePassword");
    public final String negativeLogin = property.getProperty("negativeLogin");
    public final String negativePassword = property.getProperty("negativePassword");
    public final String expectedTextLoginAndPositive = "Welcome to the Secure Area. When you are done click logout below.";
    public final String expectedTextLogOutAndNegative = "This is where you can log into the secure area." +
            " Enter tomsmith for the username and " +
            "SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

    @BeforeAll
    public static void start(){
        beforeAllTest();
    }

    @Test
    public void testLoginPositive() {
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        loginPage.authorization(positiveLogin, positivePassword);
        String loginPageTextPositive = loginPage.getLoginPageText();
        Assertions.assertEquals(expectedTextLoginAndPositive, loginPageTextPositive);
    }

    @Test
    public void testPageAuthorizationNegative() {
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        loginPage.authorization(negativeLogin, negativePassword);
        String loginPageTextNegative = loginPage.getLoginPageText();
        Assertions.assertEquals(expectedTextLogOutAndNegative, loginPageTextNegative);
    }


    @Test
    public void testPageLogoutFromAuthorization() {
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        loginPage.authorization(positiveLogin, positivePassword);
        loginPage.clickLogOut();
        String logOutPageText = loginPage.getLogOutPageText();
        Assertions.assertEquals(expectedTextLogOutAndNegative, logOutPageText);
    }

}
