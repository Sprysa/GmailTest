package com.epam.lab.BO;

import com.epam.lab.DAO.GmailMainPO;
import com.epam.lab.DAO.GmailSentMailPO;
import com.epam.lab.DAO.GmailWelcomePO;
import com.epam.lab.DAO.MailPO;
import com.epam.lab.Model.Mail;
import io.appium.java_client.android.AndroidDriver;
import org.springframework.util.Assert;

public class GmailBO {
  private GmailWelcomePO gmailWelcomePO;
  private GmailMainPO gmailMainPO;
  private GmailSentMailPO gmailSentMailPO;
  private MailPO mailPO;

  public GmailBO(AndroidDriver driver){
    gmailWelcomePO = new GmailWelcomePO(driver);
    gmailMainPO = new GmailMainPO(driver);
    gmailSentMailPO = new GmailSentMailPO(driver);
    mailPO = new MailPO(driver);
  }

  public GmailBO signIn(){
    gmailWelcomePO.clickGotIt();
    gmailWelcomePO.clickActionDone();
    gmailWelcomePO.clickDismissButton();
    gmailWelcomePO.clickDismissButton();
    return this;
  }

  public GmailBO sentEmail(Mail email){
    gmailMainPO.clickComposeButton();
    gmailSentMailPO.gotItSmartComposeNotification();
    gmailSentMailPO.fillAddressMail(email.getAddress());
    gmailSentMailPO.fillSubjectMail(email.getSubject());
    gmailSentMailPO.fillBodyMail(email.getBody());
    gmailSentMailPO.sentMail();
    return this;
  }

  public GmailBO verifyMailIsSent(Mail email) {
    gmailMainPO.openMenu();
    gmailMainPO.openSentMailActivity();
    gmailMainPO.openLastSentMail();
    boolean isSameSubject = mailPO.readMailSubject().contains(email.getSubject());
    boolean isSameAddress = mailPO.readMailAddress().equalsIgnoreCase(email.getAddress());
//    boolean isSameBody = mailPO.readMailBody().equalsIgnoreCase(email.getBody());
    Assert.isTrue(isSameSubject && isSameAddress /*&& isSameBody*/, "Mail is not in 'Sent' folder");
    return this;
  }
}
