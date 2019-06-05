package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().goToHomePage();

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNewContactPage();
    ContactData contact = new ContactData("testname", "testsername", "123456789", "test@test", "City", "test1");
    app.getContactHelper().createContact((contact), true);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (ContactData c : after){
     if (c.getId() > max){
       max = c.getId();
     }
    }
    contact.setId(max);
    before.add(contact);

    //TODO: :remove redundant lines
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


    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}