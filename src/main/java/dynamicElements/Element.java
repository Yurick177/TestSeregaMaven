package dynamicElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Element {

    @FindBy(css = "div.large-centered > div.row")
    private List<WebElement> elementList ;

    public List<WebElement> getElementList() {
        return elementList;
    }

}
