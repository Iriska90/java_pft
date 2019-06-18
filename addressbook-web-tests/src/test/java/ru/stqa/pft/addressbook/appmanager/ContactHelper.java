package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void submitContactCreation() {
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
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

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache !=null){
      return new Contacts (contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath("//tr[@name='entry']/td[2]")).getText();
      String firstname = element.findElement(By.xpath("//tr[@name='entry']/td[3]")).getText();
      String email = element.findElement(By.xpath("//tr[@name='entry']/td[5]")).getText();
      String mobile = element.findElement(By.xpath("//tr[@name='entry']/td[6]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withMobilePhone(mobile).withEmail(email));
    }
    return new Contacts (contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");
    driver.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
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
  // int i = 0;
}