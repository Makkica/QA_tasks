package utils;

import data.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Class handling setting up the Web Driver,
 * tearing it down, and other functionality.
 */
public class WebDriverUtils extends LoggerUtils {

  public static WebDriver setUpDriver() {
    WebDriver driver = null;

    /**
     * Get all the relevant data required to set up
     * the Web Driver properly.
     */
    String sBrowser = PropertiesUtils.getBrowser();
    boolean bRemote = PropertiesUtils.getRemote();
    boolean bHeadless = PropertiesUtils.getHeadless();
    String sHubUrl = PropertiesUtils.getHubUrl();
    String sDriversFolder = PropertiesUtils.getDriversFolder();

    String sPathDriverChrome = sDriversFolder + "chromedriver.exe";
    String sPathDriverFirefox = sDriversFolder + "geckodriver.exe";
    String sPathDriverEdge = sDriversFolder + "msedgedriver.exe";

    String sRemote = "";
    if (bRemote)
      sRemote = "Remote";

    log.debug("setUp" + sRemote + " Driver(" + sBrowser + ", Is Headless: " + bHeadless + ")");

    /**
     * Handling of different browsers. Currently supported
     * browser are: Google Chrome, Mozilla Firefox and Microsoft Edge.
     */
    try {
      switch (sBrowser) {
        case "chrome": {
          ChromeOptions options = new ChromeOptions();
          options.setHeadless(bHeadless);
          options.addArguments("--window-size=1600x900");
          if (bRemote) {
            RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(sHubUrl), options);
            remoteDriver.setFileDetector(new LocalFileDetector());
            driver = remoteDriver;
          }
          else {
            System.setProperty("webdriver.chrome.driver", sPathDriverChrome);
            driver = new ChromeDriver(options);
          }
          break;
        }
        case "firefox": {
          FirefoxOptions options = new FirefoxOptions();
          options.setHeadless(bHeadless);
          options.addArguments("--window-size=1600x900");
          if (bRemote) {
            RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(sHubUrl), options);
            remoteDriver.setFileDetector(new LocalFileDetector());
            driver = remoteDriver;
          }
          else {
            System.setProperty("webdriver.gecko.driver", sPathDriverFirefox);
            driver = new FirefoxDriver(options);
          }
          break;
        }
        case "edge": {
          EdgeOptions options = new EdgeOptions();
          options.setHeadless(bHeadless);
          options.addArguments("--window-size=1600x900");
          if (bRemote) {
            RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(sHubUrl), options);
            remoteDriver.setFileDetector(new LocalFileDetector());
            driver = remoteDriver;
          }
          else {
            System.setProperty("webdriver.edge.driver", sPathDriverEdge);
            driver = new EdgeDriver(options);
            break;
          }
        }
        default: {
          Assert.fail("Cannot create driver! Browser '" + sBrowser + "' is not recognized!");
        }
      }
    } catch (MalformedURLException e) {
      Assert.fail("Cannot create driver! Path to browser '" + sBrowser + "' driver is not correct!");
    }

    /**
     * Setting the default global values for Web Driver's Implicit Wait,
     * Page Load Timeout and Script Timeout.
     */
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_TIMEOUT));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Time.PAGE_LOAD_TIMEOUT));
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Time.ASYNC_SCRIPT_TIMEOUT));

    driver.manage().window().maximize();

    return driver;
  }

  /**
   * Check if the driver has quit/died. Logic
   * also allows for checking the status of a remote
   * web driver.
   */
  public static boolean hasDriverQuit(WebDriver driver) {
    if (driver != null) {
      return ((RemoteWebDriver) driver).getSessionId() == null;
    } else {
      return true;
    }
  }

  /**
   * Quits the driver if an instance of it is still active.
   */
  public static void quitDriver(WebDriver driver) {
    if (!hasDriverQuit(driver)) {
      driver.quit();
    }
  }

}