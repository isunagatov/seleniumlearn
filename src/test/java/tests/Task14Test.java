package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task14Test extends TestBase {
    @Test
    public void task14() {
        SoftAssert sa = new SoftAssert();
        String host = "localhost";
        String port = "8081";
        driver.get("http://" + host + ":" + port + "/litecart/admin/");

        LiteCartAdminStartPage.loginToAdmin();
        //driver.findElement(By.cssSelector("#app- > a > span.name"));
        driver.navigate().to("http://localhost:" + port + "/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")).click();
        String urlBefore = getBrowserUrl();
        String urlAfter;
        List<WebElement> listLinks = driver.findElements(By.cssSelector("td > a > i"));
        int sizeList = listLinks.size();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<sizeList; i++) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            driver.findElements(By.cssSelector("td > a > i")).get(i).click();

            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);

            urlAfter = getBrowserUrl();
            sa.assertFalse(urlAfter.contains(urlBefore));
        }
    }
    public ExpectedCondition<String> anyWindowOtherThan(Set<String>oldWindows){
        return new ExpectedCondition<String>(){
            public String apply(WebDriver driver){
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return  handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    public static String getBrowserUrl() {
        //WebDriver webdriver = getWebDriver();
        String currentUrl = driver.getCurrentUrl();
        return  currentUrl;
    }
}
