package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class ApproveWorkItemPage extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//*[@resource-id='workitem']/android.view.View[3]/android.view.View/android.widget.Button[2]")
	@iOSFindBy(id = "Approve")
	public MobileElement btn_Approve;

	@AndroidFindBy(xpath = "//*[@resource-id='workitem']/android.view.View[3]/android.view.View/android.widget.Button[1]")
	@iOSFindBy(id = "Reject")
	public MobileElement btn_Reject;

	@AndroidFindBy(xpath = "//android.widget.EditText[@id[contains(., 'input')]]")
	@iOSFindBy(xpath = "//*[@id='Comments']/following-sibling::*[1]")
	public MobileElement fld_Comments;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text[contains(., 'Demo')]]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement text_ApprovalItemTitle;

	@AndroidFindBy(xpath = "//*[@resource-id='workitem']/android.view.View[2]/android.view.View/android.view.View[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement txt_Comments;
	

}
