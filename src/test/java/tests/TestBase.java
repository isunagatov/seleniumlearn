package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;
    public static String LITECARTLOGINUSER = "i.sunagatov@ya.ru";
    public static String LITECARTPASSUSER = "admin";
    public static String LITECARTLOGINADMIN = "admin";
    public static String LITECARTPASSADMIN = "admin";
    @BeforeMethod
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver98.exe")
                .getPath().replace("/", "\\").substring(1).concat("\\"));
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();

        //driver = getWebDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));

    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
