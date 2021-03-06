package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import hooks.TestInitializeHook;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;

public class Dialogs_Page extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//*[@text='Menu']")
	@iOSFindBy(accessibility = "Menu")
	public MobileElement btn_HamBurgerMenu;
	
	@AndroidFindBy(xpath = "//*[@class='android.app.Dialog']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement box_Dialog_Loader;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ProgressBar']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement box_Dialog_ProgressBar;

	@AndroidFindBy(xpath = "//*[@class='android.app.Dialog']/android.view.View[2]/android.widget.Button[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_DialogOK;

	@AndroidFindBy(xpath = "//*[@class='android.app.Dialog']/android.view.View[2]/android.widget.Button[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_Cancel;

	@AndroidFindBy(xpath = "//*[@class='android.app.Dialog']/android.view.View/android.view.View[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement text_DialogError;

	@AndroidFindBy(xpath = "//*[@class='android.app.Dialog']/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"document\"]/XCUIElementTypeOther[1]")
	public MobileElement text_DialogTitle;

	@AndroidFindBy(accessibility = "Network connection is currently unavailable. Form will be submitted when the network connection is active. ")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_FormWillBeSubmittedWhenAppIsOnline;

	@AndroidFindBy(xpath = "//*/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_ConfirmationMessgageInFooter;

	@AndroidFindBy(xpath = "//*[@resource-id='wt_connectivitystatusbar']/android.view.View")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(., 'Network connection not available')]/..")
	public MobileElement txt_NetworkConnectionNotAvailable;
	

	public String txt_ConfirmationMessgageInFooter_Xpath()
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return "";
            case "IOS":
                return "";
            case "Android":
            	return "//*/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View";
        }
        return "";
    }
	
	
	
	public String Dialog_UpdatingWorkItems_Xpath()
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return "//*[@Name='Updating work items']";
            case "IOS":
                return "//XCUIElementTypeStaticText[text()='Updating work items']";
            case "Android":
                return "//*[@text='Loader']/android.view.View/android.view.View/android.view.View";
        }
        return "";
    }
	
	
	public String Btn_DialogOK_Xpath()
    {

        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                return "";
            case "IOS":
                return "";
            case "Android":
                return "//*[@class='android.app.Dialog']/android.view.View[2]/android.widget.Button[2]";
            default:
                return "";
        }

    }
    
    
    public String Dialog_ProgressBar_Xpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                return "//*[@Name='Updating work items']";
            case "IOS":
                return "";
            case "Android":
                return "//*[@class='android.widget.ProgressBar']";
        }
        return "";
    }
    
    public String Dialog_UpdatingWorkItemsFlag_Xpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                return "//*[@Name='Updating work item flag']";
            case "IOS":
                return "//XCUIElementTypeStaticText[text()='Updating work item flag']";
            case "Android":
                return "//*[@text='Updating work item flag']";
        }
        return "";
    }
    
    
    public String Lbl_NetworkConnectionNotAvailableXpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {

            case "Windows":
                return "//*[@Name='Network connection not available']";
            case "IOS":
                return "//XCUIElementTypeStaticText[contains(., 'Network connection not available')]/..";
            case "Android":
                return "//*[@resource-id='wt_connectivitystatusbar']/android.view.View";

        }
        return "";
    }
    
    
    public String backButtonXPathWhenFooterMessageIsDisplayed()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {

            case "Windows":
                return "";
            case "IOS":
                return "";
            case "Android":
                return "//*/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button[@text='Back']";

        }
        return "";
    }
    
    
    public void WaitUnitlUpdateWorkItemDialogDisappears()
    {
    	/*        String text = "";
        if (!GlobalSettings.MobilePlatformToRunTest.equals("IOS"))
        {
            try
            {
                if (GlobalSettings.MobilePlatformToRunTest.equals("Windows"))
                {
                	MobileAppiumFunctions.waituntilElementIsVisible(Dialogs_Page.box_Dialog_ProgressBar, 5);
                	MobileAppiumFunctions.waituntilElementIsInvisible(Dialogs_Page.Dialog_UpdatingWorkItemsFlag_Xpath(), 10);
                }
                else
                {

                    MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.Btn_HamBurgerMenu_Xpath(), 10);
                    //Thread.Sleep(3000);
                    //MobCommonFunctions.waitUntilElementIsNoLongerInDom(Dialogs_Page.Box_Dialog_Loader, 20);
                }
            }
            catch (Exception e)
            {
            		e.printStackTrace();

            }
        }

        String text2 = text;*/
    	
    	MobileAppiumFunctions.waituntilElementIsVisible(box_Dialog_ProgressBar, 20);
    	//MobileAppiumFunctions.waituntilElementIsInvisible(Dialog_ProgressBar_Xpath(), 10);
    	//MobileAppiumFunctions.waituntilElementIsVisible(btn_HamBurgerMenu, 15);

    }


    public void WaitUnitlUpdateWorkItemFlagDialogDisappears()
    {

    	/*  if (!GlobalSettings.MobilePlatformToRunTest.equals("IOS"))
        {
            try
            {
                if (GlobalSettings.MobilePlatformToRunTest.equals("Windows"))
                {
                	MobileAppiumFunctions.waituntilElementIsVisible(Dialogs_Page.box_Dialog_ProgressBar, 5);
                	MobileAppiumFunctions.waituntilElementIsInvisible(Dialogs_Page.Dialog_UpdatingWorkItemsFlag_Xpath(), 10);
                }
                else
                {
                    //MobCommonFunctions.waitUntilElementIsVisible(Dialogs_Page.Dialog_UpdatingWorkItemsFlag_Xpath(), 10);
                	MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.Btn_HamBurgerMenu_Xpath(), 10);
                }
            }
            catch (Exception e)
            {

            	e.printStackTrace();
            }
        }*/
    	
    	//MobileAppiumFunctions.waituntilElementIsVisible(box_Dialog_ProgressBar, 5);
    	//MobileAppiumFunctions.waituntilElementIsInvisible(Dialog_UpdatingWorkItemsFlag_Xpath(), 10);
    	MobileAppiumFunctions.waituntilElementIsVisible(btn_HamBurgerMenu, 15);

    }
    
    public void WaitUnitlNetworkConnectionNotAvailableMessageAppears()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                String Text = txt_NetworkConnectionNotAvailable.getText();
                System.out.println("Found text " + Text);
                break;
            default:
           	 MobileAppiumFunctions.waituntilElementIsVisible(txt_NetworkConnectionNotAvailable, 30);
                break;
        }
    }
    
    
    public void WaitUnitlBottomFooterMessageDisappears() throws InterruptedException
    {
    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 2);

    	boolean bottomFooterElementVisible = true;
    	while(bottomFooterElementVisible) {
    		try {
				MobileElement element = MobProp.getMobDriver().findElement(By.xpath(backButtonXPathWhenFooterMessageIsDisplayed()));
				Thread.sleep(5000);
    		} catch (Exception e) {
				bottomFooterElementVisible=false;
				System.out.println("Footer Message Disappeared");
			}
    	}
    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
    }
    
    public void WaitUnitlNetworkConnectionNotAvailableMessageDisAppears()
    {
    	
    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 2);

    	boolean netWorkNotAvailableMessageIsVisible= true;
    	while(netWorkNotAvailableMessageIsVisible) {
    		try {
				MobileElement element = MobProp.getMobDriver().findElement(By.xpath(Lbl_NetworkConnectionNotAvailableXpath()));
				Thread.sleep(500);
    		} catch (Exception e) {
    			netWorkNotAvailableMessageIsVisible=false;
				System.out.println("Network Not Available Message Disappeared");
			}
    	}
    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());

   	 //MobileAppiumFunctions.waituntilElementIsNoLongerInDom(txt_NetworkConnectionNotAvailable, 60);
    }


}
