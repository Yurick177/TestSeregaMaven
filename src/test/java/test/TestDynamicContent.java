package test;

import options.DataFixture;
import org.junit.jupiter.api.Test;
import pageObject.DynamicElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestDynamicContent extends DataFixture {

    public static DynamicElement dynamicElement;
    public final String dynamicContentUrl = property.getProperty("dynamicContentUrl");
    boolean dynamicContentIsPresent;

    @Test
    public void testDynamicContent() {
        dynamicElement = new DynamicElement(dynamicContentUrl);
        List<String> oldPicturesAndText = dynamicElement.getImgSrc();
        System.out.println(oldPicturesAndText);
        dynamicElement.getClick();
        List<String> newPicturesAndText = dynamicElement.getImgSrc();

//        Эта часть вообще не нужна, так как в конце ты в ассерт передаешь 2 списка. dynamicContentIsPresent нигде не используется
        dynamicContentIsPresent = false;
        for (int i = 0; i < oldPicturesAndText.size(); i++) {
            String old = oldPicturesAndText.get(i);
            String current = newPicturesAndText.get(i);
//            if(oldPicturesAndText.get(i).equals(newPicturesAndText.get(i)))
            if (!old.equals(current)) {
                dynamicContentIsPresent = true;
                break;
            }
        }
        assertNotEquals(oldPicturesAndText, newPicturesAndText);
    }

}
