package com.epam.lab;

import static com.epam.lab.DataProvider.MailDataConst.*;

import com.epam.lab.BO.GmailBO;
import com.epam.lab.Model.Mail;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {

  private AndroidDriver driver;
//  public static final Logger LOG = LogManager.getLogger((String)GmailTest.class);
  Logger LOG = Logger.getLogger(String.valueOf(GmailTest.class));

  @BeforeTest
  private void init() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Y55PSSMR5DKB5L85");
    capabilities.setCapability("appActivity", ".ConversationListActivityGmail");
    capabilities.setCapability("appPackage", "com.google.android.gm");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
    try {
      driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e){
      e.printStackTrace();
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testGmailBO(){
    Mail mail = new Mail(EMAIL_ADDRESS, SUBJECT, BODY);
    GmailBO gmail = new GmailBO(driver);
    LOG.info("START TESTING.");
    LOG.info("Step 1. Sign in to Gmail.");
    gmail.signIn();
    LOG.info("Step 2. Create and send mail.");
    gmail.sentEmail(mail);
    LOG.info("Step 3. Verify that mail is in 'Sent' folder.");
    gmail.verifyMailIsSent(mail);
    LOG.info("END TESTING.");
  }

  @AfterTest
  private void deinit() {
    driver.quit();
  }
}
