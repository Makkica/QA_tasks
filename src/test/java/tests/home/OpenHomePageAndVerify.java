package tests.home;

import data.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestClass;
import utils.DateTimeUtils;

public class OpenHomePageAndVerify extends BaseTestClass {

  @Test
  public void testOpenHomePageAndVerify() {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver).open();
    DateTimeUtils.wait(Time.TIME_SHORTER);
    Assert.assertTrue(homePage.isToolsQaHeaderImageDisplayed());
    DateTimeUtils.wait(Time.TIME_SHORTEST);
    tearDown(driver);
  }

}
