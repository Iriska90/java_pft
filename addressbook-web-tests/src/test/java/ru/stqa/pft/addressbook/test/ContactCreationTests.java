package ru.stqa.pft.addressbook.test;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test //(enabled = false)
  public void testContactCreation(){
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData().withFirstname("testname").withLastname("testsername")
            .withHomePhone("+8(057)681287").withMobilePhone("123 456 789").withWorkPhone("01-00-10")
            .withFirstEmail("test@test").withSecondEmail("test2@test").withThirdEmail("test3@test")
            .withAddress("Town").withAddress2("City")
            .wihtGroup("test2").withPhoto(photo);
    app.contact().create((contact), true);
    app.goTo().homePage();

    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

  @Test (enabled = false)
  public void testBadContactCreation(){
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData().withFirstname("testname' ").withLastname("testsername' ")
            .withHomePhone("057681287").withMobilePhone("123456789").withWorkPhone("010010")
            .withFirstEmail("test@test").withSecondEmail("test2@test").withThirdEmail("test3@test")
            .withAddress("Town")
            .wihtGroup("test2");
    //ContactData contact = new ContactData().withFirstname("testname' ").withLastname("testsername' ").withMobilePhone("123456789").withEmail("test@test").withAddress2("City").wihtGroup("test2");
    app.contact().create((contact), true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));

  }

  @Test  (enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}