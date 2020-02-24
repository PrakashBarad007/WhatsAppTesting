package Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.whatsApp.base.WhatsAppBase;
import com.whatsApp.common.CustomMethods;
import com.whatsApp.utilities.CommonDataProvider;


public class SendMessage extends WhatsAppBase{
	
	@Test(dataProviderClass=CommonDataProvider.class,dataProvider="devicename")
	public void openApplication(String device) throws IOException, InterruptedException {
		driver = setupAppium(device);
	}

	@Test(dataProviderClass=CommonDataProvider.class,dataProvider="singleContact")
    public void sendMessageToSingleContact(String Username) throws IOException, InterruptedException{
	
	CustomMethods.openContactList();
	CustomMethods.searchAndSelectContact(Username);
	CustomMethods.sendMessage(prop.get("messageToSingleContact").toString());
	}

}
