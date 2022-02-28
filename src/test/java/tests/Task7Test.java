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
        //List<WebElement> listContent = LiteCartStorePage.contents;
        List<WebElement> itemList;
        List<WebElement> listSticker;
        // Тренеру: У нас есть contents, который описывет 3 блока box с товарами
        // В content выбираются все блоки которые являются товарами
        //Зачем усложнять явным выбором #box-most-popular > div > ul > li: или #box-campaigns ?
        // Это усложняет и увеличивает описание и количество кода которое надо будет поддерживать
        //Если использовать описнаие каждого блока, и что то изменится на странице, то больше кода нужно будет поддерживать
        // Есть определенное задание, нет задачи проверять конеретныые блоки меню.
        //В текущем варианте - если количество блоков может увеличиться, код будет работать, если будем описывать конкретные блоки, то и в задании должно быть это указано
        // Чем больше кода, тем дороже и разработка и поддержка. Заказчик быстрее откажется от автотестов, чем согласится на такой бюджет ИМХО
        // Либо я не понял что нужно из задания, сделаю по другому:
        //Товар однозначно идентифицировать нельзя. Добавил проверку на "product column shadow hover-light", но смысла не вижу.
        // ПОлучилась та же самая проверка, но кода больше
/*        for(WebElement menuCurrent:listContent){
            itemList = menuCurrent.findElements(By.cssSelector("li"));
            //itemList = menuCurrent.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"));
            for(WebElement itemCurrent:itemList){
                listSticker = itemCurrent.findElements(By.className("sticker"));

                sa.assertEquals(listSticker.size(),1);
                //System.out.println("text sticker:" + listSticker.get(0).getText());
            }
        }*/

        List<WebElement> listItemMostPopular = LiteCartStorePage.mostPopular;
        checkSticker(listItemMostPopular);
        List<WebElement> listItemCampaigns = LiteCartStorePage.campaigns;
        checkSticker(listItemCampaigns);
        List<WebElement> listItemLatestProducts = LiteCartStorePage.latestProducts;
        checkSticker(listItemLatestProducts);

        sa.assertAll();
    }
    public void checkSticker ( List<WebElement> listContent){
        List<WebElement> listSticker;
        for(WebElement itemCurrent:listContent){
            //itemList = menuCurrent.findElements(By.cssSelector("li"));
            //itemList = menuCurrent.getAttribute("Class"); // тот же самый #box-most-popular > div > ul > li: . Какая разница?

            if (itemCurrent.getAttribute("Class").contains("product column shadow hover-light")==true){
                listSticker = itemCurrent.findElements(By.className("sticker"));

                sa.assertEquals(listSticker.size(),1);
            }
            /* for(WebElement itemCurrent:itemList){
             */
            //System.out.println("text sticker:" + listSticker.get(0).getText());
            /* }*/
        }
    }
}