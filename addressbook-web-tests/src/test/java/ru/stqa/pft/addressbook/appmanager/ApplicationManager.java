package ru.stqa.pft.addressbook.appmanager;

import java.lang.Thread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver driver;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;
  private ContactHelper contactHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)){
      driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
      driver = new ChromeDriver();
    } else if(browser.equals(BrowserType.IE)){
      driver = new InternetExplorerDriver();
    }

    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    contactHelper = new ContactHelper(driver);
    driver.get("http://localhost/addressbook");
    sessionHelper.login("admin", "secret");
  }
  public void hardWait(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  public void stop() {
   driver.quit();
  }
  public GroupHelper group() {
    return groupHelper;
  }
  public NavigationHelper goTo() {
    return navigationHelper;
  }
  public SessionHelper getSessionHelper(){
    return sessionHelper;
  }
  public ContactHelper contact() {
    return contactHelper;
  }
}
