package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

public class LiteCartStartPage extends TestBase {
    public static WebElement emailAddressField = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(1) > td > input[type=text]"));
    public static WebElement passField = driver.findElement(By
            .cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(2) > td > input[type=password]"));
    public static WebElement loginButton = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(4) > td > span > button:nth-child(1)"));


}
