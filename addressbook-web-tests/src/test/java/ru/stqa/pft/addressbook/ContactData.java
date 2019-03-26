package ru.stqa.pft.addressbook;

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
