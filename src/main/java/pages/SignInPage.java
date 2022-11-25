package pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends  BasePageClass {
    private static final String userEmailString = "//*[@id=\"userEmail\"]";
    private static final By userEmailLocator = By.xpath(userEmailString);

    private static final String userPasswordString = "//*[@id=\"userPassword\"]";
    private static final By userPasswordLocator = By.xpath(userPasswordString);
    private static final String buttonString = "//*[@id=\"login\"]";
    private static final By buttonLocator = By.xpath(buttonString);

    public SignInPage(WebDriver driver) {
        super(driver);
    }
   /* public void beforeMethod() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://secure.adobesign.com/public/login";
        driver.get(baseUrl);
        HomePage home = new HomePage(driver); */
    public static void insertCredentials() {
    getWebElement(userEmailLocator).sendKeys("janko.praksatests.customusercreation.ui@null.echosignmail.com");
    getWebElement(userPasswordLocator).sendKeys("L8hGZ2d_PwRiUV$");

    }
     public static void clickSignIn () {
    log.debug("clickSignIn");
    WebElement button = getWebElement(buttonLocator);
            button.click();
  }




   /* driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("janko.praksatests.customusercreation.ui@null.echosignmail.com");
    driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("L8hGZ2d_PwRiUV$"); */



}
