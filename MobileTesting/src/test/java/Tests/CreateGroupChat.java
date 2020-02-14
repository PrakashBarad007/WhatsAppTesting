package Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.whatsApp.base.WhatsAppBase;
import com.whatsApp.common.CommonKeywords;
import com.whatsApp.common.CustomMethods;
import com.whatsApp.pages.ContactPage;
import com.whatsApp.pages.NewGroupPage;
import com.whatsApp.utilities.CommonDataProvider;

public class CreateGroupChat extends WhatsAppBase{
	
	public ContactPage contactPageObject;
	public NewGroupPage newGroupPageObject;
	
	@Test(dataProviderClass=CommonDataProvider.class,dataProvider="devicename")
    public void first_openNewGroupPage(String device) throws IOException, InterruptedException{
		
	driver = setupAppium(device);
	contactPageObject = new ContactPage(driver);
	Thread.sleep(10000);
	CustomMethods.openContactList();
	CustomMethods.selectNewGroupOption();
	
	CommonKeywords.customClick(contactPageObject.searchIcon);
	}
	

	int count = 0;
	@Test(dataProviderClass=CommonDataProvider.class,dataProvider="multipleContact")
	public void second_createGroupAndSendMessage(String username) throws InterruptedException, IOException {
		CustomMethods.searchAndSelectGroupMember(username);
		count++;
		System.out.println(count);
		if(count>=2) {
			CustomMethods.groupCreationAndSendMessage();
		}
		
	}
	
	
}