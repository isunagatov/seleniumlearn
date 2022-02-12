package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

public class GooglePage extends TestBase {
    public static WebElement inputText = driver.findElement(By.cssSelector("input"));
    public static WebElement submitButton = driver.findElement(By.name("btnK"));

}
