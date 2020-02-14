package com.whatsApp.common;
import com.whatsApp.pages.ChatPage;
import com.whatsApp.pages.ContactPage;
import com.whatsApp.pages.HomePage;
import com.whatsApp.pages.NewGroupPage;
import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.interactions.Actions;
import com.whatsApp.base.WhatsAppBase;
import com.whatsApp.common.CommonKeywords;

public class CustomMethods extends WhatsAppBase{
	
	public static HomePage homePageObject;
	public static ContactPage contactPageObject;
	public static ChatPage chatPageObject;
	public static NewGroupPage newGroupPageObject;
	public static Actions action;
	
	public static void openContactList(){
		homePageObject = new HomePage(driver);
		CommonKeywords.customClick(homePageObject.selectContactButton);
	}
	
	public static void searchAndSelectContact(String username){
		contactPageObject = new ContactPage(driver);
		CommonKeywords.customClick(contactPageObject.searchIcon);
		CommonKeywords.customClick(contactPageObject.searchInputField);
		CommonKeywords.typeMessage(contactPageObject.searchInputField,username);
		CommonKeywords.customClick(contactPageObject.searchedContact);
		
	}

	public static void sendMessage(String msg) {
		chatPageObject = new ChatPage(driver);
		CommonKeywords.customClear(chatPageObject.chatInputField);
		CommonKeywords.customClick(chatPageObject.chatInputField);
		CommonKeywords.typeMessage(chatPageObject.chatInputField,msg);
		CommonKeywords.customClick(chatPageObject.sendButton);
	}
	
	
	public static void selectNewGroupOption() {
		contactPageObject = new ContactPage(driver);
		CommonKeywords.customClick(contactPageObject.newGroup);
	}
	

	public static void searchAndSelectGroupMember(String username){
		newGroupPageObject = new NewGroupPage(driver);
		contactPageObject = new ContactPage(driver);
		
		CommonKeywords.customClick(contactPageObject.searchInputField);
		CommonKeywords.typeMessage(contactPageObject.searchInputField,username);
		CommonKeywords.customClick(newGroupPageObject.searchedContact);
	}
	
	public static void groupCreationAndSendMessage() throws InterruptedException, IOException {
		
		Random rand = new Random();
		int rand1 =rand.nextInt(100);
		String groupName = "Testing" + rand1 ;
		action = new Actions(driver);
		action.moveToElement(newGroupPageObject.nextButton).click().build().perform();
		CommonKeywords.customClick(newGroupPageObject.typeGroupNameInputField);
		CommonKeywords.typeMessage(newGroupPageObject.typeGroupNameInputField,groupName);
		CommonKeywords.customClick(newGroupPageObject.okButton);
		CustomMethods.sendMessage(prop.get("groupMessage").toString());

		
	}
	
	
}
