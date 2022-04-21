package test;

import options.DataFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.DynamicControl;

public class TestDynamicControls extends DataFixture {

    DynamicControl dynamicControl;
    public String dynamicControlsUrl = property.getProperty("dynamicControlsUrl");

    @BeforeEach
    public void beforeEach() {
        dynamicControl = new DynamicControl(dynamicControlsUrl);
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
    public void changeLineStateToClickable() {
        if (!dynamicControl.isClickableLine()) {
            dynamicControl.clickButtonEnableOrDisable();
            dynamicControl.waitClickableLine();
            Assertions.assertTrue(dynamicControl.isClickableLine());
        }
    }

    //этот тест прям верх гениальности и находчивости)))
    //если ты пройдешь дебагом, то ты увидишь, что в этом тесте выполнится только одна строка с условием if
    //у нас поле некликабельное, а условие в иф будет выполнятся только в случае если оно кликабельно. потому тест проходит мимо строк
    //
    @Test
    public void changeLineStateToNotClickable() {
        if (!dynamicControl.isClickableLine()) {
            dynamicControl.clickButtonEnableOrDisable();
            dynamicControl.waitNotClickableLine();
            Assertions.assertTrue(dynamicControl.isClickableLine());
        }
    }

}
