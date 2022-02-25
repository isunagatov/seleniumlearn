package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import static org.openqa.selenium.By.cssSelector;

public class LiteCartAdminFirstPage extends TestBase {
    public WebElement h1 = driver.findElement(cssSelector(("#content > h1")));
    public WebElement h2 = driver.findElement(new By.ByCssSelector("#content > h1"));
    public static WebElement getH1(){

        LiteCartAdminFirstPage liteCartAdminFirstPage= new LiteCartAdminFirstPage();
        WebElement h2 = liteCartAdminFirstPage.h1;
        return h2;
    }
    public void loginAdminApplication (){
        driver.get("http://localhost:8081/litecart/admin/");
        LiteCartAdminStartPage.userNameField.sendKeys(LITECARTLOGINADMIN);
        LiteCartAdminStartPage.passwordField.sendKeys(LITECARTPASSADMIN);
        LiteCartAdminStartPage.loginButton.click();
    }
}
