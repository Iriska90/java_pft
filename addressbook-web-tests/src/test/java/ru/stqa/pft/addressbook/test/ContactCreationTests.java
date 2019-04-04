package ru.stqa.pft.addressbook.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
  private WebDriver driver;


  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testContactCreation() throws Exception {

    gotoAddNewContactPage();
    fillContactForm(new ContactData("testname", "testsername", "123456789", "test@test", "City"));
    submitContactCreation();
  }

  private void submitContactCreation() {
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.name("address2")).click();
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
  }

  private void gotoAddNewContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
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