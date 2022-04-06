package options;

import org.openqa.selenium.WebDriver;

public class BaseDriver {

    private final WebDriver driver;

   protected BaseDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
