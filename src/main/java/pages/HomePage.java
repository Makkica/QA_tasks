package pages;

import data.PageUrlPaths;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePageClass {

  private final String toolsQaHeaderImageLocatorString = "//a[@href='https://demoqa.com']/img[@src='/images/Toolsqa.jpg']";
  private final String elementsCardHeaderLocatorString = "//div[@class='card-body']/h5";

  private final By toolsQaHeaderImageLocator = By.xpath(toolsQaHeaderImageLocatorString);
  private final By elementsCardHeaderLocator = By.xpath(elementsCardHeaderLocatorString);

  private final String HOME_PAGE_URL = getPageUrl(PageUrlPaths.HOME_PAGE);

  public HomePage(WebDriver driver) {
    super(driver);
    log.trace("new HomePage()");
  }

  public HomePage open(boolean bVerify) {
    log.debug("open HomePage(" + HOME_PAGE_URL + ")");
    openUrl(HOME_PAGE_URL);
    if (bVerify) {
      verifyHomePage();
    }
    return this;
  }

  public HomePage open() {
    return open(true);
  }

  public HomePage verifyHomePage() {
    log.debug("verifyHomePage()");
    waitForUrlChange(HOME_PAGE_URL, Time.TIME_SHORTER);
    waitUntilPageIsReady(Time.TIME_SHORT);
    return this;
  }

  public boolean isToolsQaHeaderImageDisplayed() {
    log.debug("isToolsQaHeaderImageDisplayed()");
    return isWebElementDisplayed(toolsQaHeaderImageLocator);
  }

  public boolean isElementsCardDisplayed() {
    log.debug("isElementsCardDisplayed()");
    return isWebElementDisplayed(elementsCardHeaderLocator);
  }

  public void clickElementsCardNoVerify() {
    log.debug("clickElementsCardNoVerify");
    Assert.assertTrue(isElementsCardDisplayed(), "Elements card is NOT displayed on the Home page!");
    WebElement elementsCard = getWebElement(elementsCardHeaderLocator);
    clickOnWebElement(elementsCard);
  }

  public ElementsPage clickElementsCard() {
    log.debug("clickElementsCard()");
    clickElementsCardNoVerify();
    ElementsPage elementsPage = new ElementsPage(driver);
    return elementsPage.verifyElementsPage();
  }


}
