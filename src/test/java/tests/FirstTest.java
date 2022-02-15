package tests;
import org.testng.annotations.Test;
import page.GooglePage;
import page.LiteCartAdminStartPage;
import page.LiteCartStartPage;

public class FirstTest extends TestBase {
    @Test(enabled = false)
    public void openGoogle(){
        driver.get("http://google.ru");
        GooglePage.inputText.sendKeys("selenium");
        GooglePage.submitButton.submit();
    }
    @Test(enabled = false)
    public void task3LoginToStore() {
        driver.get("http://localhost:8081/litecart/");
        LiteCartStartPage.emailAddressField.sendKeys(LITECARTLOGINUSER);
        LiteCartStartPage.passField.sendKeys(LITECARTPASSUSER);
        LiteCartStartPage.loginButton.click();

    }
    @Test(enabled = true)
    public void task3LoginToAdminApplication() {
        driver.get("http://localhost:8081/litecart/admin/");
        LiteCartAdminStartPage.userNameField.sendKeys(LITECARTLOGINADMIN);
        LiteCartAdminStartPage.passwordField.sendKeys(LITECARTPASSADMIN);
        LiteCartAdminStartPage.loginButton.click();

    }


}
