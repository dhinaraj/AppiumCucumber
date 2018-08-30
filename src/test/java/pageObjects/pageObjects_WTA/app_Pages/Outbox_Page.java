package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobileAppiumFunctions;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Outbox_Page extends WTAPageObject {
	
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	OverFlowIcon_Page OverFlowIcon_Page = new OverFlowIcon_Page();
	Dialogs_Page Dialogs_Page = new Dialogs_Page();
	SentItems_Page SentItems_Page= new SentItems_Page();

	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'form_') or contains(.,'workitem_')]]")
	@iOSFindBy(xpath = "//*[@text='Form With Inputs']")
	public List<MobileElement> btn_OutboxItemList;

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'form_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[contains(@id, 'form')]")
	public List<MobileElement> btn_OutboxItemList_Forms;

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'workitem_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[contains(@id, 'Item')]")
	public List<MobileElement> btn_OutboxItemList_WorkItems;


	@AndroidFindBy(xpath = "//*[@resource-id='outboxlist_noitemsavailable']")
	@iOSFindBy(xpath = "//*[@id='No items available']")
	public MobileElement txt_NoItemsAvailable;

	@AndroidFindBy(xpath = "//*[@resource-id='outbox']/android.view.View[3]/android.view.View/android.view.View")
	@iOSFindBy(xpath = "")
	public MobileElement txt_FillForms_Header;

	@AndroidFindBy(xpath = "//*[@resource-id='outbox']/android.view.View[3]/android.view.View[2]/android.view.View")
	@iOSFindBy(xpath = "")
	public MobileElement txt_WorkItems_Header;
	
    public void OpenFirstFormFromOutbox()
    {
    	btn_OutboxItemList_Forms.get(0).click();
    	
    }
    
    public String Lbl_NoItemsAvailableTextXpath()
    {
    	String lbl_NoItemsAvailableTextXpath = "";
            
    	
    	switch (GlobalSettings.getMobilePlatformToRunTest())
            {
                case "Windows":
                    lbl_NoItemsAvailableTextXpath = "//*[@Name='No items available']";
                    break;
                case "IOS":
                    lbl_NoItemsAvailableTextXpath = "//*[@id='No items available']";
                    break;
                case "Android":
                    lbl_NoItemsAvailableTextXpath = "//*[@resource-id='outboxlist_noitemsavailable']";
                    break;
            }
            return lbl_NoItemsAvailableTextXpath;

    }
    
    public void ClearAllOutboxItems()
    {
        if (btn_OutboxItemList.size() > 0)
        {

            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(500);
            OverFlowIcon_Page.btn_OverFlowOptions.get(1).click();
            sleep(500);
            Dialogs_Page.btn_DialogOK.click();
            sleep(500);
            MobileAppiumFunctions.waituntilElementExists(SentItems_Page.Txt_NoItemsAvailable_Xpath(), 20);
        }
    }
    
    public void sleep(int milliSeconds)
    {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public String Btn_OutboxFirstItemXpath()
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return "//*[@AutomationId[contains(., 'workitem_') or contains(., 'form_') ]]";
            case "IOS":
                return "(//XCUIElementTypeOther[contains(@id, 'Item') or contains(@id, 'Form')]";
            case "Android":
                return "//*[@resource-id[contains(., 'workitem_') or contains(., 'form_')]]";
            default:
                return null;
        }
    }

}
