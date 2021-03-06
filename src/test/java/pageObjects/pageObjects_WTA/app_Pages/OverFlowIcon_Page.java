package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class OverFlowIcon_Page extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.Spinner']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowOptions;

	@AndroidFindBy(xpath = "(//*[@class='android.view.MenuItem'])[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowDeleteAccount;

	@AndroidFindBy(xpath = "(//*[@class='android.view.MenuItem'])[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowHelp;

	@AndroidFindBy(xpath = "(//*[@class='android.view.MenuItem'])[3]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowAbout;

	@AndroidFindBy(xpath = "(//*[@class='android.view.MenuItem'])[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowClearAll;
	
	@AndroidFindBy(xpath = "(//*[@class='android.view.MenuItem'])[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_OverFlowDeleteItems;
	

}
