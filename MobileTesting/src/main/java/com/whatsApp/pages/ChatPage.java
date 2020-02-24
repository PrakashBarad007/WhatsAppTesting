package com.whatsApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChatPage {
	
	public ChatPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Type a message']")
	public WebElement chatInputField;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.ImageButton[@resource-id='com.whatsapp:id/send']")
	public WebElement sendButton;
	

}
