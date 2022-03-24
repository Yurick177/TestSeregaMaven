package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicElement {

    private final WebDriver driver;
    private final By pictureAndText = By.xpath("//div[@class = 'large-2 columns']");
    private final By clickHereLink = By.xpath("//a[@href='/dynamic_content?with_content=static']");

    public DynamicElement(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getImgSrc() {
        List<WebElement> elements = driver.findElements(pictureAndText);
        List<String> picturesAndText = new ArrayList<>();
        for (WebElement i : elements) {
            picturesAndText.add(i.findElement(By.tagName("img")).getAttribute("src"));

        }
        return picturesAndText;
    }

    public void getClick() {
        driver.findElement(clickHereLink).click();
    }

}

