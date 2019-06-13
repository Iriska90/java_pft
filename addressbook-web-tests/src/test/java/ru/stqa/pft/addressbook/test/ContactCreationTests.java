package ru.stqa.pft.addressbook.test;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
          //(enabled = false)
  public void testContactCreation(){
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData().withFirstname("testname").withLastname("testsername").withMobile("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test2");
    app.contact().create((contact), true);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    assertThat(after.size(), equalTo(before.size() + 1));
  }
}