package test;

import com.codeborne.selenide.Selenide;
import options.DataFixture;
import org.junit.jupiter.api.*;
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
    public static void start() {

    }

    @Test
    public void testLoginPositive() {
        Selenide.open("https://mail.ru/");
//        loginPage = new LoginPage(loginPageUrl);
//        loginPage.authorization(positiveLogin, positivePassword);
//        String loginPageTextPositive = loginPage.getLoginPageText();
//        Assertions.assertEquals(expectedTextLoginAndPositive, loginPageTextPositive);
    }

    @Test
    public void testPageAuthorizationNegative() {
        loginPage.authorization(negativeLogin, negativePassword);
        String loginPageTextNegative = loginPage.getLoginPageText();
        Assertions.assertEquals(expectedTextLogOutAndNegative, loginPageTextNegative);
    }

    @Test
    public void testPageLogoutFromAuthorization() {
        loginPage.authorization(positiveLogin, positivePassword);
        loginPage.clickLogOut();
        String logOutPageText = loginPage.getLogOutPageText();
        Assertions.assertEquals(expectedTextLogOutAndNegative, logOutPageText);
    }

}
