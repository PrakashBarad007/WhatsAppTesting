package com.whatsApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StatusPage {
	
	public StatusPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[3]/android.widget.LinearLayout")
	public WebElement statusTab;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout")
	public WebElement addNewStatus;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.whatsapp:id/shutter']")
	public WebElement clickNewImage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add a caption…']")
	public WebElement addCaption;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Add a caption…']")
	public WebElement editCaption;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.whatsapp:id/send']")
	public WebElement sendStatus;

	


}
