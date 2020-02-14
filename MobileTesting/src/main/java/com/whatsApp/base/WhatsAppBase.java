package com.whatsApp.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.whatsApp.utilities.ExtentReportManage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WhatsAppBase {
	
	  public static URL url;
	  public static DesiredCapabilities capabilities;
	  public static AndroidDriver<AndroidElement> driver;
	  public static FileInputStream finput;
	  public static Properties prop;
	  public ExtentReports rep = ExtentReportManage.getInstance();
	  public static ExtentTest test;
	  public AndroidDriver<AndroidElement> setupAppium(String device) throws IOException, InterruptedException {
		 
		  finput=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SourceFile\\GlobalTestData.properties");
		  prop=new Properties();
		  prop.load(finput);

		  DesiredCapabilities dc=new DesiredCapabilities();
		  dc.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		  dc.setCapability(MobileCapabilityType.NO_RESET, true);
		  dc.setCapability(MobileCapabilityType.FULL_RESET, false);
		  dc.setCapability("appPackage", "com.whatsapp");
		  dc.setCapability("appActivity", "com.whatsapp.Main");
		  //dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"\\src\\test\\resources\\APK\\whatsapp-messenger-22027-armeabi-v7a-downzen.com.apk");
		  dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.get("AUTOMATION_NAME").toString());
		  driver=new AndroidDriver<AndroidElement>(new URL(prop.get("URL").toString()),dc);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return driver;
		}

		public static void getScreenshot(String s) throws IOException
		{
		File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
		
		}
		
	  @AfterSuite
	  public void TearDown() {
		  driver.quit();
	  }
	  

	  
}
