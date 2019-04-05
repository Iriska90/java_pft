package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("testname", "testsername", "123456789", "test@test", "City"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
  }
}



/*package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.gotoContactPage();
    app.fillContactForm(new ContactData("Second", "Name", "City", "0987654321", "test-test2@gmail.com"));
  }

}
*/