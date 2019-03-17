package com.epam.lab.BO;

import com.epam.lab.DAO.GmailDAO;
import io.appium.java_client.android.AndroidDriver;

public class GmailBO {
  private GmailDAO gmailDAO;

  public GmailBO(AndroidDriver driver){
    gmailDAO = new GmailDAO(driver);
  }

  public GmailBO signIn(){
    gmailDAO.gotIt();
    return this;
  }

  public GmailBO writeEmail(String email, String subject, String body){
    gmailDAO.writeEmail().fillEmail(email).fillSubject(subject).fillText(body);
    return this;
  }
}
