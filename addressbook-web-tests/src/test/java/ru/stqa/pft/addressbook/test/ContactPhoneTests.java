package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase  {
  @Test
  public  void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    //пред проверка
    //создать необходимый контакт в случае его отсутствия
    ContactData contactInformationForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInformationForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInformationForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInformationForm.getWorkPhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
