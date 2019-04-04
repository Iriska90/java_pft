package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class GroupCreationTests {
  WebDriver driver;

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }
//Method
  private void login(String username, String password) {
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
//------
  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test33", "test32", "test31"));
    submitGroupCreation();
    returnToGroupPage();
  }  //Methods:

  private void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  private void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }

  private void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }


//----
  @AfterClass
  public void tearDown() throws Exception {
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

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
*/