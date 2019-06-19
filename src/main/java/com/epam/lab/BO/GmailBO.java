package com.epam.lab.BO;

import com.epam.lab.Model.Mail;
import com.epam.lab.PO.GmailMainPO;
import com.epam.lab.PO.GmailSentMailPO;
import com.epam.lab.PO.GmailWelcomePO;
import com.epam.lab.PO.MailPO;
import io.appium.java_client.android.AndroidDriver;
import org.springframework.util.Assert;

public class GmailBO {

  private GmailWelcomePO gmailWelcomePO;
  private GmailMainPO gmailMainPO;
  private GmailSentMailPO gmailSentMailPO;
  private MailPO mailPO;

  public GmailBO(AndroidDriver driver) {
    gmailWelcomePO = new GmailWelcomePO(driver);
    gmailMainPO = new GmailMainPO(driver);
    gmailSentMailPO = new GmailSentMailPO(driver);
    mailPO = new MailPO(driver);
  }

  public GmailBO signIn() {
    gmailWelcomePO.clickGotIt()
        .clickActionDone()
        .clickDismissButton()
        .clickDismissButton();
    return this;
  }

  public GmailBO sentEmail(Mail email) {
    gmailMainPO.clickComposeButton();
    gmailSentMailPO.gotItSmartComposeNotification()
        .fillAddressMail(email.getAddress())
        .fillSubjectMail(email.getSubject())
        .fillBodyMail(email.getBody())
        .sentMail();
    return this;
  }

  public GmailBO verifyMailIsSent(Mail email) {
    gmailMainPO.openMenu()
        .openSentMailActivity()
        .openLastSentMail();
    boolean isSameSubject = mailPO.readMailSubject().contains(email.getSubject());
    boolean isSameAddress = mailPO.readMailAddress().equalsIgnoreCase(email.getAddress());
    boolean isSameBody = mailPO.readMailBody().equalsIgnoreCase(email.getBody());
    Assert.isTrue(isSameSubject && isSameAddress && isSameBody, "Mail is not in 'Sent' folder");
    return this;
  }
}
