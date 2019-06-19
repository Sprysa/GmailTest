package com.epam.lab.DAO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPO {

  @FindBy(id = "com.google.android.gm:id/subject_and_folder_view")
  public WebElement mailSubject;
  @FindBy(id = "com.google.android.gm:id/show_hide_details")
  public WebElement showHideDetails;
  @FindBy(id = "com.google.android.gm:id/to_details")
  public WebElement toDetails;
//  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.View[2]/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View")
//  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.View[2]/android.webkit.WebView/android.webkit.WebView/android.view.View[3]")
  public WebElement mailBody;

  AndroidDriver driver;

  public MailPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
    this.driver=driver;
  }

  public String readMailSubject(){
    return mailSubject.getText();
  }

  public String readMailAddress(){
    showHideDetails.click();
    return toDetails.getText();
  }

  public String readMailBody(){
//    return mailBody.getText();
    WebElement mailBody = (WebElement) driver.findElementsByClassName("android.view.View").get(5);
    return mailBody.getText();
  }

}
