package com.example.practiceautomation.bdd;

import static org.junit.Assert.assertEquals;
import java.time.Duration;
import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.practiceautomation.po.ClickEventsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	  private WebDriver driver;
      private String baseUrl;
      private boolean acceptNextAlert = true;
      private StringBuffer verificationErrors = new StringBuffer();
      JavascriptExecutor js;
      ClickEventsPage clickEventsPage;
    
      
    //*********** with DDT : Data Driven Testing******//
      @Given("I am in page click events")
      public void i_am_in_page_click_events() {
              System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
              ChromeOptions options = new ChromeOptions();
              options.addArguments("start-maximized");
              options.addArguments("--remote-allow-origins=*");
              driver = new ChromeDriver(options);
              clickEventsPage = new ClickEventsPage(driver);
              driver.get("https://practice-automation.com/click-events/");
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
              js = (JavascriptExecutor) driver;
      }
      @When("I click for the {string}")
      public void i_click_for_the(String animal) {
           
            WebElement button = driver.findElement(By.xpath("//button[@onclick='" + animal + "Sound()']"));
            button.click();
        }
      
      @Then("I verify the {string} displayed")
      public void i_verify_the_displayed(String sound) {
    	  assertEquals(sound,clickEventsPage.getDemoText().getText());
      }
      
   
    //*********** without DDT ******//
     
       
      @When("I click for the cat")
      public void i_click_for_the_cat() {
          clickEventsPage.getCatButton().click();
      }
      @Then("I verify the Meow! displayed")
      public void i_verify_the_meow_displayed() {
          assertEquals("Meow!",clickEventsPage.getDemoText().getText());
      }
      @When("I click for the dog")
      public void i_click_for_the_dog() {
          clickEventsPage.getDogButton().click();
      }
      @Then("I verify the Woof! displayed")
      public void i_verify_the_woof_displayed() {
          assertEquals("Woof!",clickEventsPage.getDemoText().getText());
      }
      @When("I click for the pig")
      public void i_click_for_the_pig() {
          clickEventsPage.getPigButton().click();
      }
      @Then("I verify the Oink! displayed")
      public void i_verify_the_oink_displayed() {
          assertEquals("Oink!",clickEventsPage.getDemoText().getText());
      }
      @When("I click for the cow")
      public void i_click_for_the_cow() {
          clickEventsPage.getCowButton().click();
      }
      @Then("I verify the Moo! displayed")
      public void i_verify_the_moo_displayed() {
          assertEquals("Moo!",clickEventsPage.getDemoText().getText());
      }
      
      
      
    
}
