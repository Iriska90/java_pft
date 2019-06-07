package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
          //(enabled = false)
  public void testContactCreation(){
    app.goTo().homePage();

    List<ContactData> before = app.contact().list();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData().withFirstname("testname").withLastname("testsername").withMobile("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test1");
    app.contact().create((contact), true);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

/*
    int max = 0;
    for (ContactData c : after){
     if (c.getId() > max){
       max = c.getId();
     }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    */

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
    //TODO: :end of redundant lines
*/

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}