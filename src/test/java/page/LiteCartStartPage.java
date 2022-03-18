package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static tests.TestBase.*;

public class LiteCartStartPage {
    public static WebElement emailAddressField = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(1) > td > input[type=text]"));
    public static WebElement passField = driver.findElement(By
            .cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(2) > td > input[type=password]"));
    public static WebElement loginButton = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(4) > td > span > button:nth-child(1)"));
    public List<WebElement> products = driver.findElements(className("product"));
    public static List<WebElement> getProducts() {
        return (new LiteCartStartPage()).products;
    }
    public WebElement liteCartHome = driver.findElement(cssSelector("#site-menu > ul > li.general-0 > a > i"));

    public static WebElement getHome(){
        LiteCartStartPage liteCartStartPage = new LiteCartStartPage();
        return liteCartStartPage.liteCartHome;
    }
    public static void loginToStore() {
        emailAddressField.sendKeys(LITECARTLOGINUSER);
        passField.sendKeys(LITECARTPASSUSER);
        loginButton.click();

    }

}
