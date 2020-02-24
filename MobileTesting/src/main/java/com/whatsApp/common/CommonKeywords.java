package com.whatsApp.common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.whatsApp.base.WhatsAppBase;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class CommonKeywords extends WhatsAppBase{
		
	  
	  public static void customClick(WebElement locator) throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.click();
			Thread.sleep(3000);
		}

	  
		public static void customClear(WebElement locator) {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(locator));
            locator.clear();
		}
		
		 
		public static void typeMessage(WebElement locator,String msg) {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.sendKeys(msg);
			
		}
		
		
}
