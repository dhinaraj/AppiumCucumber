package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;

import org.openqa.selenium.StaleElementReferenceException;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;

public class MenuNav_Page extends WTAPageObject {
	

	
	@AndroidFindBy(xpath = "//*[@text='Menu']")
	@iOSFindBy(id = "Menu")
	public MobileElement btn_HamBurgerMenu;


	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Home')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(xpath = "NavigationMenu_Home")
	public MobileElement btn_Home;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Inbox')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_Inbox")
	public MobileElement btn_Inbox;

	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id[contains(.,'select_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
	public MobileElement btn_Inbox_Dropdown;

	@AndroidFindBy(xpath = "(//*[@resource-id[contains(.,'select_option_')]])[1]")
	//@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Work Tasks Pro\"]/XCUIElementTypeOther[6]")
	@iOSFindBy(id = "All Items")
	public MobileElement btn_AllItems;

	@AndroidFindBy(xpath = "(//*[@resource-id[contains(.,'select_option_')]])[2]")
	//@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Work Tasks Pro\"]/XCUIElementTypeOther[7]")
	@iOSFindBy(id = "Approval")
	public MobileElement btn_Approval;

	@AndroidFindBy(xpath = "(//*[@resource-id[contains(.,'select_option_')]])[3]")
	@iOSFindBy(id = "Invoke Form")
	public MobileElement btn_InvokeForm;

	@AndroidFindBy(xpath = "(//*[@resource-id[contains(.,'select_option_')]])[4]")
	@iOSFindBy(id = "Information")
	public MobileElement btn_Information;

	@AndroidFindBy(xpath = "(//*[@resource-id[contains(.,'select_option_')]])[5]")
	@iOSFindBy(id = "Flagged")
	public MobileElement btn_Flagged;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_FillForms')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_FillForms")
	public MobileElement btn_FillForm;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Drafts')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_Drafts")
	public MobileElement btn_Drafts;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_SentItems')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_SentItems")
	public MobileElement btn_SentItems;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Outbox')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_Outbox")
	public MobileElement btn_Outbox;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Sync')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_Sync")
	public MobileElement btn_Sync;

	@AndroidFindBy(xpath = "(//*[@text[contains(.,'NavigationMenu_Settings')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View'])[1]")
	@iOSFindBy(id = "NavigationMenu_Settings")
	public MobileElement btn_AccountSettings;

	@AndroidFindBy(xpath = "(//*[@text[contains(.,'NavigationMenu_Settings')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View'])[2]")
	@iOSFindBy(id = "NavigationMenu_Settings")
	public MobileElement btn_AppSettings;
	

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_Help')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_Help")
	public MobileElement btn_Help;

	@AndroidFindBy(xpath = "//*[@text[contains(.,'NavigationMenu_LogOff')]]//*[@class='android.view.View']//*[@class='android.view.View']//*[@class='android.view.View']")
	@iOSFindBy(id = "NavigationMenu_LogOff")
	public MobileElement btn_LogOff;

	@AndroidFindBy(xpath = "//*[@class='android.widget.Spinner']")
	@iOSFindBy(id = "Overflow Icons")
	public MobileElement btn_OverFlowIcon;

	@AndroidFindBy(xpath = "//android.view.View[@text='Updating work items']")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[text()='Updating work items']")
	public MobileElement popUp_UpdatingWorkItems;
	
	
	@AndroidFindBy(id = "imageView1")
	@iOSFindBy(id = "imageView1")
	public MobileElement Img_InitialAppLoadingImage;
	
	@AndroidFindBy(xpath = "//*[@text='Back']")
	@iOSFindBy(id = "Back")
	public MobileElement btn_Back;
	
	
	
	 public MobileElement Btn_HamburgerMenuItem(String menuName)
     {
         switch (GlobalSettings.getMobilePlatformToRunTest())
         {
             case "Windows":

                 if(menuName == "ManageAccount")
                 {
                     return MobProp.getMobDriver().findElementsByName("NavigationMenu_Settings").get(0);
                 }
                 else if (menuName == "Settings")
                 {
                     return MobProp.getMobDriver().findElementsByName("NavigationMenu_Settings").get(1);
                 }
                 else if (menuName == "Home")
                 {
                     return MobProp.getMobDriver().findElementByName("NavigationMenu_DashboardForm");
                 }

                 String name = menuName.replaceAll("\\s+","");
                 if (menuName == "FillForm")
                 {
                     name += "s";
                 }
                 return MobProp.getMobDriver().findElementByName("NavigationMenu_"+ name);
             case "Android":
                 if (menuName == "ManageAccount")
                 {
                     return MobProp.getMobDriver().findElementsByXPath("//android.view.View[@text[contains(., 'NavigationMenu_Settings')]]").get(0);
                 }
                 else if (menuName == "Settings")
                 {
                     return MobProp.getMobDriver().findElementsByXPath("//android.view.View[@text[contains(., 'NavigationMenu_Settings')]]").get(1);
                 }
                 else
                 {
                     return MobProp.getMobDriver().findElementByXPath("//android.view.View[@text[contains(., 'NavigationMenu_"+ menuName+"')]]");
                 }
             case "IOS":
                 return MobProp.getMobDriver().findElementByXPath("//XCUIElementTypeStaticText[text()='"+ menuName+"']/..");
             default:
                 return null;
         }
     }
	 
	 
     public MobileElement Btn_HamburgerDisabledMenuItem(String menuName)
     {
         switch (GlobalSettings.getMobilePlatformToRunTest())
         {
             case "Windows":
            	 String name = menuName.replaceAll("\\s+","");
                 if (menuName == "Fill Form")
                 {
                     name += "s";
                 }
                 return MobProp.getMobDriver().findElementByName("NavigationMenu_"+ name);
             case "Android":
                 return MobProp.getMobDriver().findElementByXPath("//android.view.View[@text='"+ menuName+"']");
             case "IOS":
                 return MobProp.getMobDriver().findElementByXPath("//XCUIElementTypeStaticText[text()='"+ menuName+"' and @enabled='false']/..");
             default:
                 return null;
         }
     }
     
     
     public String Btn_HamBurgerMenu_Xpath()
     {
         switch (GlobalSettings.getMobilePlatformToRunTest())
         {
             case "Windows":
                 return "//*[@Name='Menu']";
             case "IOS":
                 return "//XCUIElementTypeButton[text()='Menu']";
             case "Android":
                 return "//*/android.widget.Button[@text='Menu']";
         }
         return "";
     }
     
     
     public String PopUp_UpdatingWorkItemsXpath()
     {
         switch (GlobalSettings.getMobilePlatformToRunTest())
         {
             case "Windows":
                 return "//*[@Name='Updating work items']";
             case "Android":
                 return "//android.view.View[@text='Updating work items']";
                 //return "//*[@text='Loader']/android.view.View/android.view.View/android.view.View";
             case "IOS":
                 return "//XCUIElementTypeStaticText[text()='Updating work items']";
             default:
                 return null;
         }
     }
     
     
     public void clickOnHamBurgerMenu()
     {
         boolean clickedOnHamburgerMenuSuccesully = false;
         int i=1;
    	 while(!clickedOnHamburgerMenuSuccesully)
         {
        	try {
				btn_HamBurgerMenu.click();
				clickedOnHamburgerMenuSuccesully=true;
			} 
        	catch (Exception e) {
				System.out.println("Caught Stale Element Expection, Retrying to click on Hamburger Menu");
			} 
        	if(i==5)
        	{
        		System.out.println("Retried to click 5 times on Hamburger Menu, but failed, check the elements");
        		break;
        	}
        	i++;
         }
     }
     
     public void waitUnitlHamburgerMenuIsClickable()
     {
         boolean hamBurgerMenuIsClickable = false;
         int i=1;
    	 while(!hamBurgerMenuIsClickable)
         {
        	try {
        		MobileAppiumFunctions.waituntilElementIsVisible(btn_HamBurgerMenu, 15);
        		hamBurgerMenuIsClickable=true;
			} 
        	catch (Exception e) {
				System.out.println("Caught Stale Element Expection, Retrying to click on Hamburger Menu");
			} 
        	
        	if(i==5)
        	{
        		System.out.println("Retried to click 5 times on Hamburger Menu, but failed, check the elements");
        		break;
        	}
        	i++;
         }
     }
     
     
     public void navigateToMenuOption(String menuName)
     {
    	 btn_HamBurgerMenu.click();
    	 
    	 if(menuName.equals("Inbox"))
    	 {
    		 btn_Inbox.click();
    	 }
    	 if(menuName.equals("Fill Form"))
    	 {
    		 btn_FillForm.click();
    	 }
    	 if(menuName.equals("Drafts"))
    	 {
    		 btn_Drafts.click();
    	 }
    	 if(menuName.equals("Sent Items"))
    	 {
    		btn_SentItems.click();
    	 }
    	 if(menuName.equals("Outbox"))
    	 {
    		 btn_Outbox.click();
    	 }
    	 if(menuName.equals("Sync"))
    	 {
    		 btn_Sync.click();
    	 }
    	 if(menuName.equals("Manage Account"))
    	 {
    		 btn_AccountSettings.click();
    	 }
    	 if(menuName.equals("Settings"))
    	 {	btn_AppSettings.click();
    		 
    	 }
    	 if(menuName.equals("Help"))
    	 {
    		 btn_Help.click();
    	 }
    	 if(menuName.equals("Log Off"))
    	 {
    		 btn_LogOff.click();
    	 }
     }
     

     


}
