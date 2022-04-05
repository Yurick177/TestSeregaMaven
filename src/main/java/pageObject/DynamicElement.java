package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicElement {

    @FindBy(xpath = "//div[@class = 'large-2 columns']")
    private List<WebElement> pictureAndText;

    @FindBy(linkText = "click here")
    private WebElement clickHereLink;

    public DynamicElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public List<String> getImgSrc() {
        List<String> picturesAndText = new ArrayList<>();
        for (WebElement i : pictureAndText) {
            picturesAndText.add(i.findElement(By.tagName("img")).getAttribute("src"));

        }
        return picturesAndText;
    }

    public void getClick() {
        clickHereLink.click();
    }

}

