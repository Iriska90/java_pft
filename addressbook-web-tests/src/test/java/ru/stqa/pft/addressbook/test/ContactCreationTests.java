package ru.stqa.pft.addressbook.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase{

  @Test
          //(enabled = false)
  public void testContactCreation(){
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData().withFirstname("testname").withLastname("testsername").withMobile("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test1");
    app.contact().create((contact), true);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
 /*   //TODO: :remove redundant lines
    System.out.println();
    System.out.println("Comparing: beforeTestGroupsList and" + " " + "afterTestGroupsList");
    for (int i = 0; i < after.size(); i++) {
//            System.out.println(beforeTestContactsList.get(i) + "        " + afterTestContactsList.get(i));
      System.out.println("    Record № " + i);
      System.out.println("before: " + before.get(i));
      System.out.println("after:  " + after.get(i));
      System.out.println();
    }
    //TODO: :end of redundant lines */
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}