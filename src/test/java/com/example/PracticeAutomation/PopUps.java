package com.example.PracticeAutomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopUps {
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
  public void testPopUps() throws Exception {
    driver.get("https://practice-automation.com");
    driver.findElement(By.linkText("Popups")).click();
    try {
    
    //Verify Title
    WebElement pageTitle=driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
    assertEquals("Popups", pageTitle.getText());
   
   //alertPopup
    driver.findElement(By.xpath("//button[@id='alert']/b")).click();
    acceptNextAlert = true;
    assertEquals("Hi there, pal!", closeAlertAndGetItsText());
   
    //ConfirmPopup
    driver.findElement(By.xpath("//button[@id='confirm']/b")).click();
    assertTrue(closeAlertAndGetItsText().matches("^OK or Cancel, which will it be[\\s\\S]$"));
    driver.findElement(By.id("confirmResult")).click();
    acceptNextAlert = false;
    assertEquals("OK it is!", driver.findElement(By.id("confirmResult")).getText());
   
    //CancelPopup
    driver.findElement(By.xpath("//button[@id='confirm']/b")).click();
    assertTrue(closeAlertAndGetItsText().matches("^OK or Cancel, which will it be[\\s\\S]$"));
    driver.findElement(By.id("confirmResult")).click();
    assertEquals("Cancel it is!", driver.findElement(By.id("confirmResult")).getText());
  
    //Prompt PopUp
    driver.findElement(By.id("prompt")).click();
     //switch to the alert (prompt) and send text
	 Alert alert = driver.switchTo().alert(); 
	 alert.sendKeys("rihab");  
	 //submit the input
	 alert.accept();  
	 //Verify the result after the prompt is accepted
	 String resultText = driver.findElement(By.id("promptResult")).getText();
	 assertEquals("Nice to meet you, rihab!", resultText);
      
	 driver.findElement(By.id("prompt")).click();
	//  Switch to the second alert and cancel it
	alert = driver.switchTo().alert();  // Switching to the second alert
	alert.dismiss();  //cancel 
	// Verify the result after canceling the second prompt
	String cancelResultText = driver.findElement(By.id("promptResult")).getText();
	assertEquals("Fine, be that way...", cancelResultText); 
     
	
      driver.findElement(By.xpath("//div[@onclick='showTooltip()']")).click();
      driver.findElement(By.id("myTooltip")).click();
      
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
   
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