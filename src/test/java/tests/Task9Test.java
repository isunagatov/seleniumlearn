package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task9Test extends TestBase {
    public SoftAssert sa = new SoftAssert();
    @Test
    public void task9 () {
        driver.get("http://localhost:8081/litecart/admin/?app=geo_zones&doc=geo_zones");
        LiteCartAdminStartPage.loginToAdmin();
        List<WebElement> rowsList =  driver.findElements(By.className("row"));
        List<String> sortedListCountries;
        int rows = rowsList.size();
        WebElement rowCurrent;
        for (int i = 0;  i < rows; ++i) {
            rowCurrent = driver.findElements(By.className("row")).get(i);
            rowCurrent.findElement(By.cssSelector("a")).click();
            List<WebElement> listCountriesWebEl = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]//select[contains(@name,'zones[')]//option[@selected]"));

            List<String> listCountries = new ArrayList<>();
            //listCountries.add("ZZZ");
            for (WebElement countryCurrent:listCountriesWebEl){
                listCountries.add(countryCurrent.getText());
            }

            sortedListCountries = new ArrayList<>(listCountries); //Fixed
            Collections.sort(sortedListCountries);

            sa.assertEquals(listCountries, sortedListCountries);
            pressButton("Cancel");
        }
        sa.assertAll();
    }

    public void pressButton(String buttonName){
        List<WebElement> listButtons = driver.findElement(By.className("button-set")).findElements(By.cssSelector("button"));
        for(WebElement button:listButtons){
            if(button.getText().contains(buttonName)) {
                button.click();
                return;
            }
        }
    }
}
