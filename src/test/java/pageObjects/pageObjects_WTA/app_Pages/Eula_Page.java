package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import hooks.TestInitializeHook;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Eula_Page extends WTAPageObject {

	
	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[3]/android.view.View/android.widget.Button[2]")
	@iOSFindBy(accessibility = "Accept")
	public MobileElement btn_Eula_Accept;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[3]/android.view.View/android.widget.Button[1]")
	@iOSFindBy(xpath = "Cancel")
	public MobileElement btn_Eula_Cancel;
	
	@AndroidFindBy(xpath = "//*[@text='AVEVA MASTER END USER LICENSE AGREEMENT (the �EULA�)']")
	@iOSFindBy(xpath = "//*[@text='AVEVA MASTER END USER LICENSE AGREEMENT (the �EULA�)']")
	public MobileElement txt_StartOfEula;
	
	
	@AndroidFindBy(xpath = "//*[@text='5. Wonderware Development Studio and Advanced Development Studio Use and Restrictions.']")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"5. Wonderware Development Studio and Advanced Development Studio Use and Restrictions.\"]")
	public MobileElement txt_EndOfEula;
	
	@iOSFindBy(accessibility = "OK")
	public MobileElement btn_AllowCameraAccess;
	
	@iOSFindBy(accessibility = "Allow")
	public MobileElement btn_AllowNotifications;
	

    public String AcceptBtnXpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                return "//*[@Name='Accept']";
            case "IOS":
                return "//*[@id='Server Path']/following-sibling::XCUIElementTypeTextField[1]";
            case "Android":
                return "//*[@resource-id='viewContainer']/android.view.View[3]/android.view.View/android.widget.Button[2]";
            default:
                return "";
        }

    }
    
    
    public boolean isCameraPermissionOKButtonVisible()
    {
    		boolean isButtonVisible = true;
    		
    		TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 3);
    		
    		try {
    		btn_AllowCameraAccess.isDisplayed();

    		}
    		catch(Exception e){
    			System.out.println("Ok button to allow camera access is not available");
    			isButtonVisible=false;
    		}
    		
    		
    		return isButtonVisible;
    }
	

}
