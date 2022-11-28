package tests.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import tests.BaseTestClass;
import pages.SignInPage;

public class OpenHomePageAndSignIn extends BaseTestClass {



   @Test
    public void beforeMethod() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
        HomePage home = new HomePage(driver);



       SignInPage signInPage = new SignInPage(driver);
       signInPage.insertCredentials().clickSignIn();

}}
