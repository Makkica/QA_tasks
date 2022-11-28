package pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends  BasePageClass {

    @FindBy (xpath ="//*[@id=\'userEmail\']")
    private WebElement userEmailLocator;

    @FindBy (xpath ="//*[@id=\'userPassword\']")
    private WebElement userPasswordLocator;

   @FindBy (xpath = "//*[@id=\'login\']")
    private WebElement buttonLocator;

    private String userEmail ="janko.praksatests.customusercreation.ui@null.echosignmail.com";

    private String userPassword = "L8hGZ2d_PwRiUV$";
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    SignInPage signInPage = new SignInPage(driver);
    public SignInPage insertCredentials() {
        SignInPage signInPage = new SignInPage(driver);
        waitForWebElementToBeClickable(userEmailLocator, 30);
        waitForWebElementToBeClickable(userPasswordLocator, 15);
        typeTextToWebElement(userEmailLocator, userEmail);
        typeTextToWebElement(userPasswordLocator,userPassword);
        return new SignInPage(driver);
    }
     public SignInPage clickSignIn () {


           waitForWebElementToBeClickable(buttonLocator,5).click();
         return signInPage;
     }




   /* driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("janko.praksatests.customusercreation.ui@null.echosignmail.com");
    driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("L8hGZ2d_PwRiUV$"); */



}
