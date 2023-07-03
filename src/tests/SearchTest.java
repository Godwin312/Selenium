package tests;

import org.testng.annotations.Test;

import pages.SearchPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchTest {
  SearchPage sp = new SearchPage();
  @BeforeMethod
  public void beforeMethod() throws IOException {
	    sp.openBrowser();
	    sp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	    sp.closeBrowser();
  }
  
  @Test (priority = 2)
  public void loginWithoutPassword() throws InterruptedException {
	  sp.login("gyfusgjhguy","");
	  String expectedErr = "Please enter your password";
	  String actualErr = sp.readPasswordErr();
	  Assert.assertEquals(actualErr, expectedErr);
	  
  }
  
  @Test (priority = 1)
  public void loginWithoutClient() throws InterruptedException {
	  sp.loginWhClient();
	  String expectedErr = "Please enter a valid client card or username";
	  String actualErr = sp.readClientErr();
	  Assert.assertEquals(actualErr, expectedErr); 
	  
  }
  
  @Test (priority = 3)
  public void loginWithClientAndPassword() throws InterruptedException {
	  sp.login("gyfusgjhguy", "guyghjgy");
	  String expectedErr = "We’re expecting a different answer.\nPlease try again.";
	  String actualErr = sp.readClientPasswordErr();
	  Assert.assertEquals(actualErr, expectedErr);
	  
	  
  }
  
  @Test (priority = 4)
  public void getTitlePage() {
	  String actualTitle = sp.titlePage();
	  String expectedTitle = "RBC Royal Bank – Secure Sign In";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
	  
	  
	  
	  
}


