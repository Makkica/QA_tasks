package tests.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import tests.BaseTestClass;
import pages.SignInPage;

public class OpenHomePageAndSignIn extends BaseTestClass {

    private String userEmail ="janko.praksatests.customusercreation.ui@null.echosignmail.com";

    private String userPassword = "L8hGZ2d_PwRiUV$";

   @Test
    public void beforeMethod() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);

       SignInPage signInPage = new SignInPage(driver);
       signInPage.insertCredentials().clickSignIn();

       String actualUrl="https://qausers.na1.echosign.com/account/homeJS";
       String expectedUrl = driver.getCurrentUrl();
       try {
           Thread.sleep(8000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       Assert.assertNotEquals(expectedUrl, actualUrl);

   }
}
