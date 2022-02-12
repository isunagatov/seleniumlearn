package tests;
import org.testng.annotations.Test;
import page.GooglePage;

public class FirstTest extends TestBase {
    @Test
    public void openGoogle(){
        driver.get("http://google.ru");
        GooglePage.inputText.sendKeys("selenium");
        GooglePage.submitButton.submit();
    }

}
