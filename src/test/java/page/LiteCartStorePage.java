package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class LiteCartStorePage extends TestBase {
    public static WebElement middleContent = driver.findElement(By.cssSelector("#main > div.middle > div.content"));
    //public static WebElement middleContent = driver.findElement(By.cssSelector("#main > div.middle > div.content"));
    public static List<WebElement> contents = middleContent.findElements(By.className("box"));
}
