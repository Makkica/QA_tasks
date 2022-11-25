package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendForSignaturePage extends BasePageClass {

    private static final String enterRecipientEmailString = "//*[@class=\"recipient-email-input form-control\"]";
    private static final By enterRecipientEmailLocator = By.xpath(enterRecipientEmailString);

    private static final String messageAgreementNameString =" //*[@class=\"name agreement-name form-control\"]";
    private static final By messageAgreementNameLocator = By.xpath(messageAgreementNameString);

    private static final String addFilesString = "//*[@id=\"add-files\"]";
    private static final By addFilesLocator = By.xpath(addFilesString);

    private static final String chooseFilesString = "//*[@id=\"choose-files-btn\"]";
    private static final By chooseFilesLocator = By.xpath(chooseFilesString);

    private static final String sendDocumentforSignatureString = "//*[contains(@class, \"btn btn-primary send-btn)]";
    private static final By sendDocumentforSignatureLocator = By.xpath(sendDocumentforSignatureString);

    private static final String documentLocation = "C:\\Users\\RockMobile\\Desktop\\blank document.pdf";

    public SendForSignaturePage(WebDriver driver) {
        super(driver);
    }

    public static void insertRecipientEmail () {
        getWebElement(enterRecipientEmailLocator).sendKeys("mihajlo.praksatests.customusercreation.ui@null.echosignmail.com");
    }
    public static void fillAgreementName () {
        getWebElement(messageAgreementNameLocator).sendKeys("Automation");
    }

    public static void uploadingTheDocument () {
        getWebElement(addFilesLocator);
        getWebElement(chooseFilesLocator).sendKeys(documentLocation);
    }
    public static void sendDocumentforSignature () {
        WebElement button = getWebElement(sendDocumentforSignatureLocator);
        button.click();
    }
}
