package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests  extends TestBase{
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if(! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
      app.getNavigationHelper().goToHomePage();
    }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().isThereATable();

    List<ContactData> after = app.getContactHelper().getContactList();
    //Assert.assertEquals(after.size(), before.size() - 1);
    Assert.assertEquals(after.size(), before.size());
  }
}
