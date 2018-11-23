package pageObjects.pageObjects_WTA.localization_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Loc_Account_Settings_Page extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch[1]")
	public MobileElement switch_DemoMode;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[1]")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText")
	public MobileElement txt_ServerPath;

	@AndroidFindBy(xpath = "(//android.view.View[@resource-id[contains(.,'select_value_label')]])[1]/android.view.View")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeStaticText")
	public MobileElement dropdown_Repository;

	@AndroidFindBy(xpath = "(//android.view.View[@resource-id[contains(.,'select_value_label')]])[2]/android.view.View")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeStaticText")
	public MobileElement dropdown_Provider;


	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[1]")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeStaticText")
	public MobileElement txt_Username;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[1]")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[9]/XCUIElementTypeStaticText")
	public MobileElement txt_Password;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[2]/android.view.View/android.widget.CheckBox")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeSwitch")
	public MobileElement chk_ShowPassword;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='configuration']/android.view.View[3]/android.view.View/android.widget.Button")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeButton")
	public MobileElement btn_LogOn;


	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_Selected_ServerPath;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement dropdown_Selected_Repository;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement dropdown_Selected_Provider;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_Selected_Username;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_Selected_Password;
	
	
    public String Txt_ServerPathXpath()
    {
        switch (GlobalSettings.getMobilePlatformToRunTest())
        {
            case "Windows":
                return "//*[@Name='Server Path']";
            case "IOS":
                //return "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
            	return "(//XCUIElementTypeOther[@name='Work Tasks Pro'])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
            case "Android":
                return "/android.view.View[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox";
            default:
                return "";
        }

    }
}
