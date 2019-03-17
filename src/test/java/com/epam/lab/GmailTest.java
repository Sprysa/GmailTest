package com.epam.lab;

import com.epam.lab.BO.GmailBO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class GmailTest {

  public AppiumDriver driver;

  @Test
  public void testGmailBO(){
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Y55PSSMR5DKB5L85");
    capabilities.setCapability("appActivity", ".ConversationListActivityGmail");
    capabilities.setCapability("appPackage", "com.google.android.gm");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
    try {
      driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e){
      e.printStackTrace();
    }
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    GmailBO gmail = new GmailBO((AndroidDriver)driver);
    gmail.signIn().writeEmail("sprysa@gmail.com", "Test", "Test body.");
    driver.quit();
  }
}
