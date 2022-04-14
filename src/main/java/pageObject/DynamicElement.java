package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DynamicElement {

    private final List<SelenideElement> pictureAndText = $$(By.xpath("//div[@class = 'large-10 columns large-centered']"));
    private final SelenideElement clickHereLink = $(By.linkText("click here"));

    public DynamicElement(String Url) {
        Selenide.open(Url);
    }

    public List<String> getImgSrc() {
        List<String> picturesAndText = new ArrayList<>();
        for (SelenideElement i : pictureAndText) {
            picturesAndText.add(i.$(By.tagName("img")).getAttribute("src"));
            picturesAndText.add(i.$(By.className("large-10")).getText());

        }
        return picturesAndText;
    }

    public void getClick() {
        clickHereLink.click();
    }

}

