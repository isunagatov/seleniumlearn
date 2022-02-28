package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class LiteCartStorePage extends TestBase {
    public static WebElement middleContent = driver.findElement(By.cssSelector("#main > div.middle > div.content"));
    //public static WebElement middleContent = driver.findElement(By.cssSelector("#main > div.middle > div.content"));
    public static List<WebElement> contents = middleContent.findElements(By.className("box"));

    public static List<WebElement> mostPopular = driver.findElements(By.cssSelector("#box-most-popular > div > ul > li")); // Тоже самое что и content, только с явным указаниме что это most-popular
    public static List<WebElement> campaigns = driver.findElements(By.cssSelector("#box-campaigns > div > ul > li"));
    public static List<WebElement> latestProducts = driver.findElements(By.cssSelector("#box-box-latest-products > div > ul > li"));

}
