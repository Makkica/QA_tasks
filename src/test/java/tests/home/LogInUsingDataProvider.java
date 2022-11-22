package tests.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInUsingDataProvider {
    @Test (dataProvider = "testdata")
    public void multipleLogIns(String email, String password) {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        driver.close();

    }
    @DataProvider (name= "testdata")
    public Object[][] TestDataFeed () {
        Object [][] credentials= new Object[2][2];
        credentials[0][0]="janko.praksatests.customusercreation.ui@null.echosignmail.com";
        credentials[0][1]="L8hGZ2d_PwRiUV$";
        credentials[1][0]="mihajlo.praksatests.customusercreation.ui@null.echosignmail.com";
        credentials[1][1]="L8hGZ2d_PwRiUV$";

        return credentials;
}}
