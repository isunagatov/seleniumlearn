package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static tests.TestBase.driver;

public class ProductPage extends TestBase{

    public static WebElement getWebElementSizeOfProduct() {
        try {
            WebElement sizeOfProduct = driver.findElement(
                    cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));
            return sizeOfProduct;
        }catch (Exception e){        }
        return null;
    }
    public static WebElement getSmallSize(){
        try {
            return getWebElementSizeOfProduct().findElement(cssSelector("tr:nth-child(1) > td > select > option:nth-child(2)"));
        }catch (Exception e){
            return null;
        }
    }
    public static WebElement getAddToCartButton() {
        return (new ProductPage()).addToCartButton;
    }

    public static List<WebElement> getListSizeOfProduct () {
        return new ProductPage().listSizeOfProduct;
    }
    public List<WebElement> listSizeOfProduct = driver.findElements(
            cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));

    public WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));

}
