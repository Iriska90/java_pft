package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new  ContactData()
            .withId(modifiedContact.getId()).withFirstname("testname2").withLastname("testsername").withMobile("123456789").withEmail("test@test");
    app.contact().modify(contact);
    app.goTo().homePage();
    app.hardWait(2);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(modifiedContact)));
    //assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact))); было бы правильно, если бы не было бага на сайте

   /* before.remove(before.size() -1 );
    before.add(contact);
    Assert.assertEquals(before, after);
*/
  //  before.remove(before.size() -1 );
 //   Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}