package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToHomePage() {
    click(By.linkText("home page"));
  }

  public void gotoAddNewContactPage() {
    click(By.linkText("add new"));
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