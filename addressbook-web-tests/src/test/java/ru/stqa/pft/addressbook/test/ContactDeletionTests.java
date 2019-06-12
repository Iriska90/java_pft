package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactDeletionTests  extends TestBase{

  @BeforeMethod //(enabled = false)
  public void ensurePreconditionsContacts(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.goTo().gotoAddNewContactPage();
      app.contact().create(new ContactData().withFirstname("testname").withLastname("testsername").withMobile("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test //(enabled = false)
  public void testContactDeletion() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
//app.contact().isThereATable();
    app.hardWait(4);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }
}
