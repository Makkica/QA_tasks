package tests.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenHomePageAndSignIn {

    @Test
    public void openAndSignIn () throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println("@Test - openAndSignIn");
        driver.manage().window().maximize();

        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
        //waiting 5 seconds for the home page to load
        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("janko.praksatests.customusercreation.ui@null.echosignmail.com");
        driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("L8hGZ2d_PwRiUV$");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();


        driver.quit();

    }
}
