package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task9Test extends TestBase {
    public SoftAssert sa = new SoftAssert();
    @Test
    public void task9 () {
        driver.get("http://localhost:8081/litecart/admin/?app=geo_zones&doc=geo_zones");
        LiteCartAdminStartPage.loginToAdmin();
        List<WebElement> rowsList =  driver.findElements(By.className("row"));
        int rowsNumbers = rowsList.size();
        List<String> sortedListCountries = new ArrayList<>();
        WebElement row;
        for (int i=0; i<rowsNumbers; i++) {
            row = driver.findElements(By.className("row")).get(i);
            row.click();
            row.findElement(By.cssSelector("a")).click();
            List<WebElement> listRow = driver.findElement(By.className("dataTable")).findElements(By.cssSelector("tr"));
            listRow.remove(0);
            listRow.remove(listRow.size()-1);
            List<WebElement> listOption;
            List<String> listCountries = new ArrayList<>();
            for (WebElement rowCurrent:listRow){
                                listOption = rowCurrent.findElements(By.cssSelector("td")).get(2).findElements(By.cssSelector("option"));
                for (WebElement optionCurrent:listOption) {
                    if(optionCurrent.isSelected()==true){
                         listCountries.add(optionCurrent.getText());
                         break;
                    }
                }
            }
            sortedListCountries = listCountries;
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
