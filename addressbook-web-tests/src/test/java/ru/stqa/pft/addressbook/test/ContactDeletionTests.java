package ru.stqa.pft.addressbook.test;

import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeletionTests  extends TestBase{
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();

    if(! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
    }

    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToHomePage();


//app.getContactHelper().isThereATable();
    app.hardWait(2);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() -1 );
    for (int i = 0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i), after.get(i));
    }
  }
}
