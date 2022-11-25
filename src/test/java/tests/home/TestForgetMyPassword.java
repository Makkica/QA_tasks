package tests.home;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tests.BaseTestClass;

import java.util.concurrent.TimeUnit;

public class TestForgetMyPassword extends BaseTestClass {
    @Test
    public void testForgetMyPassword () {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();

        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("#forgot-password-link")).click();
        driver.findElement(By.cssSelector("#forgot-email")).clear();
        driver.findElement(By.cssSelector("#forgot-email")).sendKeys("janko.praksatests.customusercreation.ui@null.echosignmail.com");
        driver.findElement(By.cssSelector("#forgot-password-div > form > table > tbody > tr > td:nth-child(2) > button")).click();

    }


}
