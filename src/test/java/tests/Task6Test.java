package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminFirstPage;
import page.LiteCartAdminStartPage;

import java.util.List;


import static org.openqa.selenium.By.*;

public class Task6Test extends TestBase{
    public SoftAssert sa = new SoftAssert();

    @Test
    public void task6 (){
        driver.get("http://localhost:8081/litecart/admin/");
        LiteCartAdminStartPage.userNameField.sendKeys(LITECARTLOGINADMIN);
        LiteCartAdminStartPage.passwordField.sendKeys(LITECARTPASSADMIN);
        LiteCartAdminStartPage.loginButton.click();
        runBothMenuClick();
    }
    public void runBothMenuClick ( ) {
        WebElement h1;
        List<WebElement> coll = driver.findElements(cssSelector("#app- > a"));
        int size = coll.size();
        WebElement elApp;
        String h1Text;
        String appText;
        List<WebElement> listDocs;
        for (int i = 0; i < size; i++){
            elApp = driver.findElements(cssSelector("#app- > a")).get(i);
            appText = elApp.getText();
            elApp.click();

            h1 = LiteCartAdminFirstPage.getH1();
            Assert.assertTrue(h1.isDisplayed()==true);
            h1Text = h1.getText();

            //System.out.println ("H1 text: " + h1Text);

            listDocs = driver.findElements(className("docs"));
            if(listDocs.size()>0) {
                runInternalMenuClick();
            }
            else {
                sa.assertEquals(h1Text, appText);
            }
        }
        sa.assertAll();
    }
    public void runInternalMenuClick () {
            List<WebElement> collInternal = driver.findElement(className("docs")).findElements(cssSelector("span"));
            int sizeInternal = collInternal.size();
             WebElement h1;
             WebElement subMenuCurrent;
            String subMenuText;
        for (int i = 0; i < sizeInternal; i++) {
                if (collInternal.size() > 0) {
                    subMenuCurrent = driver.findElement(className("docs")).findElements(cssSelector("span")).get(i);
                    subMenuText = subMenuCurrent.getText();
                    subMenuCurrent.click();

                    h1 = LiteCartAdminFirstPage.getH1();
                    Assert.assertTrue(h1.isDisplayed()==true );
                    String h1Text = h1.getText();

                    sa.assertEquals(h1Text, subMenuText);
                }
            }
    }


}


