package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrowsersTest {
    public static WebDriver driver;
    public static String LITECARTLOGINUSER = "i.sunagatov@ya.ru";
    public static String LITECARTPASSUSER = "admin";
    public static String LITECARTLOGINADMIN = "admin";
    public static String LITECARTPASSADMIN = "admin";

    public void startDriver(String BrowserName) {
        switch (BrowserName) {
            case ("Chrome"):
                System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver98.exe")
                        .getPath().replace("/", "\\").substring(1).concat("\\"));
                driver = new ChromeDriver();
                break;
            case ("FireFox"):
                System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("geckodriverV0.30.0.exe")
                        .getPath().replace("/", "\\").substring(1).concat("\\"));
                driver = new FirefoxDriver();
                break;
            case ("Edge"):
                System.setProperty("webdriver.edge.driver", getClass().getClassLoader().getResource("msedgedriver98.exe")
                        .getPath().replace("/", "\\").substring(1).concat("\\"));
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    @AfterMethod
    public void closeDriver(){
        //driver.quit();
        driver.close();
    }

    public void task4ForTask3LoginToStore() {
        driver.get("http://localhost:8081/litecart/");
        LiteCartStartPage.emailAddressField.sendKeys(LITECARTLOGINUSER);
        LiteCartStartPage.passField.sendKeys(LITECARTPASSUSER);
        LiteCartStartPage.loginButton.click();
    }
    public void setCapabilitiesByArguments(String browserName, String browserVersion) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
       // capabilities.setCapability("enableVNC", true);
        Configuration.browser = browserName;
        Configuration.browserCapabilities = capabilities;
        //open(baseUrl);
//        while(!title().equals("My Store")) {
//            refresh();
//        }
    }

    public static class LiteCartStartPage{
        public static WebElement emailAddressField = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(1) > td > input[type=text]"));
        public static WebElement passField = driver.findElement(By
                .cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(2) > td > input[type=password]"));
        public static WebElement loginButton = driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(4) > td > span > button:nth-child(1)"));

    }
    @Test
    public void task4Chrome() {
        //setCapabilitiesByArguments("Chrome", "98");
        startDriver("Chrome");
        task4ForTask3LoginToStore();
    }
    @Test
    public void task4FireFox() {
        //setCapabilitiesByArguments("FireFox", "98");
        startDriver("FireFox");
        task4ForTask3LoginToStore();
    }
    @Test
    public void task4Edge() {
        //EdgeDriver driver = new EdgeDriver();
        startDriver("Edge");
        task4ForTask3LoginToStore();
    }
}
