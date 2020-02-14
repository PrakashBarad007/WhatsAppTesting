package com.whatsApp.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.whatsApp.base.WhatsAppBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactPage extends WhatsAppBase{

	
	public ContactPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='WhatsApp']")
	public WebElement selectContactTitle;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.whatsapp:id/menuitem_search']")
	public WebElement searchIcon;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search…']")
	public WebElement searchInputField;
	
//	public static void searchedContact(String value){
//		System.out.println(value);
//		driver.findElementByAndroidUIAutomator("text(\"value\")").click();
//	}
	
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[1]")
	public WebElement searchedContact;
	
	@AndroidFindBy(xpath="//android.widget.ListView/android.widget.RelativeLayout[1]")
	public WebElement firstContact;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New group']")
	public WebElement newGroup;
	

}
