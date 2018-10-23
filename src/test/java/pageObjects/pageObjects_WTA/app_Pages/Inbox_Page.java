package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import hooks.TestInitializeHook;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Inbox_Page extends WTAPageObject {
	
	

	Dialogs_Page Dialogs_Page = new Dialogs_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	InformationWorkItemPage InformationWorkItemPage = new InformationWorkItemPage();
	ApproveWorkItemPage ApproveWorkItemPage = new ApproveWorkItemPage();
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id[contains(., 'workitem_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@id, 'workitem_')]")
	public List<MobileElement> btn_workItemTitle;

	@AndroidFindBy(xpath = "//*[@text='Refresh']")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@id='Refresh']")
	public MobileElement btn_Refresh;

	@AndroidFindBy(xpath = "//*[@text='Search']")
	@iOSFindBy(id = "Search")
	public MobileElement btn_Search;

	@AndroidFindBy(xpath = "//*[@text='Search']")
	@iOSFindBy(id = "Search")
	public MobileElement txt_Search;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Priority with Flag']")
	@iOSFindBy(id = "Priority with Flag")
	public List<MobileElement> btn_WorkItem_Flag;

	@AndroidFindBy(xpath = "//*[@resource-id='wt_connectivitystatusbar']/android.view.View")
	@iOSFindBy(xpath = "//*[child::*[@text='Demo Mode']]")
	public MobileElement header_DemoMode;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ListView']//*[@text[contains(.,'workitem')]]/android.view.View/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@id, 'workitem_')]")
	public List<MobileElement> txt_WorkItemSyncTime;

	@AndroidFindBy(xpath = "//*[@resource-id='workitemlist_noitemsavailable']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_NoWorkItemsAvailable;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ListView']/android.widget.Button")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_LoadMore;
	
	
    public String Txt_NoWorkItemsAvailableXpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {

            case "Windows":
                return "//*[@resource-id='workitemlist_noitemsavailable']";

            case "IOS":
                return "//*[@resource-id='workitemlist_noitemsavailable']";

            case "Android":
                return "//*[@resource-id='workitemlist_noitemsavailable']";

            default:
                return "//*[@resource-id='workitemlist_noitemsavailable']";

        }

    }
    
    
    public String RefreshInboxUntilExpectedTitleElementAppears(String ExpectedText, int NumberOfTries)
    {
        String TextInElement = "";

        int i = 0;
        while (!TextInElement.equals(ExpectedText))
        {

            MobileElement btn_FirstWorkItemTitle = btn_workItemTitle.get(0);
        	
        	MobileAppiumFunctions.waituntilElementclickable(btn_FirstWorkItemTitle);
            TextInElement = btn_FirstWorkItemTitle.getText();
            
            if (i == NumberOfTries)
            {
                System.out.println("Expected Work Item Title Was not captured " + NumberOfTries + " Tries");
                break;
            }

            if (TextInElement.equals(ExpectedText))
            {
                System.out.println("Expected Work Item Title Found in Element, breaking out of loop");
                break;
            }

            else
            {
                btn_Refresh.click();

					sleep(500);

                if (GlobalSettings.MobilePlatformToRunTest.equals("Windows"))
                {
                    MobileAppiumFunctions.waituntilElementIsInvisible(Dialogs_Page.Dialog_UpdatingWorkItems_Xpath(), 20);
                }
                else
                {
                    Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
                }


					sleep(2000);

                i = i + 1;
            }
             

        }

        return TextInElement;

    }

    public void RefreshInboxUntilTheAllItemsCountIncreases(int OldCount, int NumberOfTries)
    {
        int NewCount = 0;

        int i = 0;
        while (NewCount == OldCount)
        {


            NewCount = btn_workItemTitle.size();

            if (i == NumberOfTries)
            {
                System.out.println("Work Item Count did not increase even after trying for " + NumberOfTries + " Tries");
                break;
            }

            if (NewCount > OldCount)
            {
                System.out.println("Work Item Count Increased, breaking out of loop");
                break;
            }

            else
            {

                btn_Refresh.click();

					sleep(500);

                Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();

					sleep(2000);

                i = i + 1;
            }


        }

    }


    public void RefreshInboxUntilFirstWorkItemTitleChanges(String LastWorkItemTitle, int NumberOfTries)
    {
        String NewWorkItemTitle = LastWorkItemTitle;

        int i = 0;
        while (LastWorkItemTitle.equals(NewWorkItemTitle))
        {
        	MobileElement btn_FirstWorkItemTitle = btn_workItemTitle.get(0);

            NewWorkItemTitle = btn_FirstWorkItemTitle.getText()  ;

            if (i == NumberOfTries)
            {
                //ExtentCustomInfoLogger("Work Item Title did not change even after trying for " + NumberOfTries + " Tries") ;
            	System.out.println("Work Item Title did not change even after trying for " + NumberOfTries + " Tries") ;
                break;
            }

            if (!LastWorkItemTitle.equals(NewWorkItemTitle))
            {
                //ExtentCustomInfoLogger("New Work Item found, breaking out of loop");
            	System.out.println("New Work Item found, breaking out of loop");
                break;
            }

            else
            {
                btn_Refresh.click();

					sleep(500);

                Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();

					sleep(2000);

                i = i + 1;
            }


        }

    }

    public void WorkOnLatestItemInDemoMode()
    {
    	MobileElement LatestWorkItem = btn_workItemTitle.get(0);
    	
    	LatestWorkItem.click();
        InformationWorkItemPage.btn_Remove.click();
        try {  MobileAppiumFunctions.waituntilElementIsInvisible(Dialogs_Page.Dialog_UpdatingWorkItems_Xpath(), 5); }
        catch (Exception e) { }
        
        LatestWorkItem.click();
        ApproveWorkItemPage.btn_Approve.click();
        sleep(1000);
        Dialogs_Page.btn_DialogOK.click();

        try { MobileAppiumFunctions.waituntilElementIsInvisible(Dialogs_Page.Dialog_UpdatingWorkItems_Xpath(), 5); }
        catch (Exception e) { }

        if(GlobalSettings.MobilePlatformToRunTest == "Windows")
        {
            sleep(4000);
        }
    }


    public void clickOnWorkItemContainingTitle(String WorkItemTitle)
    {

            for (int i = 0; i < btn_workItemTitle.size(); i++)
            {
                if (btn_workItemTitle.get(i).getText().equals(WorkItemTitle))
                {
                    btn_workItemTitle.get(i).click();
                    break;
                }
            }
    }


    public void FlagWorkItemContainingTitle(String WorkItemTitle)
    {

            for (int i = 0; i < btn_workItemTitle.size(); i++)
            {
                if (btn_workItemTitle.get(i).getText().equals(WorkItemTitle))
                {
                    btn_WorkItem_Flag.get(i).click();
                    break;
                }
            }

    }

    public void NavigateToWorkItemFilter(String Filter)
    {
        if (Filter.equals("Invoke Form"))
        {

            MenuNav_Page.btn_Inbox_Dropdown.click();
            MenuNav_Page.btn_InvokeForm.click();

            
        }
        if (Filter.equals("Approval"))
        {
        	MenuNav_Page.btn_Inbox_Dropdown.click();
        	MenuNav_Page.btn_Approval.click();

        	sleep(1000);
        }
        if (Filter.equals("Information"))
        {
        	MenuNav_Page.btn_Inbox_Dropdown.click();
            sleep(1000);
            MenuNav_Page.btn_Information.click();
            sleep(1000);
        }
        if (Filter.equals("Flagged"))
        {
        	MenuNav_Page.btn_Inbox_Dropdown.click();
            sleep(1000);
            MenuNav_Page.btn_Flagged.click();
            sleep(1000);
        }

        if (Filter.equals("All Items"))
        {
        	MenuNav_Page.btn_Inbox_Dropdown.click();
            sleep(1000);
            MenuNav_Page.btn_AllItems.click();
            sleep(1000);
        }
    }

    public boolean CheckIfFirstWorkItemPresent()
    {
        boolean FirstWorkItemExistsInBox = false;
        
        MobileElement btn_FirstWorkItemTitle = btn_workItemTitle.get(0);

        TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMin());
        try
        {

            if(btn_FirstWorkItemTitle.isDisplayed())
            { 
            FirstWorkItemExistsInBox = true;
            }
        }
        catch(Exception e)
        {
        	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        }

        TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        return FirstWorkItemExistsInBox;
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
    

}
