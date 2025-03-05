package com.example.PracticeAutomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Modals {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  baseUrl = "https://practice-automation.com/";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;
	  }
  @Test
  public void testModals() throws Exception {
    driver.get("https://practice-automation.com/modals/");
    try {
      assertEquals("Modals | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("simpleModal")).click();
    driver.findElement(By.id("pum_popup_title_1318")).click();
    try {
      assertEquals("Simple Modal", driver.findElement(By.id("pum_popup_title_1318")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='popmake-1318']/div[2]/p")).click();
    try {
      assertEquals("Hi, I’m a simple modal.", driver.findElement(By.xpath("//div[@id='popmake-1318']/div[2]/p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='popmake-1318']/button")).click();
    driver.findElement(By.id("formModal")).click();
    driver.findElement(By.id("pum_popup_title_674")).click();
    try {
      assertEquals("Modal Containing A Form", driver.findElement(By.id("pum_popup_title_674")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("g1051-name")).click();
    driver.findElement(By.id("g1051-name")).clear();
    driver.findElement(By.id("g1051-name")).sendKeys("riha");
    driver.findElement(By.id("g1051-name")).clear();
    driver.findElement(By.id("g1051-name")).sendKeys("rihab");
    driver.findElement(By.id("g1051-email")).click();
    driver.findElement(By.id("g1051-email")).clear();
    driver.findElement(By.id("g1051-email")).sendKeys("rihabhammami633@gmail.com");
    driver.findElement(By.id("contact-form-comment-g1051-message")).click();
    driver.findElement(By.id("contact-form-comment-g1051-message")).clear();
    driver.findElement(By.id("contact-form-comment-g1051-message")).sendKeys("hello");
    driver.findElement(By.xpath("//div[@id='contact-form-1051']/form/p/button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
}