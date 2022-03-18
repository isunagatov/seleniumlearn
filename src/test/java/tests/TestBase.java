package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;
    public static String LITECARTLOGINUSER = "i.sunagatov@ya.ru";
    public static String LITECARTPASSUSER = "admin";
    public static String LITECARTLOGINADMIN = "admin";
    public static String LITECARTPASSADMIN = "admin";
    public static WebDriverWait wait;

    @BeforeMethod
    public void startDriver() {
        driver = new ChromeDriver();
        //driver = getWebDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        wait = new WebDriverWait(driver, 5);

    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
