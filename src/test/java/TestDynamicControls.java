import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageObject.DynamicControl;

public class TestDynamicControls extends DataFixture {

    private static DynamicControl dynamicControl;
    private final String dynamicControlsUrl = property.getProperty("dynamicControlsUrl");

    @Test
    public void presentCheckbox() {
        driver.get(dynamicControlsUrl);
        dynamicControl = new DynamicControl(driver);
        Assertions.assertTrue(dynamicControl.checkboxPresent());
    }

    @Test
    public void statusCheckboxNoIsSelected() {
        driver.get(dynamicControlsUrl);
        dynamicControl = new DynamicControl(driver);
        Assertions.assertFalse(dynamicControl.getCheckboxStatus());

    }

    @Test
    public void statusCheckboxIsSelected() {
        driver.get(dynamicControlsUrl);
        dynamicControl = new DynamicControl(driver);
        Assertions.assertTrue(dynamicControl.clickCheckbox());
    }

    @Test
    public void clickButtonRemove() {
        driver.get(dynamicControlsUrl);
        dynamicControl = new DynamicControl(driver);
        dynamicControl.clickButtonRemoveAndAddCheckbox();
        Assertions.assertFalse(dynamicControl.checkboxPresent());
        dynamicControl.clickButtonRemoveAndAddCheckbox();
        Assertions.assertTrue(dynamicControl.checkboxPresent());
    }

    @Test
    public void clickableLineIsEnable() {
        driver.get(dynamicControlsUrl);
        dynamicControl = new DynamicControl(driver);
        Assertions.assertFalse(dynamicControl.clickableLine());
    }

//    @Test
//    public void clickButtonEnable() throws InterruptedException {
//        driver.get(dynamicControlsUrl);
//        dynamicControl = new DynamicControl(driver);
//        dynamicControl.clickButtonEnable();
//        Assertions.assertTrue(dynamicControl.clickableLine());
//        //надо написать wait
//    }
//тест активна ли строка ввода(кликабельна)
    // нажать на кнопку и проверить или она нажалась
    // стала ли кликабельной строка


}
