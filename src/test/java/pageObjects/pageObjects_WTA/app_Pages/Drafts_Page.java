package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import java.util.List;

import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import base.genericLib_Mob.*;

public class Drafts_Page extends WTAPageObject {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	Dialogs_Page Dialogs_Page = new Dialogs_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	
	@AndroidFindBy(xpath = "//*[@resource-id='draftslist_noitemsavailable']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_NoItemsAvailable;

	@AndroidFindBy(xpath = "//*[@text='Toggle ']")
	@iOSFindBy(xpath = "Dummy")
	public List<MobileElement> chkBox_OutboxListItems;

	@AndroidFindBy(xpath = "//*[@text='Delete']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_Delete;
	
	
	public boolean checkIfAtleast1DraftExists()
	{
		boolean draftsExist=false;
		
        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_Drafts.click();
		if(!txt_NoItemsAvailable.isDisplayed())
		{
			draftsExist=true;
		}
		MobCommonFunctions.CloseApp();
		return draftsExist;
	}
	

}
