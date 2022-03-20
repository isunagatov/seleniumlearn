package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class BasketShortcutsPage extends TestBase {


    public static List<WebElement> getShortcuts() {
        try {
            return (new BasketPage()).shortcuts;
        } catch (Exception e) {
            return null;
        }
    }
    public List<WebElement> shortcuts = driver.findElements(new By.ByClassName("shortcut"));
}
