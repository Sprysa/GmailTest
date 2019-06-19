package com.epam.lab.PO;

import io.appium.java_client.android.AndroidDriver;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPO {

  @FindBy(id = "com.google.android.gm:id/subject_and_folder_view")
  private WebElement mailSubject;
  @FindBy(id = "com.google.android.gm:id/show_hide_details")
  private WebElement showHideDetails;
  @FindBy(id = "com.google.android.gm:id/to_details")
  private WebElement toDetails;
  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.View[2]/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View")
  private WebElement mailBody;

  private AndroidDriver driver;
  private Logger LOG = Logger.getLogger(String.valueOf(MailPO.class));

  public MailPO(AndroidDriver driver){
    PageFactory.initElements(driver, this);
    this.driver=driver;
  }

  public String readMailSubject(){
    String subject = mailSubject.getText();
    LOG.info("Read subject of mail.");
    return subject;
  }

  public String readMailAddress(){
    showHideDetails.click();
    String address = toDetails.getText();
    LOG.info("Read address of mail.");
    return address;
  }

  public String readMailBody(){
    String body = mailBody.getText();
    LOG.info("Read body of mail.");
    return body;
  }

}
