package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.List;

public class Task17Test {
    public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
    public static EventFiringWebDriver driver;
    public WebDriverWait wait;
    public static class MyListemer extends AbstractWebDriverEventListener{
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    @BeforeMethod
    public void startDriver() {
        if(tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListemer());
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);
        //driver = getWebDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null;})
        );

    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void task17() {
        String host = "localhost";
        String port = "8081";
        driver.get("http://" + host + ":" + port + "/litecart/admin/");
        driver.manage().logs().get("browser").forEach(l -> System.out.println(1));
        WebElement userNameField = driver.findElement(By.cssSelector("#box-login > form > div.content > table > tbody > tr:nth-child(1) > td:nth-child(2) > span > input[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("#box-login > form > div.content > table > tbody > tr:nth-child(2) > td:nth-child(2) > span > input[type=password]"));
        WebElement loginButton = driver.findElement(By.cssSelector("#box-login > form > div.footer > button"));

        userNameField.sendKeys("admin");
        passwordField.sendKeys("admin");
        loginButton.click();
        driver.get("http://" + host + ":" + port + "/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        List<WebElement> rowsList = driver.findElements(By.className("row"));
        List<WebElement> listClosedFolders = driver.findElements(By.className("fa-folder"));
        int sizeListClosedFolders = listClosedFolders.size();
        int it = 0;
        for(WebElement currentRow:rowsList) {
            try {
                currentRow.findElement(By.className("fa-folder"));
                currentRow.findElement(By.cssSelector("a")).click();
                it +=1;
                if (it == sizeListClosedFolders) {
                    break;
                }
            } catch (Exception e) {}
        }

        List<WebElement> listEl = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[*]/td[3]/a"));
        int productListSize = listEl.size();
        for (int i = 0; i < productListSize; i++) {
            driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[*]/td[3]/a")).get(i).click();
            pressButton("Cancel");
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
        }
    }
    public void pressButton(String buttonName){
        List<WebElement> listButtons = driver.findElement(By.className("button-set")).findElements(By.cssSelector("button"));
        for(WebElement button:listButtons){
            if(button.getText().contains(buttonName)) {
                button.click();
                return;
            }
        }
    }
}
