package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;
import page.LiteCartStartPage;
import page.LiteCartStorePage;

import java.util.List;

public class Task7Test extends TestBase {
    public SoftAssert sa = new SoftAssert();
    @Test
    public void task7 () {
        driver.get("http://localhost:8081/litecart/");
        LiteCartStartPage.loginToStore();
        List<WebElement> listContent = LiteCartStorePage.contents;
        List<WebElement> itemList;
        List<WebElement> listSticker;
        for(WebElement menuCurrent:listContent){
            itemList = menuCurrent.findElements(By.cssSelector("li"));
            for(WebElement itemCurrent:itemList){
                listSticker = itemCurrent.findElements(By.className("sticker"));
                sa.assertEquals(listSticker.size(),1);
            }
        }
        sa.assertAll();
    }
}
