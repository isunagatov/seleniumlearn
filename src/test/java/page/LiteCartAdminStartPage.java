package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

public class LiteCartAdminStartPage extends TestBase {
    public static WebElement userNameField = driver.findElement(By.cssSelector("#box-login > form > div.content > table > tbody > tr:nth-child(1) > td:nth-child(2) > span > input[type=text]"));
    public static WebElement passwordField = driver.findElement(By.cssSelector("#box-login > form > div.content > table > tbody > tr:nth-child(2) > td:nth-child(2) > span > input[type=password]"));
    public static WebElement loginButton = driver.findElement(By.cssSelector("#box-login > form > div.footer > button"));


    public static void loginToAdmin(){
        //driver.get("http://localhost:8081/litecart/admin/");
        userNameField.sendKeys(LITECARTLOGINADMIN);
        passwordField.sendKeys(LITECARTPASSADMIN);
        loginButton.click();
    }


}
