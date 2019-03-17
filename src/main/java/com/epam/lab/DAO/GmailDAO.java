package com.epam.lab.DAO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailDAO {
  public Wait wait;
  @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/welcome_tour_got_it']")
  public WebElement gotIt;
  @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/compose_button']")
  public WebElement writeEmail;
  @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/to']")
  public WebElement to;
  @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/subject']")
  public WebElement subject;
  @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/body_wrapper']")
  public WebElement text;

  public GmailDAO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 15);
  }

  public GmailDAO gotIt(){
    gotIt.click();
    return this;
  }

  public GmailDAO writeEmail(){
    writeEmail.click();
    return this;
  }

  public GmailDAO fillEmail(String email){
    to.click();
    to.sendKeys(email);
    to.click();
    return this;
  }

  public GmailDAO fillSubject(String subjectText){
    subject.sendKeys(subjectText);
    return this;
  }

  public GmailDAO fillText(String textText){
    text.sendKeys(textText);
    return this;
  }
}
