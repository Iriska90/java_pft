package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase  {
  @Test
  public  void testContactPhones(){
    app.goTo().homePage();
    ContactData contact  = app.contact().all().iterator().next();
    //пред проверка
    //создать необходимый контакт в случае его отсутствия
    ContactData contactInformationForm = app.contact().infoFromEditForm(contact);
  }
}
