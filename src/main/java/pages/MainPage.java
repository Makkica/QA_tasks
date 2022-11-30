package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePageClass{

    private final String requestESignatureString = "//*[@class=\"spectrum-Button spectrum-Button--cta hero-card__StyledButton-sc-9o3auz-4 dmzaKn\"]";
    private final By requestESignatureLocator = By.xpath(requestESignatureString);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickrequestEsignature () {
        log.debug("clickrequestEsignature");
//        waitForWebElementToBeClickable(requestESignatureLocator,10);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement button = getWebElement(requestESignatureLocator);
        button.click();

    }
}
