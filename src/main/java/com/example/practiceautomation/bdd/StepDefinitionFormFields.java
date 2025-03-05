package com.example.practiceautomation.bdd;

import io.cucumber.java.en.Given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.practiceautomation.po.FormFieldsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionFormFields {

	
	   private WebDriver driver;
	      private String baseUrl;
	      private boolean acceptNextAlert = true;
	      private StringBuffer verificationErrors = new StringBuffer();
	      JavascriptExecutor js;
	      FormFieldsPage formFields;
	      
	      @Given("the user is on the form fields page")
	      public void the_user_is_on_the_form_fields_page() {
	          System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	          ChromeOptions options = new ChromeOptions();
	          options.addArguments("start-maximized");
	          options.addArguments("--remote-allow-origins=*");
	          driver = new ChromeDriver(options);
	          formFields = new FormFieldsPage(driver);
	          driver.get("https://practice-automation.com/form-fields/");
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	          js = (JavascriptExecutor) driver;
	      }
	      @When("the user verifies the page title {string}")
	      public void the_user_verifies_the_page_title(String expectedTitle) {
	          WebElement pageTitle = formFields.getTitle();
	          assertEquals(expectedTitle, pageTitle.getText());
	      }
	      @When("the user fills the name field with {string}")
	      public void the_user_fills_the_name_field_with(String name) {
	          WebElement nameInput = formFields.getNameInput();
	          nameInput.click();
	          nameInput.sendKeys(name);
	      }
	      @When("the user verifies the required field message {string}")
	      public void the_user_verifies_the_required_field_message(String expectedMessage) {
	          WebElement requiredMsg = formFields.getRequiredText();
	          assertTrue(requiredMsg.getText().contains(expectedMessage));
	      }
	      @When("the user fills the password field with {string}")
	      public void the_user_fills_the_password_field_with(String password) {
	          WebElement passwordInput = formFields.getPasswordInput();
	          passwordInput.click();
	          passwordInput.sendKeys(password);
	      }
	      @When("the user selects the following drinks:")
	      public void the_user_selects_the_following_drinks(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	          List<String> drinks = dataTable.asList();
	          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          for (String drinkId : drinks) {
	              WebElement drink = wait.until(ExpectedConditions.elementToBeClickable(By.id(drinkId)));
	              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", drink);
	              Thread.sleep(500);
	              drink.click();
	              assertTrue(drink.isSelected());
	          }
	      }
	      @When("the user selects the following colors:")
	      public void the_user_selects_the_following_colors(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	          List<String> colors = dataTable.asList();
	          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          for (String colorId : colors) {
	              WebElement color = wait.until(ExpectedConditions.elementToBeClickable(By.id(colorId)));
	              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", color);
	              Thread.sleep(500);
	              color.click();
	              assertTrue(color.isSelected());
	          }
	      }
	      @When("the user selects {string} from the dropdown")
	      public void the_user_selects_from_the_dropdown(String option) throws InterruptedException {
	          WebElement dropDown = driver.findElement(By.id("automation"));
	          Select automationDropdown = new Select(dropDown);
	          
	          automationDropdown.selectByVisibleText(option);
	          assertEquals(option, automationDropdown.getFirstSelectedOption().getText());
	          
	          dropDown.click();
	          Thread.sleep(500);
	      }
	      @When("the user verifies the selectable list options:")
	      public void the_user_verifies_the_selectable_list_options(io.cucumber.datatable.DataTable dataTable) {
	          List<String> expectedOptions = dataTable.asList();
	          List<WebElement> elements = driver.findElements(By.xpath("//form[@id='feedbackForm']/ul/li"));
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          for (int i = 0; i < expectedOptions.size(); i++) {
	              js.executeScript("arguments[0].scrollIntoView(true);", elements.get(i));
	              assertEquals(expectedOptions.get(i), elements.get(i).getText());
	          }
	      }
	      @When("the user fills the email field with {string}")
	      public void the_user_fills_the_email_field_with(String email) {
	          WebElement emailField = driver.findElement(By.id("email"));
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          // Scroll into view and wait briefly
	          js.executeScript("arguments[0].scrollIntoView({block: 'center'});", emailField);
	          try {
	              Thread.sleep(500); // Small wait to ensure visibility
	          } catch (InterruptedException e) {
	              e.printStackTrace();
	          }
	          // Use JavaScript to click if intercepted
	          js.executeScript("arguments[0].click();", emailField);
	          
	          emailField.clear();
	          emailField.sendKeys(email);
	      }
	      @When("the user fills the message field with {string}")
	      public void the_user_fills_the_message_field_with(String message) {
	          WebElement messageField = formFields.getMessageField();
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          
	          // Scroll into view
	          js.executeScript("arguments[0].scrollIntoView({block: 'center'});", messageField);
	          
	          messageField.click();
	          messageField.clear();
	          messageField.sendKeys(message);
	      }
	      @When("the user submits the form")
	      public void the_user_submits_the_form() {
	        // formFields.getSubmitButton().click();
	      }
	      @Then("the user should see the confirmation message {string}")
	      public void the_user_should_see_the_confirmation_message(String expectedMessage) {
	          Alert alert = driver.switchTo().alert();
	          assertEquals(expectedMessage, alert.getText());
	          alert.accept();
	      }
}
