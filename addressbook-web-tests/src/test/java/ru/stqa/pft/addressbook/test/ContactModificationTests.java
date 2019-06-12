package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
          //(enabled = false)
  public void ensurePreconditionsContacts(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.goTo().gotoAddNewContactPage();
      app.contact().create(new ContactData().withFirstname("testname").withLastname("testsername").withMobile("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
          //(enabled = false)
  public void testContactModification() {
    //app.contact().isThereATable();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new  ContactData()
            .withId(modifiedContact.getId()).withFirstname("testname2").withLastname("testsername").withMobile("123456789").withEmail("test@test");
    app.contact().modify(contact);
    app.goTo().homePage();

    app.hardWait(2);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(modifiedContact);
   // before.add(contact);
    Assert.assertEquals(before, after);

   /* before.remove(before.size() -1 );
    before.add(contact);
    Assert.assertEquals(before, after);
*/
  //  before.remove(before.size() -1 );
 //   Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}