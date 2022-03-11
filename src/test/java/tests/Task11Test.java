package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LiteCartAdminStartPage;

import java.util.UUID;

public class Task11Test extends TestBase{
    public SoftAssert sa = new SoftAssert();
    @Test
    public void task11 () {
        driver.get("http://localhost:8081/litecart/en/create_account");

        String firstname = "firstname";
        String lastname = "lastname";
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("address1")).sendKeys("address1");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("city");
        driver.findElement(By.className("select2-selection__arrow")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States");
        driver.findElement(By.className("select2-results__option")).click();
        String uuid = UUID.randomUUID().toString().substring(0,6);
        String email = "autotest_" + uuid + "@domai.com";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("88888888888");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("confirmed_password")).sendKeys("12345");

        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("login")).click();

        WebElement checkOut = driver.findElement(By.cssSelector("#cart > a.link"));
    }
}
