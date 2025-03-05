package com.example.PracticeAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.practiceautomation.po.PageObject;

public class BrokenLinkPage extends PageObject {

	public BrokenLinkPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	   @FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
		private WebElement title;
		
		@FindBy(xpath = "//a[normalize-space()='Home']")
		private WebElement homeText;
	
		@FindBy(xpath = "//article[@id='post-1267']/div/p[2]")
		private WebElement idealScenarioText;
		
		@FindBy(xpath  = "//article[@id='post-1267']/div/p[3]")
		private WebElement responseCode;
		
		@FindBy(xpath  = "//article[@id='post-1267']/div/figure/table/tbody/tr/td[2]")
		private WebElement statusCode;
		
		@FindBy(xpath  = "//article[@id='post-1267']/div/figure/table/tbody/tr/td[1]")
		private WebElement missingPage;

		
		public WebElement getTitle() {
			return title;
		}

		public void setTitle(WebElement title) {
			this.title = title;
		}

		public WebElement getHomeText() {
			return homeText;
		}

		public void setHomeText(WebElement homeText) {
			this.homeText = homeText;
		}

		public WebElement getIdealScenarioText() {
			return idealScenarioText;
		}

		public void setIdealScenarioText(WebElement idealScenarioText) {
			this.idealScenarioText = idealScenarioText;
		}

		public WebElement getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(WebElement responseCode) {
			this.responseCode = responseCode;
		}

		public WebElement getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(WebElement statusCode) {
			this.statusCode = statusCode;
		}

		public WebElement getMissingPage() {
			return missingPage;
		}

		public void setMissingPage(WebElement missingPage) {
			this.missingPage = missingPage;
		}
		
		
	
		
}
