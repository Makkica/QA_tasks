package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePageClass{

   // private static final String requestESignatureString = " //*[@class=\"spectrum-Button spectrum-Button--cta hero-card__StyledButton-sc-9o3auz-4 dmzaKn\"]";
    private static final String requestESignatureString = " //*[@class=\"spectrum-Button spectrum-Button--cta hero-card__StyledButton-sc-9o3auz-4 dmzaKn\"]";
    private static final By requestESignatureLocator = By.xpath(requestESignatureString);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickrequestEsignature () {
        log.debug("clickrequestEsignature");
        WebElement button = getWebElement(requestESignatureLocator);
        button.click();

    }
}
