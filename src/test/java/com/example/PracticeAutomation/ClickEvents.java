package com.example.PracticeAutomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.example.practiceautomation.po.ClickEventsPage;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class ClickEvents {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  ClickEventsPage clickEventsPage;
  
  @Before
	public void setUp() throws Exception {
	  WebDriverManager.firefoxdriver().setup();
		
	    FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("--headless");
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		driver = new FirefoxDriver(options);
	  brokenLinksPage=new BrokenLinkPage(driver);
	  baseUrl = "https://practice-automation.com/";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;}
/*  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  clickEventsPage=new ClickEventsPage(driver);
	  baseUrl = "https://practice-automation.com/";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;
	  }*/

   /* System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;*/
  
  //@Test
  public void testClickEvents() throws Exception {
    driver.get("https://practice-automation.com/click-events/");
    //driver.findElement(By.linkText("Click Events")).click();
   
    try {
    	 WebElement element=driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
    	 assertEquals("Click Events",element.getText());
    	 
    	element=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        assertEquals("Home", driver.findElement(By.linkText("Home")).getText());
   
    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[3]/div/div/div/div/button/b")).click();
    element=driver.findElement(By.id("demo"));
    assertEquals("Meow!", element.getText());
   
    
    driver.findElement(By.xpath("//button[@onclick='pigSound()']")).click();
    element=driver.findElement(By.id("demo"));
    assertEquals("Oink!", element.getText());
   
    
    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[3]/div/div/div/div[2]/button/b")).click();
    element=driver.findElement(By.id("demo"));
    assertEquals("Woof!", element.getText());
  
   // driver.findElement(By.id("main")).click();
    
    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[5]/div[2]/button/b")).click();
    element=driver.findElement(By.id("demo"));
    assertEquals("Moo!",element.getText());
    
    
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  
  @Test
  public void testClickEventsPage() throws Exception {
	  driver.get("https://practice-automation.com/click-events/");
	  
	  assertEquals("Click Events",clickEventsPage.getTitle().getText());
	  
	  assertEquals("Home",clickEventsPage.getHomeText().getText());
	  
	  clickEventsPage.getCatButton().click();
	  assertEquals("Meow!",clickEventsPage.getDemoText().getText());
	  
	  clickEventsPage.getPigButton().click();
	  assertEquals("Oink!",clickEventsPage.getDemoText().getText());
	  
	  clickEventsPage.getDogButton().click();
	  assertEquals("Woof!",clickEventsPage.getDemoText().getText());
	  
	  clickEventsPage.getCowButton().click();
	  assertEquals("Moo!",clickEventsPage.getDemoText().getText());
	  clickEventsPage.takeScreenShot("ClickEvents");
	  clickEventsPage.takeScreenShot("title",clickEventsPage.getTitle());
	  clickEventsPage.takeScreenShot("homeText",clickEventsPage.getHomeText());

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
