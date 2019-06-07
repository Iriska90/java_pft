package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod (enabled = false)
  public void ensurePreconditionsContacts(){
    app.getNavigationHelper().goToHomePage();
    if(! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
      app.getNavigationHelper().goToHomePage();
    }
  }

  @Test (enabled = false)
  public void testContactModification() {
    //app.getContactHelper().isThereATable();
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    ContactData contact = new  ContactData(before.get(index).getId(), "testname2", "testsername", "123456789", "test@test");
    app.getContactHelper().modifyContact(index, contact);
    app.getNavigationHelper().goToHomePage();

    app.hardWait(2);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
   // before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

   /* before.remove(before.size() -1 );
    before.add(contact);
    Assert.assertEquals(before, after);
*/
  //  before.remove(before.size() -1 );
 //   Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}