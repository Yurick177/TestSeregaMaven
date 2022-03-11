import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    //найди по другому локатору эту кнопку. По css например. И тут ты находишь по тегу i и его тексту и жмешь на элемент. Жми на кнопку, тег button
    //Если есть возможность просто найти не по тексту, то ищи не по тексту
    private final By signInButton = By.xpath("//i[text()=' Login']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authorization(String name, String password) {
        driver.findElement(usernameField).sendKeys(name);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).submit();
    }

    public void LogoutFromAuthorization(){
//        driver.findElement(usernameField).sendKeys(name);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(signInButton).submit();
        //локатор также вынеси в шапку. Даже если он используется один раз, выглядит красивее и понятнее.
        //когда у тебя будет написано  driver.findElement(logOutButton).click() будет все достаточно ясно
        //ПО локатору лучше будет жать на css="a.button" или className="button", посмотришь в дереве страницы
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
    }
}
