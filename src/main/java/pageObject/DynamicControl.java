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
            // если метод использыется только внутри класса и не предполагается его использование в других местах, то модификатор доступа private
            // А в твоём случае метод используется только внутри класса, да и сам он содержит только одну троку, которая делает клие
            // нет смысла делать новый метод
            // просто пишешь
            // buttonRemove.click();
            clickButtonRemove();
            checkbox.shouldNotBe(Condition.exist);
        } else {
            // buttonRemove.click();
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
        //при нажатии на кнопку появляется полоса загрузки
        //есть смысл в этом методе после клика добавить ожидание пока эта полоса исчезнет
        //но учти, что в dom есть такие 2 полосы.
        // тогда у тебя пропадет необходимость в последних двух методах и не будет ненужных строк в тесте
        //             dynamicControl.waitClickableLine();
        buttonEnable.click();

    }

    public void waitClickableLine() {
        clickableLine.shouldBe(Condition.enabled);
    }

    public void waitNotClickableLine() {
        clickableLine.shouldNotBe(Condition.disabled);
    }

}
