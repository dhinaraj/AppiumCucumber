package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class About_Page extends WTAPageObject {
	
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View/android.view.View/android.view.View")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement txt_About;
	
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[1]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_AppName;
	
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[2]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Version;
	

	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[3]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_CopyRight;
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[4]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_PrivacyPolicy;
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[5]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_ViewOnline;
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[6]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_TechinicalSupport;
	
	@AndroidFindBy(xpath ="((//*[@resource-id='configuration']/*[@class='android.view.View'])[2]/*[@text and @class='android.view.View'])[7]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Contact;

}
