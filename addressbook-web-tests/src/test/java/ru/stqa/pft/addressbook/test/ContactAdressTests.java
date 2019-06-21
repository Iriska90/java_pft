package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdressTests extends TestBase {
  @Test
  public  void testContactAdresses(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInformationForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInformationForm.getAddress()));
    //assertThat(contact.getAddress2(), equalTo(contactInformationForm.getAddress2()));
  }
}
