package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class BasketPage extends TestBase {

    public static WebElement getShortcut() {
        try {
            return (new BasketPage()).shortcut;
        } catch (Exception e) {
            return null;
        }
    }
    public static List<WebElement> getShortcuts() {
        try {
            return (new BasketPage()).shortcuts;
        } catch (Exception e) {
            return null;
        }
    }



    public List<WebElement> shortcuts = driver.findElements(new By.ByClassName("shortcut"));
    public WebElement shortcut = driver.findElement(new By.ByClassName(("shortcut")));


}
