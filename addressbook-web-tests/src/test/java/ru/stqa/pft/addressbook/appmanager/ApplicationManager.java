package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver driver;

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;

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
    driver.get("http://localhost/addressbook/group.php");
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
   driver.quit();
  }


//Надо?
  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
  public SessionHelper getSessionHelper(){
    return sessionHelper;
  }
  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
