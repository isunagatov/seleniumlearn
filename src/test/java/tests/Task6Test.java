package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.List;

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
        //SoftAssert sa= new SoftAssert();
        List<WebElement> coll = driver.findElements(By.cssSelector("#app- > a"));
        int size = coll.size();
        for (int i = 0; i < size; i++){
            WebElement elApp = driver.findElements(By.cssSelector("#app- > a")).get(i);
            String appText = elApp.getText();
            elApp.click();
            Assert.assertTrue(driver.findElements(new By.ByCssSelector("#content > h1")).isEmpty()==false );
            String h1Text = driver.findElements(new By.ByCssSelector("#content > h1")).get(0).getText();

            System.out.println ("H1 text: " + driver.findElements(new By.ByCssSelector("#content > h1")).get(0).getText());

            List<WebElement> listDocs = driver.findElements(new By.ByClassName("docs"));
            if(listDocs.size()>0) {
                runInternalMenuClick();
            }
            else {
                sa.assertEquals(h1Text, appText);
                //Assert.assertEquals(h1Text,appText);
            }
        }
        sa.assertAll();
    }
    public void runInternalMenuClick () {
            List<WebElement> collInternal = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span"));
            int sizeInternal = collInternal.size();

            for (int i = 0; i < sizeInternal; i++) {
                if (collInternal.size() > 0) {
                    WebElement subMenuCurrent = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span")).get(i);
                    String subMenuText = subMenuCurrent.getText();
                    subMenuCurrent.click();
                    Assert.assertTrue(driver.findElements(new By.ByCssSelector("#content > h1")).isEmpty()==false );
                    String h1Text = driver.findElements(new By.ByCssSelector("#content > h1")).get(0).getText();


                    sa.assertEquals(h1Text, subMenuText);
                    //Assert.assertEquals(h1Text,subMenuText);
                    System.out.println ("H1 text Sub Menu: " + h1Text);
                    System.out.println ("Sub Menu text: " + subMenuText);
                }
            }
    }


}
