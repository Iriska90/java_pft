package ru.stqa.pft.addressbook.model;

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
/*package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String phoneNamber;
  private final String email;

  public ContactData(String firstName, String lastName, String address, String phoneNamber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNamber = phoneNamber;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNamber() {
    return phoneNamber;
  }

  public String getEmail() {
    return email;
  }
}
*/