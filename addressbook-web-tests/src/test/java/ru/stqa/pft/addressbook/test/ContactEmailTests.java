package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {
  @Test
  public  void testContactAdresses(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInformationForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getFirstEmail(), equalTo(contactInformationForm.getFirstEmail()));
    assertThat(contact.getSecondEmail(), equalTo(contactInformationForm.getSecondEmail()));

  }
}
