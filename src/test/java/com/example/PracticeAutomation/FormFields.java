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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.practiceautomation.po.FormFieldsPage;

public class FormFields {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  FormFieldsPage formFieldsPage;
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  formFieldsPage=new FormFieldsPage(driver);
	  baseUrl = "https://practice-automation.com/";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;
	  }

  
///////////////////////// script lineaire ////////////////////////////////////////////////////

 // @Test
  public void testFormFields() throws Exception {
      driver.get("https://practice-automation.com/form-fields/");
      
      try {
          // Verify page title
    	  WebElement pageTitle=driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
          assertEquals("Form Fields", pageTitle.getText());

          // Fill Name field
          WebElement nameInput = driver.findElement(By.id("name-input"));
          nameInput.click();
          nameInput.sendKeys("rihab");

          // Verify required field message
          WebElement requiredMsg=driver.findElement(By.xpath("//form[@id='feedbackForm']/p"));
          assertTrue(requiredMsg.getText().contains("Required"));

          // Fill Password field
          WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
          passwordInput.click();
          passwordInput.sendKeys("rihab");
          
       // Define WebDriverWait For scrolling
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          JavascriptExecutor js = (JavascriptExecutor) driver; 

          // check Drinks
          String[] drinks = {"drink1", "drink2", "drink3", "drink4", "drink5"};
          for (String drinkId : drinks) {
              WebElement drink = wait.until(ExpectedConditions.elementToBeClickable(By.id(drinkId)));
              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", drink);// Scroll
              Thread.sleep(500); 
              drink.click();
              assertTrue(drink.isSelected());
          }
          
          //Check colors
          String[] colors= {"color1","color2","color3","color4","color5",};
          for (String colorId : colors) {
              WebElement color = wait.until(ExpectedConditions.elementToBeClickable(By.id(colorId)));
              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", color);// Scroll
              Thread.sleep(500); 
              color.click();
              assertTrue(color.isSelected());
          }
          
          
       // Select dropdown options
       // Find 1st dropdown
       WebElement dropDown = driver.findElement(By.id("automation"));

       // Select "Yes"
       Select automationDropdown = new Select(dropDown);
       automationDropdown.selectByVisibleText("Yes");
       assertEquals("Yes", automationDropdown.getFirstSelectedOption().getText());

       // Click the dropdown again to ensure it refreshes
       dropDown.click();
       Thread.sleep(500); 

       // Select "No"
       automationDropdown.selectByVisibleText("No");
       assertEquals("No", automationDropdown.getFirstSelectedOption().getText());
          
       dropDown.click();
       Thread.sleep(500);  
       
    // Select "Undecided"
       automationDropdown.selectByVisibleText("Undecided");
       assertEquals("Undecided", automationDropdown.getFirstSelectedOption().getText());
       
        
       // Verify selectable list options
       WebElement selenium = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li"));
       js.executeScript("arguments[0].scrollIntoView(true);", selenium);
       assertEquals("Selenium", selenium.getText());

       WebElement playwright = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[2]"));
       js.executeScript("arguments[0].scrollIntoView(true);", playwright);
       assertEquals("Playwright", playwright.getText());

       WebElement cypress = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[3]"));
       js.executeScript("arguments[0].scrollIntoView(true);", cypress);
       assertEquals("Cypress", cypress.getText());

       WebElement appium = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[4]"));
       js.executeScript("arguments[0].scrollIntoView(true);", appium);
       assertEquals("Appium", appium.getText());

       WebElement katalon = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[5]"));
       js.executeScript("arguments[0].scrollIntoView(true);", katalon);
       assertEquals("Katalon Studio", katalon.getText());

       Thread.sleep(500); 
          // Fill email and message
          WebElement emailField = driver.findElement(By.id("email"));
          emailField.click();
          emailField.clear();
          emailField.sendKeys("rihabhammami633@gmail.com");
         
          WebElement messageField = driver.findElement(By.id("message"));
          messageField.click();
          messageField.clear();
          messageField.sendKeys("hello");
          
          // Submit form
          driver.findElement(By.id("submit-btn")).click();
          assertEquals("Message received!", closeAlertAndGetItsText());

      } catch (Error e) {
          verificationErrors.append(e.toString());
      }
  }
  /////////////////////////// script structurel ///////////////////////////////////
   @Test
  public void testFormFieldsPage() throws Exception {
	   driver.get("https://practice-automation.com/form-fields/");
	   formFieldsPage.log.info("Ouverture de la page web");
	   //verifyTitle
	   assertEquals("Form Fields",formFieldsPage.getTitle().getText());
	   
	  //Fill Name field
	   formFieldsPage.getNameInput().sendKeys("rihab");
	   formFieldsPage.log.info("saisie du texte dans le champs name");
	   
	   //Fill Password
	   formFieldsPage.getPasswordInput().sendKeys("rihab");	 
	   
	  
       //verify required text
       assertEquals("* Required", formFieldsPage.getRequiredText().getText());
       formFieldsPage.log.info("* Required  : est affiché correctement");
       

       // Fill Password field
       formFieldsPage.getPasswordInput().sendKeys("rihab");
       
   
       //check Drinks
      // Replace with the drink you want to test
       formFieldsPage.perform(formFieldsPage.getWaterCheckBox());
       
       //Check colors
       formFieldsPage.perform(formFieldsPage.getColor1());
       
     //verify dropDown
       formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("Yes");
       formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("No");
       formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("Undecided");
      
     
	  //verify selenium text
        assertEquals("Selenium", formFieldsPage.getSeleniumText().getText());
	    assertEquals("Playwright", formFieldsPage.getPlayWrightText().getText());
	    assertEquals("Cypress", formFieldsPage.getCypressText().getText());
	    assertEquals("Appium", formFieldsPage.getAppiumText().getText());
	    assertEquals("Katalon Studio", formFieldsPage.getKatalonText().getText());
	 
       //verify email
       formFieldsPage.getEmailField().sendKeys("rihabhammami633@gmail.com");
       
      //verify message
       formFieldsPage.getMessageField().sendKeys("hello");
      
       // Submit form
       formFieldsPage.perform(formFieldsPage.getSumbitButton());
       assertEquals("Message received!", closeAlertAndGetItsText());
      
     
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