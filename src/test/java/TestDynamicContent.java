import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DynamicElement;

import java.util.List;


public class TestDynamicContent extends DataFixture {

    public static DynamicElement dynamicElement;
    public final String dynamicContentUrl = property.getProperty("dynamicContentUrl");

    @Test
    public void dynamicContent(){
        driver = new ChromeDriver();
        dynamicElement = new DynamicElement(driver);
        driver.get(dynamicContentUrl);
        List<String> oldPicturesAndText = dynamicElement.getImgSrc();
        dynamicElement.getClick();
        List<String> newPicturesAndText = dynamicElement.getImgSrc();
        Assertions.assertFalse(oldPicturesAndText.containsAll(newPicturesAndText));
    }

}
