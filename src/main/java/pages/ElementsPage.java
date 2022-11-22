package pages;

import data.PageUrlPaths;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePageClass {

  private final String elementsHeaderLocatorString = "//div[@class='main-header']";

  private final By elementsHeaderLocator = By.xpath(elementsHeaderLocatorString);

  private final String ELEMENTS_PAGE_URL = getPageUrl(PageUrlPaths.ELEMENTS_PAGE);

  public ElementsPage(WebDriver driver) {
    super(driver);
    log.trace("new ElementsPage()");
  }

  public ElementsPage open(boolean bVerify) {
    log.debug("open ElementsPage(" + ELEMENTS_PAGE_URL + ")");
    openUrl(ELEMENTS_PAGE_URL);
    if (bVerify) {
      verifyElementsPage();
    }
    return this;
  }

  public ElementsPage open() {
    return open(true);
  }

  public ElementsPage verifyElementsPage() {
    log.debug("verifyElementsPage()");
    waitForUrlChange(ELEMENTS_PAGE_URL, Time.TIME_SHORTER);
    waitUntilPageIsReady(Time.TIME_SHORT);
    return this;
  }

  public boolean isTextBoxHeaderDisplayed() {
    log.debug("isTextBoxHeaderDisplayed()");
    return isWebElementDisplayed(elementsHeaderLocator);
  }

}
