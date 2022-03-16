import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DynamicElement;

import java.util.List;
import java.util.Properties;


public class TestDynamicContent extends DataFixture {

    @Test
    public void dynamicContent(){
        WebDriver driver = new ChromeDriver();
        DynamicElement dynamicElement = new DynamicElement(driver);
        String dynamicContentUrl = property.getProperty("dynamicContentUrl");
        driver.get(dynamicContentUrl);
        List<String> oldPicturesAndText = dynamicElement.getImgSrc();
        dynamicElement.getClick();
        List<String> newPicturesAndText = dynamicElement.getImgSrc();
        Assertions.assertFalse(oldPicturesAndText.containsAll(newPicturesAndText));
    }

}
