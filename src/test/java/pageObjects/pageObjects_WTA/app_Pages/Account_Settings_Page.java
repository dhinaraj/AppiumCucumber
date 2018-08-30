package pageObjects.pageObjects_WTA.app_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import hooks.TestInitializeHook;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.pageObjects_WTA.WTAPageObject;
import pageObjects.pageObjects_WTA.localization_Pages.Loc_Account_Settings_Page;

public class Account_Settings_Page extends WTAPageObject  {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	TestInitializeHook mainHook = new TestInitializeHook();
	
    Loc_Account_Settings_Page Loc_Account_Settings_Page = new Loc_Account_Settings_Page();
    About_Page About_Page = new About_Page();
    ApproveWorkItemPage ApproveWorkItemPage = new ApproveWorkItemPage();
    AppSettings_Page AppSettings_Page = new AppSettings_Page();
    Dashboard_Page Dashboard_Page = new Dashboard_Page();
    DemoFillForm_Page DemoFillForm_Page = new DemoFillForm_Page();
    Dialogs_Page Dialogs_Page = new Dialogs_Page();
    Drafts_Page Drafts_Page = new Drafts_Page();
    Eula_Page Eula_Page = new Eula_Page();
    FillForm_Page FillForm_Page = new FillForm_Page();
    Inbox_Page Inbox_Page = new Inbox_Page();
    InformationWorkItemPage InformationWorkItemPage = new InformationWorkItemPage();
    InitialLoadingPage InitialLoadingPage = new InitialLoadingPage();
    LogOff_In_Page LogOff_In_Page = new LogOff_In_Page();
    MenuNav_Page MenuNav_Page = new MenuNav_Page();
    Outbox_Page Outbox_Page = new Outbox_Page();
    OverFlowIcon_Page OverFlowIcon_Page = new OverFlowIcon_Page();
    SentItems_Page SentItems_Page = new SentItems_Page();

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[1]")
	public MobileElement txt_ServerPath;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration_repository']")
	@iOSFindBy(xpath = "")
    public MobileElement dropdown_Repository;
	
	//@AndroidFindBy(xpath = "")
	//@iOSFindBy(xpath = "")
    //public MobileElement item_RepositoryName;
	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
	public List<MobileElement> txt_Username;

	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
	public List<MobileElement> txt_Password;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
    public MobileElement chk_ShowPassword;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[3]//*[@class='android.widget.Button']")
	@iOSFindBy(xpath = "")
    public MobileElement btn_LogOn;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
    public MobileElement btn_DemoMode;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_ServerPath;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement dropdown_Selected_Repository;
	
	@AndroidFindBy(xpath = "/*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_Username;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_Password;

	@AndroidFindBy(xpath = "//*[@text='Alert Dialog']/android.view.View[2]/android.widget.Button")
	@iOSFindBy(xpath = "")
    public MobileElement btn_Ok_AlertDialog;
	
	@AndroidFindBy(xpath = "//*[@text='QRScan']")
	@iOSFindBy(xpath = "")
    public MobileElement btn_QRCodeScanner;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.schneiderelectric.worktaskspro:id/barcodeText']")
	@iOSFindBy(xpath = "")
    public MobileElement txt_QRCodeScanMsg;
	
	@AndroidFindBy(xpath = "//*[@text='Alert Dialog']/android.view.View[1]/android.view.View[2]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_AlertDialog_Msg;
	
	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'select_option_')]]")
	@iOSFindBy(xpath = "")
    public List<MobileElement> select_RepoNames;
	
	
    public String Item_RepositoryName_Xpath(String repoName)
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return "//*[@Name='{" +  repoName +  "}']";
            case "IOS":
                return "//XCUIElementTypeOther[text()='{" +  repoName +  "}']";
            case "Android":
                return "//android.view.View[@text='{" +  repoName +  "}']";
            default:
                return "";
        }

    }
    
    

    
    
    public String btn_DemoMode_Xpath()
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {

            case "Windows":
                return "//*[@LocalizedControlType='check box' and @Name='DemoMode']";
            case "Android":
                return "//*[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox";
        }
        return "";
    }
    
    public void newAccountSetUp(String URL, String RepoName, String UserName, String Password)
    {

        if (GlobalSettings.MobilePlatformToRunTest == "IOS")
        {
            txt_ServerPath.click();
            txt_ServerPath.click();
            MobProp.getMobDriver().findElementByXPath("//*[text()='Paste']").click();
        }
        else
        {
            txt_ServerPath.sendKeys(URL);
        }

        dropdown_Repository.click();
        sleep(1000);
        List<MobileElement> RepoNames = select_RepoNames;
        MobileElement intendedRepoNameElement = null;
        
        for(int i=0;i<RepoNames.size(); i++)
        {
        	
        	if(RepoNames.get(i).getText().equals(RepoName))
        	{
        		intendedRepoNameElement = RepoNames.get(i);
        	}
        }
        
        intendedRepoNameElement.click();

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                txt_Username.clear();
                txt_Username.get(0).sendKeys(UserName);
                break;
            case "IOS":
                txt_Username.get(0).sendKeys(UserName);
                break;
            case "Android":
                txt_Username.get(1).sendKeys(UserName);
                sleep(1000);
                break;
        }

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                txt_Username.get(1).clear();
                txt_Username.get(1).sendKeys(Password);
                break;
            case "IOS":
                txt_Username.get(1).sendKeys(Password);
                break;
            case "Android":
                txt_Username.get(2).sendKeys(Password);
                break;
        }

        btn_LogOn.click();
        MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 50);

    }

    public void newAccountSetUpEnterAllDetailsWithoutClickingONLogin(String URL, String RepoName, String UserName, String Password)
    {

        if (GlobalSettings.MobilePlatformToRunTest == "IOS")
        {
            txt_ServerPath.click();
            MobProp.getMobDriver().findElementByXPath("//*[text()='Paste']").click();
        }
        else
        {
            txt_ServerPath.clear();
            txt_ServerPath.sendKeys(URL);
        }

        dropdown_Repository.click();
        sleep(1000);
        String xpathToRepoName = Item_RepositoryName_Xpath(RepoName);
        MobileAppiumFunctions.waituntilElementExists(xpathToRepoName, 15);
        MobileElement  element = MobProp.getMobDriver().findElementByXPath(xpathToRepoName);
        element.click();
        sleep(3000);

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                txt_Username.clear();
                txt_Username.get(0).sendKeys(UserName);
                break;
            case "IOS":
                txt_Username.get(0).sendKeys(UserName);
                break;
            case "Android":
                txt_Username.get(0).sendKeys(UserName);
                sleep(1000);
                break;
        }

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                txt_Username.get(1).clear();
                txt_Username.get(1).sendKeys(Password);
                break;
            case "IOS":
                txt_Username.get(1).sendKeys(Password);
                break;
            case "Android":
                txt_Username.get(1).sendKeys(Password);
                break;
        }

        

    }



    //Functions
    public void ConfigureNewAccount(String webAppUrl, String repoName, String userName, String password)
    {
        boolean IsLoginSuccess = false;
        int RetryCount = 0;
        while (!IsLoginSuccess)
        {
            try
            {
                newAccountSetUp(webAppUrl, repoName, userName, password);
                IsLoginSuccess = true;
            }
            catch (Exception e)
            {
                IsLoginSuccess = false;
                MobCommonFunctions.CloseApp();
                MobCommonFunctions.LaunchApp();
                RetryCount++;
            }

            if (RetryCount == 5)
            {
                System.out.println("Tried Configuring Account for 5 times and it was unsuccessful");
                break;
            }

        }
    }

    public void RemoveAccount()
    {
    	MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_AccountSettings.get(0).click();

            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(1000);
            OverFlowIcon_Page.btn_OverFlowDeleteAccount.click();
            sleep(1000);
            Dialogs_Page.btn_DialogOK.click();
            sleep(1000);
            MobileAppiumFunctions.waituntilElementIsVisible(btn_DemoMode, 20);

    }

    public void SelectRepo(String RepoName)
    {

    	dropdown_Repository.click();
        sleep(1000);
        String xpathToRepoName = Item_RepositoryName_Xpath(RepoName);
        MobileAppiumFunctions.waituntilElementExists(xpathToRepoName, 15);
        MobileElement element = MobProp.getMobDriver().findElementByXPath(xpathToRepoName);
        element.click();
        sleep(3000);

    }

        


    public void TurnOFFDemo()
    {
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AccountSettings.get(0).click();

            btn_DemoMode.click();
            
            //MobCommonFunctions.ClickOnSpecficElementsLocation(btn_DemoMode);

            try { MobileAppiumFunctions.waituntilElementIsVisible(btn_DemoMode, 20); }
            catch (Exception e) { }
        
    }


    public void TurnONDemoMode()
    {

        if (CheckIfDemoModeOn())
        {
            TurnOFFDemo();
            sleep(1000);
            btn_DemoMode.click();

            MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 20);
        }
        else if (checkIfAccountNotConfigured())
        {
        	btn_DemoMode.click();
            sleep(1000);
            MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 20);
        }
        else
        {
            RemoveAccount();
            sleep(1000);
            MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 20);
            btn_DemoMode.click();
            sleep(1000);
        }

    }

    

    public void RemoveConfiguredAccount()
    {

    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());

            RemoveAccount();

    }


    public boolean CheckIfDemoModeOn()
    {

    	boolean DemoModeAreadyON = false;

        if (!checkIfAccountNotConfigured())
        {
            try
            {
            	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMin());

                if (Inbox_Page.header_DemoMode.isEnabled())
                {
                    DemoModeAreadyON = true;
                }

            }
            catch (Exception e)
            {
            	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
            }
        }

        TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        return DemoModeAreadyON;

    }

    public boolean checkIfAccountNotConfigured()
    {
    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMin());
        boolean AccountNotConfigured = false;

        try
        {
            if (txt_ServerPath.isEnabled())
            {
                AccountNotConfigured = true;
            }

        }
        catch (Exception e)
        {
        	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        }
        TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        return AccountNotConfigured;
    }

    public boolean checkIfDesiredAccountIsAlreadyConfigured(String ExpectedServerPath, String ExpectedRepo, String ExpectedUserName)
    {
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_AccountSettings.get(0).click();

       String ServerPath =  txt_Selected_ServerPath.getText();
       String RepoName = dropdown_Selected_Repository.getText();
       String UserName = txt_Selected_Username.getText();


        if(ExpectedServerPath.toLowerCase().equals(ServerPath.toLowerCase()) && ExpectedRepo.toLowerCase().equals(RepoName.toLowerCase()) && ExpectedUserName.toLowerCase().equals(UserName.toLowerCase()))
        {
            MenuNav_Page.btn_Back.click();
            return true;
        }
        MenuNav_Page.btn_Back.click();
        return false;

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
