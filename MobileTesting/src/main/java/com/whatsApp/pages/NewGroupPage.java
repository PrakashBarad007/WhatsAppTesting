package com.whatsApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewGroupPage {
	
	public NewGroupPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New group']")
	public WebElement newGroupPageTitle;
	
		
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']")
	public WebElement searchedContact;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.whatsapp:id/next_btn']")
	public WebElement nextButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.whatsapp:id/search_back']")
	public WebElement backButton;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Type group subject here…']")
	public WebElement typeGroupNameInputField;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.whatsapp:id/ok_btn']")
	public WebElement okButton;
	
}
