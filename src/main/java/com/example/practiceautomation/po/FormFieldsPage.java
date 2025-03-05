package com.example.practiceautomation.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormFieldsPage extends PageObject {

	public FormFieldsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
	private WebElement title;
	
	@FindBy(id = "name-input")
	private WebElement nameInput;
	
	@FindBy(xpath = "//form[@id='feedbackForm']/p")
	private WebElement requiredText;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id='drink1']")
	private WebElement waterCheckBox;
	
	@FindBy(xpath = "//label[@for='color1']")
	private WebElement color1;
	

	@FindBy(xpath = "//input[contains(@id, 'color')]")
	 private WebElement colors;
	
	@FindBy(id = "automation")
	private WebElement dropDown;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/main/div/article/div/form/ul/li[1]")
	private WebElement seleniumText;
	
	@FindBy(xpath = "//li[normalize-space()='Playwright']")
	private WebElement playWrightText;
	
	
	@FindBy(xpath = "//li[normalize-space()='Cypress']")
	private WebElement cypressText;
	
	@FindBy(xpath = "//li[normalize-space()='Appium']")
	private WebElement appiumText;
	
	@FindBy(xpath = "//li[normalize-space()='Katalon Studio']")
	private WebElement katalonText;
	
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "message")
	private WebElement messageField;
	
	@FindBy(id = "submit-btn")
	private WebElement sumbitButton;
	
	
	
	public void clickFavoritDrink(int index)
	{
		driver.findElement(By.xpath("//input[@id='drink"+index+"']")).click();
	}

	public void clickAllFavoritDrink()
	{
		for (int i = 0; i < 4; i++) {
			clickFavoritDrink(i+1);
		}
	}
	
	public WebElement getSumbitButton() {
		return sumbitButton;
	}
	public void setSumbitButton(WebElement sumbitButton) {
		this.sumbitButton = sumbitButton;
	}
	public WebElement getSeleniumText() {
		return seleniumText;
	}
	public void setSeleniumText(WebElement seleniumText) {
		this.seleniumText = seleniumText;
	}
	public WebElement getEmailField() {
		return emailField;
	}
	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}
	public WebElement getMessageField() {
		return messageField;
	}
	public void setMessageField(WebElement messageField) {
		this.messageField = messageField;
	}
	public WebElement getDropDown() {
		return dropDown;
	}
	public void setDropDown(WebElement dropDown) {
		this.dropDown = dropDown;
	}
	
	
	public WebElement getColors() {
		return colors;
	}
	public void setColors(WebElement colors) {
		this.colors = colors;
	}
	public WebElement getTitle() {
		return title;
	}
	public void setTitle(WebElement title) {
		this.title = title;
	}
	
	public WebElement getNameInput() {
		return nameInput;
	}
	public void setNameInput(WebElement nameInput) {
		this.nameInput = nameInput;
	}
	public WebElement getRequiredText() {
		return requiredText;
	}
	public void setRequiredText(WebElement requiredText) {
		this.requiredText = requiredText;
	}
	public WebElement getPasswordInput() {
		return passwordInput;
	}
	public void setPasswordInput(WebElement passwordInput) {
		this.passwordInput = passwordInput;
	}
	
	public WebElement getColor1() {
		return color1;
	}
	public void setColor1(WebElement color1) {
		this.color1 = color1;
	}
	public WebElement getWaterCheckBox() {
		return waterCheckBox;
	}
	public void setWaterCheckBox(WebElement waterCheckBox) {
		this.waterCheckBox = waterCheckBox;
	}
	public WebElement getPlayWrightText() {
		return playWrightText;
	}
	public void setPlayWrightText(WebElement playWrightText) {
		this.playWrightText = playWrightText;
	}
	public WebElement getCypressText() {
		return cypressText;
	}
	public void setCypressText(WebElement cypressText) {
		this.cypressText = cypressText;
	}
	public WebElement getAppiumText() {
		return appiumText;
	}
	public void setAppiumText(WebElement appiumText) {
		this.appiumText = appiumText;
	}
	public WebElement getKatalonText() {
		return katalonText;
	}
	public void setKatalonText(WebElement katalonText) {
		this.katalonText = katalonText;
	}

	 
	 
	 
	
}
