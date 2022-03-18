package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

public class CartMenuPage extends TestBase {
    public WebElement quantity = driver.findElement(By.cssSelector("#cart span.quantity"));
    public static WebElement getQuantity() {
        return (new CartMenuPage()).quantity;
    }
    public  WebElement checkOut = driver.findElement(By.className("link"));
    public static WebElement getCheckuot() {
        return (new CartMenuPage()).checkOut;
    }
}
