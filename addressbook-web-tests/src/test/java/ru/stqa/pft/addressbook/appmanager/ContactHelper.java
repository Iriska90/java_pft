package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void submitContactCreation() {
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }
/*
  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = driver.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return contacts;
  }
*/
  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache !=null){
      return new Contacts (contactCache);
    }
    contactCache = new Contacts();
  //  List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
    List<WebElement> rows = driver.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      String[] emails = cells.get(4).getText().split("\n");
      String[] addresses = cells.get(3).getText().split("\n");

       //int id = Integer.parseInt(cells.findElement(By.tagName("input")).getAttribute("value"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
              .withFirstEmail(emails[0]).withSecondEmail(emails[1]).withThirdEmail(emails[2]).withAddress(addresses[0]));

      //contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withEmail(email));

    }
    return new Contacts (contactCache);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());

    type(By.name("email"), contactData.getFirstEmail());
    type(By.name("email2"), contactData.getSecondEmail());
    type(By.name("email3"), contactData.getThirdEmail());

    type(By.name("address"), contactData.getAddress());
    type(By.name("address2"), contactData.getAddress2());

    if (creation) {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContactById(int id) {
    driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    driver.switchTo().alert().accept();
  }

  public void editContact(int i) {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    fillContactForm((contact), true);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    editContact(contact.getId());
    fillContactForm((contact), false);
    updateContact();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
   return driver.findElements(By.name("selected[]")).size();
  }



  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");

    String email = driver.findElement(By.name("email")).getAttribute("value");
    String email2 = driver.findElement(By.name("email2")).getAttribute("value");
    String email3 = driver.findElement(By.name("email3")).getAttribute("value");

    String address = driver.findElement(By.name("address")).getAttribute("value");
    String address2 = driver.findElement(By.name("address2")).getAttribute("value");

    driver.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withFirstEmail(email).withSecondEmail(email2).withThirdEmail(email3).withAddress(address).withAddress2(address2);
  }

  private void initContactModificationById(int id) {
    // Находим чекбокс методом последовательных приближений
    WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //Используя язык запросов икспас
    //driver.findElement(By.xpath(String.format("input[@value='%s']/../td[8]/a", id))).click();
    //
    //driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //
    //driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']"))).click();
  }


  // public boolean isThereATable(){
    //return isElementPresent(By.name("selected[]"));
  //  return isElementPresent(By.tagName("tbody"));
  //  return isElementPresent(By.name("selected[]"));
 // }

   /*
    List<WebElement> lastnames = driver.findElements(By.xpath("//tr[@name='entry']/td[3]"));
    List<WebElement> firstnames = driver.findElements(By.xpath("//tr[@name='entry']/td[2]"));
    List<WebElement> emails = driver.findElements(By.xpath("//tr[@name='entry']/td[5]"));
    List<WebElement> mobiles = driver.findElements(By.xpath("//tr[@name='entry']/td[6]"));
    */
}