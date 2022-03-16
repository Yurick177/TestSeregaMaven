package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicElement {

    private final WebDriver driver;
    private final By pictureAndText;
    private final By clickHereLink;


    public DynamicElement(WebDriver driver) {
        this.driver = driver;
        pictureAndText = By.xpath("//div[@class = 'large-2 columns']");
        clickHereLink = By.xpath("//a[@href='/dynamic_content?with_content=static']");
    }

    public boolean hasDynamicContent() {
        List<WebElement> oldElements = driver.findElements(pictureAndText);
        List<String> oldPicturesAndText = new ArrayList<>();
        for (WebElement i : oldElements) {
            oldPicturesAndText.add(i.findElement(By.tagName("img")).getAttribute("src"));
        }
        driver.findElement(clickHereLink).click();
        List<WebElement> newElements = driver.findElements(pictureAndText);
        List<String> newPicturesAndText = new ArrayList<>();
        for (WebElement i : newElements) {
            newPicturesAndText.add(i.findElement(By.tagName("img")).getAttribute("src"));
        }
        newPicturesAndText.removeAll(oldPicturesAndText);
        return newPicturesAndText.isEmpty();
    }


    /*
                Вынести необходимые переменные в шапку, написать простые и понятные методы.
                 */

}

