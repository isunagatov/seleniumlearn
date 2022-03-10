package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;

public class Task10Test {
    SoftAssert sa = new SoftAssert();
    public WebDriver driver;
    public static String LITECARTLOGINUSER = "i.sunagatov@ya.ru";
    public static String LITECARTPASSUSER = "admin";

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


    @Test(enabled = true)
    public void task10Chrome() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        task10();
    }
    @Test(enabled = true)
    public void task10Edge() {
        driver = new EdgeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        task10();
    }
    @Test(enabled = true)
    public void task10FireFox() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        task10();
    }

    public void task10 (){
        driver.get("http://localhost:8081/litecart/");
        List<WebElement> listContent = driver.findElement(By.cssSelector("#main > div.middle > div.content")).findElements(By.className("box"));;
        List<WebElement> compaingsProduct = listContent.get(1).findElements(By.className("product"));

        WebElement productCurrent = compaingsProduct.get(0);
            //PART 1
            String nameItem = productCurrent.findElement(By.className("name")).getText();
            WebElement regularPrice = productCurrent.findElement(By.className("regular-price"));
            WebElement campaignPrice = productCurrent.findElement(By.className("campaign-price"));

            String regularPriceValue = regularPrice.getText();
            String campaignPriceValue = campaignPrice.getText();

            String tagRegular = regularPrice.getTagName();
            sa.assertEquals(tagRegular, "s"); // v) Part 1.  "----". Pass
            String tagCampaign =  campaignPrice.getTagName();
            sa.assertEquals(tagCampaign, "strong"); // v) Part 1.2 . BOLD. Pass

            checkFontSize(regularPrice.getCssValue("font-size"), campaignPrice.getCssValue("font-size")); //d) Part 1. Pass*/

            Color colorReg = Color.fromString(regularPrice.getCssValue("Color"));
            // v) Part 1. Color grey. Pass
            sa.assertTrue(colorReg.getColor().getRed() == colorReg.getColor().getBlue() && colorReg.getColor().getRed() == colorReg.getColor().getGreen(), "Part 1. Color should be gray");
            // g) Part 1. Red. Pass
            Color colorCampaign = Color.fromString(campaignPrice.getCssValue("Color"));
            sa.assertTrue(colorCampaign.getColor().getBlue()==0 && colorCampaign.getColor().getGreen() == 0, "Color should be RED");


            // PART 2
            productCurrent.click();

            WebElement informationBox = driver.findElement(By.className("information"));

            WebElement regularOfDetails = informationBox.findElement(By.className("regular-price"));
            String regularPriceOfDetail = regularOfDetails.getText();

            WebElement campaignOfDetails = informationBox.findElement(By.className("campaign-price"));
            String campaignPriceOfDetail = campaignOfDetails.getText();

            String tagRegularOfDetails = regularOfDetails.getTagName();
            sa.assertEquals(tagRegularOfDetails, "s"); // v) Part 2. "----". Pass
            String tagCampaignOfDetails =  campaignOfDetails.getTagName();
            sa.assertEquals(tagCampaignOfDetails, "strong"); // v) Part 2. Pass

            checkFontSize(regularOfDetails.getCssValue("font-size"), campaignOfDetails.getCssValue("font-size")); // d) Part 2. Pass

            String nameOfDetails = driver.findElement(By.cssSelector("#box-product")).findElement(By.className("title")).getText();

            Color colorRegOfDetails = Color.fromString(regularOfDetails.getCssValue("Color"));
            // v) Part 2. Color grey. Pass
            sa.assertTrue(colorRegOfDetails.getColor().getRed() == colorRegOfDetails.getColor().getBlue() &&
                    colorRegOfDetails.getColor().getRed() == colorRegOfDetails.getColor().getGreen(), "Part 2. Color should be GRAY");
            // g) Part 2. Red. Pass
            Color colorCampaignOfDetails = Color.fromString(campaignOfDetails.getCssValue("Color"));
            sa.assertTrue(colorCampaignOfDetails.getColor().getBlue()==0 && colorCampaignOfDetails.getColor().getGreen() == 0, "Color should be RED");

            sa.assertEquals(nameOfDetails, nameItem); // a) Pass
            sa.assertEquals(regularPriceOfDetail, regularPriceValue); // b) Pass
            sa.assertEquals(campaignPriceOfDetail, campaignPriceValue);  // b) Pass

        sa.assertAll();
    }
    public void checkFontSize (String RegularPrice, String CampaignPrice) {
        //String regularFontSize = regularPrice.getCssValue("font-size");
        Double regularFontSizeDouble = Double.parseDouble(RegularPrice.substring(0, RegularPrice.length()-2));
        //String campaignFontSize = campaignPrice.getCssValue("font-size");
        Double campaignFontSizeDouble = Double.parseDouble(CampaignPrice.substring(0, CampaignPrice.length()-2));
        sa.assertTrue(regularFontSizeDouble < campaignFontSizeDouble, "regular<campaign"); // d) Part 1. Pass
    }
}
