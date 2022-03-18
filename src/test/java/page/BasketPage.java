package page;

import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

import static org.openqa.selenium.By.className;

public class BasketPage extends TestBase {
    public WebElement shortcut = driver.findElement(className("shortcut"));
    public static WebElement getShortcut() {
        try {
            return (new BasketPage()).shortcut;
        }catch (Exception e){
            return null;
        }

    }

    public List<WebElement> shortcuts = driver.findElements(className("shortcut"));
    public static List<WebElement> getShortcuts() {
        return (new BasketPage()).shortcuts;
    }
}
