package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class AppSettings_Page extends WTAPageObject {
	
	
	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Settings;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ListView']/android.view.View/android.view.View/android.view.View/android.view.View")
	@iOSFindBy(xpath = "")
	public MobileElement btn_Logging;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ListView']/android.view.View[3]/android.view.View/android.view.View/android.view.View")
	@iOSFindBy(xpath = "")
	public MobileElement btn_Sync;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[1]/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Logging;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[2]/android.view.View")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Level;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[2]/android.view.View[2]/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Error;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[2]/android.view.View[3]/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Warning;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[2]/android.view.View[4]/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Information;

	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[1]/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "")
	public MobileElement txt_Sync;


	@AndroidFindBy(xpath = "//*[@resource-id='viewContainer']/android.view.View[2]/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "")
	public MobileElement txt_ItemsToSyncForLookupAndData;

}
