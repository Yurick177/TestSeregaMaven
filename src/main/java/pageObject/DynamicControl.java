package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;
    private final By buttonRemove = By.xpath("//button[@onclick='swapCheckbox()']");
    private final By checkbox = By.xpath("//input[@type='checkbox']");
    private final By buttonEnable = By.xpath("//button[@onclick=\"swapInput()\"]");
    private final By clickableLine = By.xpath("//input[@type = 'text']");

    public DynamicControl(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickButtonRemoveAndAddCheckbox() {
        if (checkboxPresent()) {
            clickButtonRemove();
            webDriverWait.until(ExpectedConditions.stalenessOf(driver.findElement(checkbox)));
        } else {
            clickButtonRemove();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        }
    }

    public boolean clickCheckbox() {
        WebElement element = driver.findElement(checkbox);
        element.click();
        return element.isSelected();
    }

    public boolean getCheckboxStatus() {
        return driver.findElement(checkbox).isSelected();
    }


    public boolean checkboxPresent() {
        return driver.findElements(checkbox).size() > 0;
    }

    public void clickButtonEnable() throws InterruptedException {
        driver.findElement(buttonEnable).click();
        Thread.sleep(5000);
    }

    public void clickButtonRemove() {
        driver.findElement(buttonRemove).click();
    }
    public boolean clickableLine (){
        return driver.findElement(clickableLine).isEnabled();
    }

}

