package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LiteCartAdminStartPage;

import java.util.List;
import java.util.UUID;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task12Test extends TestBase {
    //private WebElement searchField;
    public String host = "localhost";
    public String port = "8081";

        @Test
        public void Task12() {
            String nameProduct = "DuckCustom" + UUID.randomUUID().toString().substring(0,6);
            driver.get("http://" + host + ":" + port + "/litecart/admin/?app=catalog&doc=catalog");
            LiteCartAdminStartPage.loginToAdmin();
            driver.navigate().to("http://" + host + ":" + port + "/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
            driver.findElement(By.cssSelector("label:nth-child(3) > input[type=radio]")).click();
            driver.findElement(By.name("name[en]")).sendKeys(nameProduct);
            driver.findElement(By.name("code")).sendKeys("12345");
            driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=checkbox]")).click();
            driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=checkbox]")).click();
            driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(7) > td > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > input[type=checkbox]")).click();

            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).click();
            driver.findElement(By.name("quantity")).sendKeys("5");

            driver.findElement(By.name("sold_out_status_id")).click();
            driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(8) > td > table > tbody > tr > td:nth-child(4) > select > option:nth-child(3)")).click();
            String pathPicture = getClass().getClassLoader().getResource("greenDuckCustom.png").getPath().replace("/", "\\").substring(1);
            driver.findElement(By.cssSelector("input[type=file]")).sendKeys(pathPicture);
            driver.findElement(By.name("date_valid_from")).sendKeys("01022022");
            driver.findElement(By.name("date_valid_to")).sendKeys("01022023");
            getTab("Information").click();


            driver.findElement(By.name("manufacturer_id")).click();
            driver.findElement(By.cssSelector("#tab-information > table > tbody > tr:nth-child(1) > td > select > option:nth-child(2)")).click();
            driver.findElement(By.name("keywords")).sendKeys("123456789");
            driver.findElement(By.name("short_description[en]")).sendKeys("test duck product");
            driver.findElement(By.className("trumbowyg-editor")).sendKeys("test description");
            driver.findElement(By.name("head_title[en]")).sendKeys("Head Title Duck");
            driver.findElement(By.name("meta_description[en]")).sendKeys("Duck in test");
            getTab("Prices").click();
            driver.findElement(By.name("purchase_price")).clear();
            driver.findElement(By.name("purchase_price")).sendKeys("100");
            driver.findElement(By.name("purchase_price_currency_code")).click();
            driver.findElement(By.cssSelector("#tab-prices > table:nth-child(2) > tbody > tr > td > select > option:nth-child(2)")).click();
            driver.findElement(By.name("gross_prices[USD]")).clear();
            driver.findElement(By.name("gross_prices[USD]")).sendKeys("1");
            driver.findElement(By.name("gross_prices[EUR]")).clear();
            driver.findElement(By.name("gross_prices[EUR]")).sendKeys("0.5");
            driver.findElement(By.name("save")).click();

            driver.findElement(By.xpath("//table//*[contains(text(), '" + nameProduct + "')]")).click();

        }
        public WebElement getTab (String tabName){
            List<WebElement> listTabs;
            listTabs = driver.findElement(By.className("index")).findElements(By.cssSelector("li"));
            for (WebElement currentTab:listTabs){
                if(currentTab.getText().contains(tabName)){
                    return currentTab;
                }
            }
            return null;
        }
}
