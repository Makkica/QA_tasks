package tests.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SendForSignaturePage;
import pages.SignInPage;
import pages.MainPage;

import tests.BaseTestClass;


public class RequestForSignatureTest extends BaseTestClass {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
    }
    @Test
    public void request () {


        SignInPage signInPage = new SignInPage(driver);
        MainPage mainPage = new MainPage(driver);
        SendForSignaturePage sendForSignaturePage = new SendForSignaturePage(driver);

        signInPage.insertCredentials().clickSignIn();
        mainPage.clickrequestEsignature();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendForSignaturePage.insertRecipientEmail();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendForSignaturePage.fillAgreementName();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendForSignaturePage.uploadingTheDocument();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendForSignaturePage.sendDocumentforSignature();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void teardown () {
        tearDown(driver);
    }
}
