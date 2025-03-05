package com.example.practiceautomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickEventsPage extends PageObject {

	public ClickEventsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	  @FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
			private WebElement title;
	  
	  @FindBy(xpath = "//a[normalize-space()='Home']")
		private WebElement homeText;
	  
	  @FindBy(xpath = "//button[@onclick='catSound()']")
		private WebElement catButton;
	  
	  @FindBy(xpath = "//button[@onclick='pigSound()']")
		private WebElement pigButton;
	  
	  @FindBy(xpath = "//button[@onclick='dogSound()']")
		private WebElement dogButton;
	  
	  @FindBy(xpath = "//b[normalize-space()='Cow']")
		private WebElement cowButton;
	  
	
	  @FindBy(id = "demo")
		private WebElement demoText;

	public WebElement getDemoText() {
		return demoText;
	}

	public void setDemoText(WebElement demoText) {
		this.demoText = demoText;
	}

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

	public WebElement getCatButton() {
		return catButton;
	}

	public void setCatButton(WebElement catButton) {
		this.catButton = catButton;
	}

	public WebElement getPigButton() {
		return pigButton;
	}

	public void setPigButton(WebElement pigButton) {
		this.pigButton = pigButton;
	}

	public WebElement getDogButton() {
		return dogButton;
	}

	public void setDogButton(WebElement dogButton) {
		this.dogButton = dogButton;
	}

	public WebElement getCowButton() {
		return cowButton;
	}

	public void setCowButton(WebElement cowButton) {
		this.cowButton = cowButton;
	}
	  
	  
	  
	  

}
