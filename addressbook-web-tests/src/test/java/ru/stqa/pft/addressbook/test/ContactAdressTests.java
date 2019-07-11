package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdressTests extends TestBase {

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
  @Test
  public  void testContactAdresses(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInformationForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInformationForm.getAddress()));
    //assertThat(contact.getAddress2(), equalTo(contactInformationForm.getAddress2()));
  }
}
