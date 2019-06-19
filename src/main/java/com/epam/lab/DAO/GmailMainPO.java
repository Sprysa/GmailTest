package com.epam.lab.DAO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailMainPO {

  @FindBy(id = "com.google.android.gm:id/compose_button")
  public WebElement composeButton;
  @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
  public WebElement menuButton;
  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[9]")
  public WebElement sentMailActivityButton;
  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.view.View/android.view.View[1]")
  public WebElement lastSentMailButton;

  public GmailMainPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
  }

  public GmailMainPO clickComposeButton(){
    composeButton.click();
    return this;
  }

  public GmailMainPO openMenu(){
    menuButton.click();
    return this;
  }

  public GmailMainPO openSentMailActivity(){
    sentMailActivityButton.click();
    return this;
  }

  public GmailMainPO openLastSentMail(){
    lastSentMailButton.click();
    return this;
  }
}
