package com.epam.lab.PO;

import io.appium.java_client.android.AndroidDriver;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSentMailPO {

  @FindBy(id = "android:id/button1")
  private WebElement smartComposeNotificationGotIt;
  @FindBy(id = "com.google.android.gm:id/to")
  private WebElement emailTo;
  @FindBy(id = "com.google.android.gm:id/subject")
  private WebElement emailSubject;
  @FindBy(id = "com.google.android.gm:id/composearea_tap_trap_bottom")
  private WebElement emailBody;
  @FindBy(id = "com.google.android.gm:id/send")
  private WebElement emailSentButton;

  private Logger LOG = Logger.getLogger(String.valueOf(GmailSentMailPO.class));

  public GmailSentMailPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
  }

  public GmailSentMailPO gotItSmartComposeNotification(){
    smartComposeNotificationGotIt.click();
    LOG.info("Got it 'Smart Compose Notification'.");
    return this;
  }

  public GmailSentMailPO fillAddressMail(String address){
    emailTo.click();
    emailTo.sendKeys(address);
    LOG.info("Fill mail address.");
    return this;
  }

  public GmailSentMailPO fillSubjectMail(String subject){
    emailSubject.click();
    emailSubject.sendKeys(subject);
    LOG.info("Fill mail subject.");
    return this;
  }

  public GmailSentMailPO fillBodyMail(String body){
    emailBody.click();
    emailBody.sendKeys(body);
    LOG.info("Fill mail body.");
    return this;
  }

  public GmailSentMailPO sentMail(){
    emailSentButton.click();
    LOG.info("Click sent button.");
    return this;
  }

}
