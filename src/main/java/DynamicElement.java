import dynamicElements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicElement extends Element {

//    public void run(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://the-internet.herokuapp.com/dynamic_content?with_content=static");
//        Element element = new Element();
//        PageFactory.initElements(driver, element);
//        List<WebElement> elementList = element.getElementList();
//    }

    public boolean resultDynamicContent(List<WebElement> elementList, WebDriver driver) throws InterruptedException {
        List<String> oldPictureAndTextElements = new ArrayList<>();
        for (WebElement i : elementList) {
            oldPictureAndTextElements.add(i.findElement(By.tagName("img")).getAttribute("src"));
            oldPictureAndTextElements.add(i.findElement(By.xpath("//div[@class='large-10 columns']")).getText());
        }
        Thread.sleep(10000);
        driver.navigate().refresh();
        List<String> newPictureAndTextElements = new ArrayList<>();
        for (WebElement i : elementList) {
            newPictureAndTextElements.add(i.findElement(By.tagName("img")).getAttribute("src"));
            newPictureAndTextElements.add(i.findElement(By.xpath("//div[@class='large-10 columns']")).getText());
        }
        newPictureAndTextElements.removeAll(oldPictureAndTextElements);
        return !newPictureAndTextElements.isEmpty();
    }
}

