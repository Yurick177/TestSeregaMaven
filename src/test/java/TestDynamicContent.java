import org.junit.jupiter.api.Test;
import pageObject.DynamicElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDynamicContent extends DataFixture {

    public static DynamicElement dynamicElement;
    public final String dynamicContentUrl = property.getProperty("dynamicContentUrl");

    @Test
    public void testDynamicContent() {
        dynamicElement = new DynamicElement(driver);
        driver.get(dynamicContentUrl);
        List<String> oldPicturesAndText = dynamicElement.getImgSrc();
        dynamicElement.getClick();
        List<String> newPicturesAndText = dynamicElement.getImgSrc();
        boolean dynamicContentIsPresent = false;
        for (int i = 0; i < oldPicturesAndText.size(); i++) {
            String old = oldPicturesAndText.get(i);
            String current = newPicturesAndText.get(i);
            if (!old.equals(current)) {
                dynamicContentIsPresent = true;
                break;
            }
        }
        assertTrue(dynamicContentIsPresent);
        assertNotEquals(oldPicturesAndText, newPicturesAndText);

    }

}
