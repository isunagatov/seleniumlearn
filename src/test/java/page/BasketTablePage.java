package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class BasketTablePage extends TestBase {
    public WebElement tableBasket = driver.findElement(new By.ByCssSelector("#order_confirmation-wrapper > table > tbody"));
    public static WebElement getTable() {
        return (new BasketTablePage()).tableBasket;
    }

    public static List<WebElement> getShortcuts() {
        try {
            return  driver.findElements(new By.ByClassName("shortcut"));
        } catch (Exception e) {
            return null;
        }
    }
    public static WebElement getRemoveButton() {
        return new BasketTablePage().removeButton;
    }
    public WebElement removeButton = driver.findElement(By.name("remove_cart_item"));
}
