package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class Task13Test extends TestBase {

    @Test
    public void task13 () {
        String url = "http://localhost:8081/litecart/en/";
        driver.get(url);
        addBasket();
        driver.findElement(By.className("link")).click();
        removeProductsFromBasket();
    }

    public void addBasket() {
        List<WebElement> listProduct = driver.findElements(className("product"));
        int sizeProduct = listProduct.size();
        for(int i = 0; i<3; i++){
            //driver.navigate().to(url);
            driver.findElement(cssSelector("#site-menu > ul > li.general-0 > a > i")).click();
            if(i<sizeProduct) {
                driver.findElements(className("product")).get(i).click();
            }else{
                driver.findElements(className("product")).get(sizeProduct-1).click();
            }
            pressAddProduct();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#cart span.quantity")), "innerText", String.valueOf(i+1)));
        }
    }
    public void removeProductsFromBasket() {
        List<WebElement> listShortcut = driver.findElements(className("shortcut"));
        int countOfProduct = listShortcut.size();
        for (int i = 0; i < countOfProduct; i++){
            WebElement table = driver.findElement(cssSelector("#order_confirmation-wrapper > table > tbody"));
            //productCurrent.click();
            List<WebElement> shortcutList = driver.findElements(className("shortcut"));
            WebElement productCurrent;
            if(shortcutList.size()>0) {
                productCurrent = driver.findElement(className("shortcut"));
                productCurrent.click();
            }else {
                productCurrent = driver.findElement(cssSelector("#box-checkout-cart > div > ul > li > form"));
            }
            driver.findElement(By.name("remove_cart_item")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.stalenessOf(productCurrent));
            wait.until(ExpectedConditions.stalenessOf(table));
        }
    }

    public void pressAddProduct() {
        try{
            WebElement sizeOfProduct = driver.findElement(cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));
                         sizeOfProduct.click();
                sizeOfProduct.sendKeys(Keys.DOWN);
                sizeOfProduct.findElement(cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select > option:nth-child(2)")).click();
                sizeOfProduct.sendKeys(Keys.ENTER);

        } catch (Exception e){
        }
        driver.findElement(By.name("add_cart_product")).click();
    }

}
