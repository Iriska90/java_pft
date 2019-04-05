package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("testname", "testsername", "123456789", "test@test", "City"));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
  }
}






