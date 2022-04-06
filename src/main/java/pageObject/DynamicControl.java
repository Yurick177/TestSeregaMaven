package pageObject;

import options.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class DynamicControl extends BaseDriver {

    private final WebDriverWait webDriverWait;
    private final By checkbox = By.xpath("//input[@type='checkbox']");

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement buttonRemove;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    private WebElement buttonEnable;

    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement clickableLine;

    public DynamicControl() {
        PageFactory.initElements(driver, this);
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

    public void clickButtonRemove() {
        buttonRemove.click();
    }

    public boolean isClickableLine() {
        return clickableLine.isEnabled();
    }

    public void clickButtonEnableOrDisable() {
        buttonEnable.click();

    }

    public void waitClickableLine() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickableLine));
    }

    public void waitNotClickableLine() {
        webDriverWait.until(not(ExpectedConditions.elementToBeClickable(clickableLine)));
    }

}

