package com.epam.lab.PO;

import io.appium.java_client.android.AndroidDriver;
import java.util.logging.Logger;
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

  private Logger LOG = Logger.getLogger(String.valueOf(GmailMainPO.class));

  public GmailMainPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
  }

  public GmailMainPO clickComposeButton(){
    composeButton.click();
    LOG.info("Click 'Compose' button.");
    return this;
  }

  public GmailMainPO openMenu(){
    menuButton.click();
    LOG.info("Click 'Menu' button.");
    return this;
  }

  public GmailMainPO openSentMailActivity(){
    sentMailActivityButton.click();
    LOG.info("Click 'Sent' button.");
    return this;
  }

  public GmailMainPO openLastSentMail(){
    lastSentMailButton.click();
    LOG.info("Open last mail.");
    return this;
  }
}
