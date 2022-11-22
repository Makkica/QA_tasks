package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utils.LoggerUtils;
import utils.WebDriverUtils;

public abstract class BaseTestClass extends LoggerUtils {

  protected WebDriver setUpDriver() {
    log.debug("setUpDriver()");
    return WebDriverUtils.setUpDriver();
  }

  protected void quitDriver(WebDriver driver) {
    log.debug("quitDriver()");
    WebDriverUtils.quitDriver(driver);
  }

  protected void tearDown(WebDriver driver) {
    quitDriver(driver);
  }

  protected void tearDown(WebDriver driver, ITestResult testResult) {
    String sTestName = testResult.getTestClass().getName();
    log.debug("tearDown(" + sTestName +")");
    try {
      if (testResult.getStatus() == ITestResult.FAILURE) {
        log.warn("Test " + sTestName + " has failed!");
        // Take Screenshot
      }
    } catch (AssertionError | Exception e) {
      log.error("Exception occurred in tearDown(" + sTestName + ")! Message: " + e.getMessage());
    } finally {
      quitDriver(driver);
    }
  }

}
