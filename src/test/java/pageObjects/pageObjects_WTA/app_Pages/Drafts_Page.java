package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Drafts_Page extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//*[@resource-id='draftslist_noitemsavailable']")
	@iOSFindBy(xpath = "")
	public MobileElement txt_NoItemsAvailable;

	@AndroidFindBy(xpath = "//*[@text='Toggle ']")
	@iOSFindBy(xpath = "")
	public List<MobileElement> chkBox_OutboxListItems;

	@AndroidFindBy(xpath = "//*[@text='Delete']")
	@iOSFindBy(xpath = "")
	public MobileElement btn_Delete;
	

}
