package com.whatsApp.common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.whatsApp.base.WhatsAppBase;

public class CommonKeywords extends WhatsAppBase{
		
	  
	  public static void customClick(WebElement locator) {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.click();
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
