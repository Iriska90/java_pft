package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public void init() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    contactHelper = new ContactHelper(driver);
    driver.get("http://localhost/addressbook/group.php");
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
   driver.quit();
  }

  public boolean isAlertPresent() {
      try {
          driver.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
    }
//Надо? Если надо, создать для SessionHealptr.
  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
/*
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;


  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
 //public StringBuffer verificationErrors = new StringBuffer();
 // private String baseUrl;
 // private boolean acceptNextAlert = true;


  public void init() {
    driver = new FirefoxDriver();
    //baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/");
    sessionHelper = new SessionHelper(driver);
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    driver.quit();
  }

 public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }



  public String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

 public void fillContactForm(ContactData contactData) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contactData.getPhoneNamber());
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  public void gotoContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
*/