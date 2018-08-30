package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class Dashboard_Page extends WTAPageObject {
	
	
	@AndroidFindBy(xpath = "//android.view.View[@text='All Items'")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@id='Refresh']")
	public MobileElement header_Dashboard;

}
