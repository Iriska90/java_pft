package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTests  extends TestBase{
  @Test
  public void testContactDeletion() {
      app.getNavigationHelper().goToHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContacts();
      app.getNavigationHelper().goToHomePage();

  }
}
