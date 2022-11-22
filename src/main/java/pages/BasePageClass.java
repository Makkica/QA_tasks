package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LoggerUtils;
import utils.PropertiesUtils;
import utils.WebDriverUtils;

public abstract class BasePageClass extends LoggerUtils {

  protected WebDriver driver;

  public BasePageClass(WebDriver driver) {
    Assert.assertFalse(WebDriverUtils.hasDriverQuit(driver), "Driver instance has quit!");
    this.driver = driver;
  }

  protected String getPageUrl(String sPath) {
    log.trace("getPageUrl(" + sPath + ")");
    return PropertiesUtils.getBaseUrl() + sPath;
  }

  protected boolean waitForUrlChange(String sUrl, int iTimeout) {
    log.debug("waitForUrlChange(" + sUrl + ", " + iTimeout + ")");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iTimeout));
    return wait.until(ExpectedConditions.urlContains(sUrl));
  }

  protected void openUrl(String url) {
    log.trace("openUrl(" + url + ")");
    driver.get(url);
  }

  protected boolean waitForUrlChangeToExactUrl(String sUrl, int iTimeout) {
    log.trace("waitForUrlChange(" + sUrl + ", " + iTimeout + ")");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iTimeout));
    return wait.until(ExpectedConditions.urlToBe(sUrl));
  }

  protected boolean waitUntilPageIsReady(int iTimeout) {
    log.trace("waitUntilPageIsReady(" + iTimeout + ")");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iTimeout));
    return wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
  }

  protected WebElement getWebElement(By locator) {
    log.trace("getWebElement(" + locator + ")");
    return driver.findElement(locator);
  }

  protected WebElement getWebElement(By locator, int iTimeout) {
    log.trace("getWebElement(" + locator + ", " + iTimeout + ")");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iTimeout));
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected WebElement getWebElement(By locator, int iTimeout, int iPollingTime) {
    log.trace("getWebElement(" + locator + ", " + iTimeout +", " + iPollingTime + ")");
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(iTimeout))
            .pollingEvery(Duration.ofSeconds(iPollingTime))
            .ignoring(NoSuchElementException.class);
    return wait.until(driver -> driver.findElement(locator));
  }

  protected WebElement waitForWebElementToBeClickable(WebElement element, int iTimeout) {
    log.trace("waitForWebElementToBeClickable(" + element + ", " + iTimeout + ")");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iTimeout));
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  protected boolean isWebElementDisplayed(By locator) {
    log.trace("isWebElementDisplayed(" + locator + ")");
    try {
      WebElement webElement = getWebElement(locator);
      return webElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  protected void typeTextToWebElement(WebElement element, String sText) {
    log.trace("typeTextToWebElement(" + element + ", " + sText + ")");
    element.sendKeys(sText);
  }

  protected void clearAndTypeTextToWebElement(WebElement element, String sText) {
    log.trace("typeTextToWebElement(" + element + ", " + sText + ")");
    element.clear();
    element.sendKeys(sText);
  }

  protected String getTextFromWebElement(WebElement element) {
    log.trace("getTextFromWebElement(" + element + ")");
    return element.getText();
  }

  protected String getAttributeFromWebElement(WebElement element, String sAttribute) {
    log.trace("getAttributeFromWebElement(" + element + ", " + sAttribute + ")");
    return element.getAttribute(sAttribute);
  }

  protected String getValueFromWebElement(WebElement element) {
    log.trace("getValueFromWebElement(" + element + ")");
    return getAttributeFromWebElement(element, "value");
  }

  protected String getValueFromWebElementJS(WebElement element) {
    log.trace("getValueFromWebElementJS(" + element + ")");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return (String) js.executeScript("return arguments[0].value", element);
  }

  protected void clickOnWebElement(WebElement element) {
    log.trace("clickOnWebElement(" + element + ")");
    element.click();
  }

  protected void clickOnWebElement(WebElement element, int iTimeout) {
    log.trace("clickOnWebElement(" + element + ", " + iTimeout + ")");
    WebElement webElement = waitForWebElementToBeClickable(element, iTimeout);
    webElement.click();
  }

  protected void clickOnWebElementJS(WebElement element) {
    log.trace("clickOnWebElementJS(" + element + ")");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

}
