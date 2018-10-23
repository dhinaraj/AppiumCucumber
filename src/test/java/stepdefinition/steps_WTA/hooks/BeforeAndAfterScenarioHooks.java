package stepdefinition.steps_WTA.hooks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import hooks.TestInitializeHook;
import main.CucumberHelperTestSteps;
import pageObjects.pageObjects_WTA.app_Pages.About_Page;
import pageObjects.pageObjects_WTA.app_Pages.Account_Settings_Page;
import pageObjects.pageObjects_WTA.app_Pages.AppSettings_Page;
import pageObjects.pageObjects_WTA.app_Pages.ApproveWorkItemPage;
import pageObjects.pageObjects_WTA.app_Pages.Dashboard_Page;
import pageObjects.pageObjects_WTA.app_Pages.DemoFillForm_Page;
import pageObjects.pageObjects_WTA.app_Pages.Dialogs_Page;
import pageObjects.pageObjects_WTA.app_Pages.Drafts_Page;
import pageObjects.pageObjects_WTA.app_Pages.Eula_Page;
import pageObjects.pageObjects_WTA.app_Pages.FillForm_Page;
import pageObjects.pageObjects_WTA.app_Pages.Inbox_Page;
import pageObjects.pageObjects_WTA.app_Pages.InformationWorkItemPage;
import pageObjects.pageObjects_WTA.app_Pages.InitialLoadingPage;
import pageObjects.pageObjects_WTA.app_Pages.LogOff_In_Page;
import pageObjects.pageObjects_WTA.app_Pages.MenuNav_Page;
import pageObjects.pageObjects_WTA.app_Pages.Outbox_Page;
import pageObjects.pageObjects_WTA.app_Pages.OverFlowIcon_Page;
import pageObjects.pageObjects_WTA.app_Pages.SentItems_Page;
import pageObjects.pageObjects_WTA.localization_Pages.Loc_Account_Settings_Page;
import main.*;

public class BeforeAndAfterScenarioHooks {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
    Loc_Account_Settings_Page Loc_Account_Settings_Page = new Loc_Account_Settings_Page();
    About_Page About_Page = new About_Page();
    Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
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
    
   
	
	@Before("@InstallAppBeforeScenario")
    public void InstallAppBeforeScenario(){
		MobCommonFunctions.InstallApp();
    }	
	
	@After("@UninstallAppAfterScenario")
    public void UninstallAppAfterScenario(){
		MobCommonFunctions.UninstallApp();
    }
	
	@Before("@UninstallAppAndInstallApp")
    public void UninstallAppAndInstallAppBeforeScenario(){
		MobCommonFunctions.UninstallApp();
		MobCommonFunctions.InstallApp();
    }
	
	@After("@AcceptEulaHook_AfterScenarioHook")
    public void AcceptEulaHook_AfterScenarioHook(){
		Eula_Page.btn_Eula_Accept.click();
		
    }
	
	@After("@LogIn_AfterScenarioHook")
    public void LogIn_AfterScenarioHook(){
		LogOff_In_Page.fld_UserName.sendKeys(GlobalSettings.getUserName());
		LogOff_In_Page.fld_UserName.sendKeys(GlobalSettings.getPassword());
		LogOff_In_Page.btn_LogOn.click();
		
    }
	
	@After("@TurnONInternet_AfterScenarioHook")
    public void TurnONInternet_AfterScenarioHook(){
        try
        {
            MobCommonFunctions.SwitchToOnlineMode();
        }
        catch (Exception e)
        {


        }
		
    }
	
	
//	@Before(value = "@IOS", order=0)
//	public static void startIOSDriver() {
//		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
//		{
//				boolean isDriverInitialized = initializeDriver(3);
//				if(isDriverInitialized)
//				{
//				TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
//				}
//
//		}
//	}
//	
//	@After(value = "@IOS", order=0)
//	public static void quitIOSDriver() {
//		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
//		{
//		
//		 if (MobProp.getMobDriver() != null) {
//				TestInitializeHook.quitDriver(MobProp.getMobDriver());
//		        }
//		}
//	    
//	}
	
	@Before(order = 1)
	public static void before( Scenario scenario) {
	    CucumberHelperTestSteps.scenario = scenario;
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
		{
		//if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll("\\s", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath =  ((TakesScreenshot) MobProp.getMobDriver()).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(CucumberRunner.cucumberAbsoluteReportPath +"/screenshots/"+ screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath("../" + CucumberRunner.cucumberRelativeReportPath +"/screenshots/" + screenshotName + ".png");
				
				MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
				MobCommonFunctions.CloseApp(); 
			} catch (IOException e) {
			//} 
			}
		}
		
	}
	


}
