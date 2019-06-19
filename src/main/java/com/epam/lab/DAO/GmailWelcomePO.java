package com.epam.lab.DAO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailWelcomePO {

  @FindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
  public WebElement gotIt;
  @FindBy(id = "com.google.android.gm:id/owner")
  public WebElement ownetTab;
  @FindBy(id = "com.google.android.gm:id/action_done")
  private WebElement actionDone;
  @FindBy(id = "com.google.android.gm:id/gm_dismiss_button")
  private WebElement dismissButton;

  private WebDriverWait wait;

  public GmailWelcomePO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public GmailWelcomePO clickGotIt(){
    gotIt.click();
    return this;
  }

  public GmailWelcomePO clickActionDone(){
    wait.until(ExpectedConditions.visibilityOf(ownetTab));
    actionDone.click();
    return this;
  }

  public GmailWelcomePO clickDismissButton(){
    dismissButton.click();
    return this;
  }
}
