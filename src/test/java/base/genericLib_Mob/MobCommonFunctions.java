package base.genericLib_Mob;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import base.config.GlobalSettings;
import hooks.TestInitializeHook;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.pageObjects_IOSSETTINGS.SettingsPage;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class MobCommonFunctions {

	private  AppiumDriver<MobileElement> newAppiumDriver;
	
	
	TestInitializeHook mainHook = new TestInitializeHook();
	
	
	
	
	

	public void changeDeviceLanguage(String language, String country) {
		


		if (GlobalSettings.getMobilePlatformToRunTest().equals("IOS")) {
			
			if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
			{
			if (MobProp.getMobDriver().getSessionId() != null) {
				TestInitializeHook.quitDriver(MobProp.getMobDriver());
	        }
			}


			
			initializeDriver(3, language, country);
			
			
			}
		if (GlobalSettings.getMobilePlatformToRunTest().equals("Android")) {
			RunCmdCommand("adb shell am start -n net.sanapeli.adbchangelanguage/.AdbChangeLanguage -e language "
					+ language + "  -e country " + country);
		}
		
		

	}

	public void RunCmdCommand(String Command) {

		try {

			//Use below when running test from Windows
				//Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /C " + Command);

			//Use below when test is run from MAC
					Runtime.getRuntime().
							exec("/Users/administrator/Library/Android/sdk/platform-tools/"+ Command);
    
	        
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void LaunchApp() {
		MobProp.getMobDriver().launchApp();
		// MobileSeleniumMethods.waituntilElementIsNoLongerInDom(MenuNavPage.Img_InitialAppLoadingImage,
		// 20);
	}

	public void CloseApp() {

		MobProp.getMobDriver().closeApp();
	}

	public void UninstallApp() {

		try {
			if (GlobalSettings.getMobilePlatformToRunTest().equals("Android")) {
				//MobProp.getMobDriver().removeApp("com.schneiderelectric.worktaskspro");
				RunCmdCommand("adb uninstall com.schneiderelectric.worktaskspro");
			}
			if (GlobalSettings.getMobilePlatformToRunTest().equals("IOS")) {
				MobProp.getMobDriver().removeApp("com.V9S2B6YKKV_com.schneiderelectric.worktaskspro");
			}
		} catch (Exception e) {

		}
	}

	public  void InstallApp() {
		if (GlobalSettings.getMobilePlatformToRunTest().equals("Android")) {
			MobProp.getMobDriver().installApp(GlobalSettings.getAndroidMobileAppPath());
		}
		
		if (GlobalSettings.getMobilePlatformToRunTest().equals("IOS")) {
			MobProp.getMobDriver().installApp(GlobalSettings.getIOSMobileAppPath());
		}
		
	}

	public void SwitchToOfflineMode() {
		switch (GlobalSettings.getMobilePlatformToRunTest()) {
		case "Windows":
			RunCmdCommand("netsh interface set interface \"Ethernet\" admin=disable");
			break;
		case "Android":
			RunCmdCommand("adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable");

			break;
		case "IOS":
			ToggleWiFiOnIPhone();
			break;
		}

	}

	private static void ToggleWiFiOnIPhone() {
		int screenXPos = MobProp.getMobDriver().manage().window().getSize().getWidth() >> 2;
		int screenYPos = MobProp.getMobDriver().manage().window().getSize().getHeight();
		MobileAppiumFunctions.swipe(screenXPos, screenYPos, screenXPos, screenYPos >> 2, 300);
		MobProp.getMobDriver().findElementByXPath("//XCUIElementTypeSwitch[contains(., 'Wi-Fi')]").click();
		MobileAppiumFunctions.swipe(screenXPos, screenYPos >> 2, screenXPos, screenYPos, 300);
	}

	public void SwitchToOnlineMode() {
		try {

			switch (GlobalSettings.getMobilePlatformToRunTest()) {
			case "Windows":
				RunCmdCommand("netsh interface set interface \"Ethernet\" admin=enable");
				break;
			case "IOS":
				ToggleWiFiOnIPhone();
				break;
			case "Android":
				RunCmdCommand("adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable");
				break;
			}
		}

		catch (Exception e) {

		}

	}
	
	
	public void clearAppData() {
		
			//Android Command to Reset App
			//RunCmdCommand("adb shell pm clear com.schneiderelectric.worktaskspro");
		

		switch (GlobalSettings.getMobilePlatformToRunTest()) {
		case "Windows":
			
			break;
		case "IOS":
			UninstallApp();
			InstallApp();
			break;
		case "Android":
			MobProp.getMobDriver().resetApp();
			break;
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
    
    public void hideKeyboardOnIOS()
    {
    	if(GlobalSettings.getMobilePlatformToRunTest().equals("IOS"))
        {
      	  MobProp.getMobDriver().findElement(By.id("Done")).click();
        }
    }
    

	public boolean initializeDriver(int retryCount, String language, String country)
	{

		boolean isDriverInitialized = false;
		for (int i = 0; i <= retryCount; i++) {

			try {
				System.out.println("Driver intializaion Attempt :  " + i);
				
				TestInitializeHook.InitializeMobileDriver(language, country);
				if(MobProp.getMobDriver().getSessionId()!=null)
				{
					isDriverInitialized = true;
				}

			} catch (Exception e) {
				System.out.println("Driver intializaion failed");
				e.printStackTrace();
			}
			
			if(isDriverInitialized)
			{
				System.out.println("Driver intializaion Attempt :  " + i + "Sucessful");
				break;
			}
			else
			{
				System.out.println("Driver intializaion Attempt :  " + i + "Failed");
			}
		}

		return isDriverInitialized;
	}


}
