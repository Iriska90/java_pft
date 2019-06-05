package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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

  public void selectContact(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
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

  public void createContact(ContactData contact, boolean b) {
    fillContactForm((contact), true);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

 // public int getContactCount() {
   // return driver.findElements(By.name("selected[]")).size();
  //}

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
    /*
    List<WebElement> lastnames = driver.findElements(By.xpath("//tr[@name='entry']/td[3]"));
    List<WebElement> firstnames = driver.findElements(By.xpath("//tr[@name='entry']/td[2]"));
    List<WebElement> emails = driver.findElements(By.xpath("//tr[@name='entry']/td[5]"));
    List<WebElement> mobiles = driver.findElements(By.xpath("//tr[@name='entry']/td[6]"));
    */
   // int i = 0;
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath("//tr[@name='entry']/td[2]")).getText();
      String firstname = element.findElement(By.xpath("//tr[@name='entry']/td[3]")).getText();
      String email = element.findElement(By.xpath("//tr[@name='entry']/td[5]")).getText();
      String mobile = element.findElement(By.xpath("//tr[@name='entry']/td[6]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, lastname, mobile, email);
      contacts.add(contact);
    }
    return contacts;
  }


 // public boolean isThereATable(){
    //return isElementPresent(By.name("selected[]"));
  //  return isElementPresent(By.tagName("tbody"));
  //  return isElementPresent(By.name("selected[]"));
 // }
}