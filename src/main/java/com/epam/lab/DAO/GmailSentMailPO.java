package com.epam.lab.DAO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSentMailPO {

  @FindBy(id = "android:id/button1")
  public WebElement smartComposeNotificationGotIt;
  @FindBy(id = "com.google.android.gm:id/to")
  public WebElement emailTo;
  @FindBy(id = "com.google.android.gm:id/subject")
  public WebElement emailSubject;
  @FindBy(id = "com.google.android.gm:id/composearea_tap_trap_bottom")
  public WebElement emailBody;
  @FindBy(id = "com.google.android.gm:id/send")
  public WebElement emailSentButton;

  public GmailSentMailPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
  }

  public GmailSentMailPO gotItSmartComposeNotification(){
    smartComposeNotificationGotIt.click();
    return this;
  }

  public GmailSentMailPO fillAddressMail(String address){
    emailTo.click();
    emailTo.sendKeys(address);
    return this;
  }

  public GmailSentMailPO fillSubjectMail(String subject){
    emailSubject.click();
    emailSubject.sendKeys(subject);
    return this;
  }

  public GmailSentMailPO fillBodyMail(String body){
    emailBody.click();
    emailBody.sendKeys(body);
    return this;
  }

  public GmailSentMailPO sentMail(){
    emailSentButton.click();
    return this;
  }

}
