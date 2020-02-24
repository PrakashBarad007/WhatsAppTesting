package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.whatsApp.base.WhatsAppBase;
import com.whatsApp.common.CommonKeywords;
import com.whatsApp.pages.StatusPage;

import com.whatsApp.utilities.CommonDataProvider;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class UploadStatus extends WhatsAppBase{
	
	
	public static StatusPage statusPage;
	
	@Test(dataProviderClass=CommonDataProvider.class,dataProvider="devicename")
	public void updateStatus(String device) throws IOException, InterruptedException{
		driver = setupAppium(device);
		statusPage = new StatusPage(driver);
		CommonKeywords.customClick(statusPage.statusTab);
		CommonKeywords.customClick(statusPage.addNewStatus);
		CommonKeywords.customClick(statusPage.clickNewImage);
		CommonKeywords.customClick(statusPage.addCaption);
		CommonKeywords.typeMessage(statusPage.editCaption, "My Status");
		CommonKeywords.customClick(statusPage.sendStatus);
	
	}
	

}
