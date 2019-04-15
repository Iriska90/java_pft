package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests  extends TestBase{
  @Test
  public void testContactDeletion() {
      app.getNavigationHelper().goToHomePage();
      if(! app.getContactHelper().isThereAContact()){
        app.getNavigationHelper().gotoAddNewContactPage();
        app.getContactHelper().createContact(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
        app.getNavigationHelper().goToHomePage();
      }
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContacts();
      app.getNavigationHelper().goToHomePage();
  }
}

