package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SendForSignaturePage extends BasePageClass {

    //@FindBy(xpath = "//*[@class=\"recipient-email-input form-control\"]")
     //@FindBy(className = "recipient-email-input form-control")
     @FindBy(css = ".recipient-email-input")
    private WebElement enterRecipientEmailLocator;

    @FindBy (css = ".name")
    private WebElement messageAgreementNameLocator;

    @FindBy (id = "add-files")
    private WebElement addFilesLocator;

   // @FindBy (id = "choose-files-btn")
   // private WebElement chooseFilesLocator;

    @FindBy  (css = "#selectFiles-view19-tab-2") // ovvu kracu foru sam iskoristila jer sam se otelila trazeci i vise nisam mogla :')
    //@FindBy  (xpath = "class[@data-analytics-name='libraryDocuments' and @id'selectFiles-view19-tab-2'")
    private WebElement selectFromTemplateLocator;

    @FindBy (xpath =  "//input[@type='checkbox' and @title='I-9 (Employment Eligibility Verification) ver. 10/21/2019']")
    private WebElement documentLocator;

    @FindBy (css = ".send-btn")
    private WebElement sendDocumentforSignatureLocator;

    @FindBy (css = "button.btn-primary:nth-child(2)") // i ovde sam imala muke da nadjem pravi locator :')
    private WebElement attachDocument;


   // private String documentLocation = "C:\\Users\\RockMobile\\Desktop\\blank_document.pdf";
    private String recipientEmail = "mihajlo.praksatests.customusercreation.ui@null.echosignmail.com";

    public SendForSignaturePage(WebDriver driver) { super(driver); }

    public SendForSignaturePage insertRecipientEmail () {
        waitForWebElementToBeClickable(enterRecipientEmailLocator, 30);
        typeTextToWebElement(enterRecipientEmailLocator, recipientEmail);
        return this;
    }
     public SendForSignaturePage fillAgreementName () {
        waitForWebElementToBeClickable(messageAgreementNameLocator, 10);
        typeTextToWebElement(messageAgreementNameLocator,"Automation");
        return this;
    }

  public SendForSignaturePage uploadingTheDocument () {
        waitForWebElementToBeClickable(addFilesLocator,30).click();
        waitForWebElementToBeClickable(selectFromTemplateLocator,5).click();
        waitForWebElementToBeClickable(documentLocator,10).click();
        waitForWebElementToBeClickable(attachDocument,10).click();
      return this;
    }
  public SendForSignaturePage sendDocumentforSignature () {
        waitForWebElementToBeClickable(sendDocumentforSignatureLocator,10).click();
        return this;
    }
}
