package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod (enabled = false)
  public void ensurePreconditionsContacts(){
    app.goTo().homePage();
    if(app.contact().list().size() == 0){
      app.goTo().gotoAddNewContactPage();
      app.contact().create(new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1"), true);
      app.goTo().homePage();
    }
  }

  @Test (enabled = false)
  public void testContactModification() {
    //app.contact().isThereATable();
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new  ContactData(before.get(index).getId(), "testname2", "testsername", "123456789", "test@test");
    app.contact().modify(index, contact);
    app.goTo().homePage();

    app.hardWait(2);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

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