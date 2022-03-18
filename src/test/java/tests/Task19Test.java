package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.BasketPage;
import page.CartMenuPage;
import page.LiteCartStartPage;
import page.ProductPage;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class Task19Test extends TestBase {
    @Test
    public void task19of13 () {
        String url = "http://localhost:8081/litecart/en/";
        driver.get(url);
        addBasket();
        CartMenuPage.getCheckuot().click();
        removeProductsFromBasket();
    }

    public void addBasket() {
        List<WebElement> listProduct = LiteCartStartPage.getProducts();
        int sizeProduct = listProduct.size();
        for(int i = 0; i<3; i++){
            LiteCartStartPage.getHome().click();
            if(i<sizeProduct) {
                LiteCartStartPage.getProducts().get(i).click();
            }else{
                LiteCartStartPage.getProducts().get(sizeProduct-1).click();
            }
            pressAddProduct();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeToBe(CartMenuPage.getQuantity(), "innerText", String.valueOf(i+1)));
        }
    }
    public void removeProductsFromBasket() {
        //List<WebElement> listShortcut = driver.findElements(className("shortcut"));
        List<WebElement> listShortcut = BasketPage.getShortcuts();
        int countOfProduct = listShortcut.size();
        for (int i = 0; i < countOfProduct; i++){
            WebElement table = driver.findElement(cssSelector("#order_confirmation-wrapper > table > tbody"));
            //productCurrent.click();
            List<WebElement> shortcutList = BasketPage.getShortcuts();
            WebElement productCurrent;
            if(shortcutList.size()>0) {
                productCurrent = BasketPage.getShortcut();
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
            if(ProductPage.listSizeOfProduct.size()>0) {
                WebElement sizeOfProduct = ProductPage.getWebElementSizeOfProduct();
                sizeOfProduct.click();
                sizeOfProduct.sendKeys(Keys.DOWN);
                ProductPage.getSmallSize().click();
                sizeOfProduct.sendKeys(Keys.ENTER);
            }
        } catch (Exception e){
        }
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.getAddToCartButton()));
        ProductPage.getAddToCartButton().click();
    }

}
