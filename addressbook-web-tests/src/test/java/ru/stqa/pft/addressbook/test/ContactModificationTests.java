package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if(! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
      app.getNavigationHelper().goToHomePage();
    }

    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm( new ContactData("testname2", "testsername", "123456789", "test@test", "City", null), false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
  }
}







