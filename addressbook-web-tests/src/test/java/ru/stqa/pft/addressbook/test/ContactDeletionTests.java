package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests  extends TestBase{

  @BeforeMethod //(enabled = false)
  public void ensurePreconditionsContacts(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.goTo().gotoAddNewContactPage();
      app.contact().create(new ContactData().withFirstname("testname").withLastname("testsername")
              .withHomePhone("057681287").withMobilePhone("123456789").withWorkPhone("010010")
              .withFirstEmail("test@test").withSecondEmail("test2@test").withThirdEmail("test3@test")
              .withAddress("Town").withAddress2("City")
              .wihtGroup("test2"), true);

      app.goTo().homePage();
    }
  }

  @Test //(enabled = false)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
//app.contact().isThereATable();
    app.hardWait(4);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}
