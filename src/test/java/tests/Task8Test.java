package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.*;

public class Task8Test extends TestBase {
    public SoftAssert sa = new SoftAssert();
    @Test
    public void test8() {
        driver.get("http://localhost:8081/litecart/admin/?app=countries&doc=countries");
        LiteCartAdminStartPage.loginToAdmin();
        List<WebElement> rowList = driver.findElements(By.className("row"));

        List<WebElement> countriesNamesList;
        //Map<WebElement, String> hashmap = new HashMap<WebElement, String>();
        List<String> listString = new ArrayList<>();
        List<String> listToCheck = new ArrayList<>();
        String nameCountry;
        for(WebElement rowCurrent:rowList){
            //hashmap.put(rowCurrent, rowCurrent.findElements(By.cssSelector("td")).get(4).getText());
            nameCountry = rowCurrent.findElements(By.cssSelector("td")).get(4).getText();
            listString.add(nameCountry);
            if (rowCurrent.findElements(By.cssSelector("td")).get(5).getText().contains("0") != true){
                listToCheck.add(nameCountry);
            }
        }
        List<String> listSorted = new ArrayList<>(listString);
        Collections.sort(listSorted);
        sa.assertEquals(listString,listSorted);

        checkGeoZones(listToCheck);

        sa.assertAll();
    }

    public void checkGeoZones(List<String> listToCheck) {
        WebElement countryToCheck = null;
        List<WebElement> listRowsZones;
        List<String> listZonesNames;
        List<String> listZonesNameSort;

        for(String currentToCheck:listToCheck){
            countryToCheck = driver.findElement(By.linkText(currentToCheck));
            countryToCheck.click();
            WebElement tableZones = driver.findElement(By.className("dataTable"));

            listRowsZones = tableZones.findElements(By.cssSelector("tr"));
            listRowsZones.remove(0);
            listRowsZones.remove(listRowsZones.size()-1);

            listZonesNames = new ArrayList<>();
            for (WebElement rowZonesCurrent:listRowsZones){
                listZonesNames.add(rowZonesCurrent.findElements(By.cssSelector("td")).get(2).getText());
            }
            listZonesNameSort = new ArrayList<>(listZonesNames);
            Collections.sort(listZonesNameSort);
            sa.assertEquals(listZonesNames, listZonesNameSort);
            pressButton("Cancel");
        }
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

    @Test
    public void test8checkCode() {
        driver.get("http://localhost:8081/litecart/admin/?app=countries&doc=countries");
        LiteCartAdminStartPage.loginToAdmin();
        List<WebElement> rowList = driver.findElements(By.className("row"));

        List<WebElement> countriesNamesList;
        //Map<WebElement, String> hashmap = new HashMap<WebElement, String>();
        List<String> listString = new ArrayList<>();
        List<String> listToCheck = new ArrayList<String>();
        String nameCountry;
        for(WebElement rowCurrent:rowList){
            //hashmap.put(rowCurrent, rowCurrent.findElements(By.cssSelector("td")).get(4).getText());
            nameCountry = rowCurrent.findElements(By.cssSelector("td")).get(4).getText();
            listString.add(nameCountry);
            if (rowCurrent.findElements(By.cssSelector("td")).get(5).getText().contains("0") != true){
                listToCheck.add(nameCountry);
            }
        }
        listString.add(0, "mnbvcxz");
        List<String> listSorted = new ArrayList<String>(listString);
        Collections.sort(listSorted);
        sa.assertEquals(listString,listSorted);

        checkGeoZones(listToCheck);

        sa.assertAll();
    }


}
