package tests.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignInPage;
import pages.MainPage;
import pages.SendForSignaturePage;
import tests.BaseTestClass;


public class RequestForSignatureTest extends BaseTestClass {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
        HomePage home = new HomePage(driver);
    }
    @Test
    public void request () {
        SignInPage.insertCredentials();
        SignInPage.clickSignIn();

        MainPage.clickrequestEsignature();

        SendForSignaturePage.insertRecipientEmail();
        SendForSignaturePage.fillAgreementName();
        SendForSignaturePage.uploadingTheDocument();
        SendForSignaturePage.sendDocumentforSignature();
    }

    @AfterMethod
    public void teardown () {


        tearDown(driver);
    }
}
