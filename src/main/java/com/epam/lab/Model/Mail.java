package com.epam.lab.Model;

public class Mail {

  private String email;
  private String subj;
  private String body;

  public Mail() {}

  public Mail(String email, String subj, String body) {
    this.email = email;
    this.subj = subj;
    this.body = body;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSubj() {
    return subj;
  }

  public void setSubj(String subj) {
    this.subj = subj;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
