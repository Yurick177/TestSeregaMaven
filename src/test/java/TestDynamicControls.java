import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestDynamicControls extends DataFixture {

    @BeforeAll
    public static void start(){
        beforeAllTest();
        driver.get(property.getProperty("dynamicControlsUrl"));
    }

    @Test
    public void presentCheckbox() {

        Assertions.assertTrue(dynamicControl.checkboxPresent());
    }

    @Test
    public void statusCheckboxNoIsSelected() {
        Assertions.assertFalse(dynamicControl.getCheckboxStatus());

    }

    @Test
    public void statusCheckboxIsSelected() {
        Assertions.assertTrue(dynamicControl.clickCheckbox());
    }

    @Test
    public void clickButtonRemoveOrAdd() {
        dynamicControl.clickButtonRemoveAndAddCheckbox();
        Assertions.assertFalse(dynamicControl.checkboxPresent());
        dynamicControl.clickButtonRemoveAndAddCheckbox();
        Assertions.assertTrue(dynamicControl.checkboxPresent());
    }

    @Test
    public void changeLineStateToClickable () {
        if(!dynamicControl.isClickableLine()){
            dynamicControl.clickButtonEnableOrDisable();
            dynamicControl.waitClickableLine();
            Assertions.assertTrue(dynamicControl.isClickableLine());
        }
    }

    @Test
    public void changeLineStateToNotClickable() {
        if(dynamicControl.isClickableLine()){
            dynamicControl.clickButtonEnableOrDisable();
            dynamicControl.waitNotClickableLine();
            Assertions.assertFalse(dynamicControl.isClickableLine());
        }
    }


//тест активна ли строка ввода(кликабельна)
//     нажать на кнопку и проверить или она нажалась
//     стала ли кликабельной строка


}
