package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobileAppiumFunctions;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class SentItems_Page extends WTAPageObject {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();

	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	OverFlowIcon_Page OverFlowIcon_Page = new OverFlowIcon_Page();
	Dialogs_Page Dialogs_Page = new Dialogs_Page();
	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'form_')]]")
	@iOSFindBy(xpath = "//*[@text='Form With Inputs']")
	private List<MobileElement> btn_SentItemList;

	@AndroidFindBy(xpath = "(//android.widget.Button[contains(@text, 'form_')])[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement workItem_Latest;

	@AndroidFindBy(xpath = "//*[@resource-id='sentitemslist_noitemsavailable']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_NoItemsAvailable;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ListView']/android.view.View/android.view.View/android.view.View/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public List<MobileElement> txt_SentItemsSyncTime;

    public String Txt_NoItemsAvailable_Xpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {

            case "Windows":
                return "";
            case "IOS":
                return "";
            case "Android":
             return "//*[@resource-id='sentitemslist_noitemsavailable']";
            default:
                return null;

        }
    }
    
    
    public void ClearAllSentItems()
    {
        if (btn_SentItemList.size() > 0)
        {

            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(500);
            OverFlowIcon_Page.btn_OverFlowClearAll.click();
            sleep(500);
            Dialogs_Page.btn_DialogOK.click();
            sleep(500);
            MobileAppiumFunctions.waituntilElementExists(Txt_NoItemsAvailable_Xpath(), 20);
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
    
	public boolean checkIfAtleast1SentItemsExists()
	{
		boolean sentItemsExist=false;
        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_Drafts.click();
		if(!txt_NoItemsAvailable.isDisplayed())
		{
			sentItemsExist=true;
		}
		MobCommonFunctions.CloseApp();

		return sentItemsExist;
	}
	

}
