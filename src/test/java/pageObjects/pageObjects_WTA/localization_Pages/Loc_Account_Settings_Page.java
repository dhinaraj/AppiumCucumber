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
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.CheckBox' and ./following-sibling::*[@class='android.view.View']]")
	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[text()='DemoMode']")
	public MobileElement switch_DemoMode;

	@AndroidFindBy(xpath = "//*[@text and @class='android.view.View' and ./following-sibling::*[@resource-id[contains(.,'input_')]]]")
	@iOSFindBy(xpath = "//*[@id='Server Path']/following-sibling::XCUIElementTypeTextField[1]")
	public List<MobileElement> txt_ServerPath;

	@AndroidFindBy(xpath = "//*[@text and @class='android.view.View' and ./parent::*[@resource-id[contains(.,'select_value_label_')]]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[contains(., 'Repository') and following::XCUIElementTypeOther[text()='Provider'] and preceding::XCUIElementTypeOther[contains(., 'Repository')]]")
	public List<MobileElement> dropdown_Repository;

	@AndroidFindBy(xpath = "//*[@text and @class='android.view.View' and ./parent::*[@resource-id[contains(.,'select_value_label_')]]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[contains(., 'Repository') and following::XCUIElementTypeOther[text()='Provider'] and preceding::XCUIElementTypeOther[contains(., 'Repository')]]")
	public List<MobileElement> dropdown_Provider;


	@AndroidFindBy(xpath = "//*[@text and @class='android.view.View' and ./following-sibling::*[@resource-id[contains(.,'input_')]]]")
	@iOSFindBy(xpath = "xpath=(//XCUIElementTypeTextField)[2]")
	public List<MobileElement> txt_Username;

	@AndroidFindBy(xpath = "//*[@text and @class='android.view.View' and ./following-sibling::*[@resource-id[contains(.,'input_')]]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[text()= 'Password']/following-sibling::XCUIElementTypeSecureTextField[1]")
	public List<MobileElement> txt_Password;

	@AndroidFindBy(xpath = "//*[@class='android.widget.CheckBox' and ./preceding-sibling::*[@class='android.view.View']]")
	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[text()= 'ShowPassword']")
	public MobileElement chk_ShowPassword;

	@AndroidFindBy(xpath = "(//*[@resource-id='configuration']/*/*/*[@class='android.widget.Button'])[4]")
	@iOSFindBy(id = "LogOn")
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
                return "//*[@id='Server Path']/following-sibling::XCUIElementTypeTextField[1]";
            case "Android":
                return "//*[@resource-id[contains(.,'input_')]]";
            default:
                return "";
        }

    }
}
