package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControl {

    private final SelenideElement checkbox = $(By.xpath("//input[@type='checkbox']"));
    private final SelenideElement buttonRemove = $(By.xpath("//button[@onclick='swapCheckbox()']"));
    private final SelenideElement buttonEnable = $(By.xpath("//button[@onclick='swapInput()']"));
    private final SelenideElement clickableLine = $(By.xpath("//input[@type = 'text']"));

    public DynamicControl(String url) {
        Selenide.open(url);
    }

    public void clickButtonRemoveAndAddCheckbox() {
        if (checkboxPresent()) {
            clickButtonRemove();
            checkbox.shouldNotBe(Condition.exist);
        } else {
            clickButtonRemove();
            checkbox.shouldBe(Condition.exist);
        }
    }

    public boolean clickCheckbox() {
        checkbox.click();
        return checkbox.isSelected();
    }

    public boolean getCheckboxStatus() {
        return checkbox.isSelected();
    }

    public boolean checkboxPresent() {
        return checkbox.exists();
    }

    public void clickButtonRemove() {
        buttonRemove.click();
    }

    public boolean isClickableLine() {
        return clickableLine.isEnabled();
    }

    public void clickButtonEnableOrDisable() {
        buttonEnable.click();

    }

    public void waitClickableLine() {
        clickableLine.shouldBe(Condition.enabled);
    }

    public void waitNotClickableLine() {
        clickableLine.shouldNotBe(Condition.disabled);
    }

}
