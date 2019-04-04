package ru.stqa.pft.addressbook.test;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String address2;

  public ContactData(String firstname, String lastname, String mobile, String email, String address2) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address2 = address2;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress2() {
    return address2;
  }
}
