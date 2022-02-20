package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.LiteCartAdminStartPage;

import java.util.List;

public class Task6Test extends TestBase{

    @Test
    public void task6 (){
        driver.get("http://localhost:8081/litecart/admin/");
        LiteCartAdminStartPage.userNameField.sendKeys(LITECARTLOGINADMIN);
        LiteCartAdminStartPage.passwordField.sendKeys(LITECARTPASSADMIN);
        LiteCartAdminStartPage.loginButton.click();
        runBothMenuClick();
    }
    public void runBothMenuClick ( ) {
        List<WebElement> coll = driver.findElements(By.cssSelector("#app- > a"));
        int size = coll.size();
        for (int i = 0; i < size; i++){
            WebElement elApp = driver.findElements(By.cssSelector("#app- > a")).get(i);
            elApp.click();
            runInternalMenuClick();
        }
    }
    public void runInternalMenuClick () {
        List<WebElement> listDocs = driver.findElements(new By.ByClassName("docs"));
        if(listDocs.size()>0) {
            List<WebElement> collInternal = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span"));
            int sizeInternal = collInternal.size();
            for (int i = 0; i < sizeInternal; i++) {
                if (collInternal.size() > 0) {
                    WebElement subMenuCurrent = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span")).get(i);
                    subMenuCurrent.click();
                }
            }
        }
    }


}
