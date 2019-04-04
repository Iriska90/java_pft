package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

  private WebDriver driver;

  public NavigationHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  public void goToHomePage() {
    driver.findElement(By.linkText("home page")).click();
  }

  public void gotoAddNewContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }
}
/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);

  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
*/