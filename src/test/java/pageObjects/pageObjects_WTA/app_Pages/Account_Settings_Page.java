package pageObjects.pageObjects_WTA.app_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import base.config.GlobalSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Account_Settings_Page extends WTAPageObject  {

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[1]")
	public MobileElement txt_ServerPath;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration_repository']")
	@iOSFindBy(xpath = "")
    public MobileElement dropdown_Repository;
	
	//@AndroidFindBy(xpath = "")
	//@iOSFindBy(xpath = "")
    public MobileElement item_RepositoryName;
	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
	List<MobileElement> txt_Username;

	
	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
	List<MobileElement> txt_Password;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
    public MobileElement chk_ShowPassword;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[3]//*[@class='android.widget.Button']")
	@iOSFindBy(xpath = "")
    public MobileElement btn_LogOn;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox")
	@iOSFindBy(xpath = "")
    public MobileElement btn_DemoMode;

	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_ServerPath;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement dropdown_Selected_Repository;
	
	@AndroidFindBy(xpath = "/*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_Username;
	
	@AndroidFindBy(xpath = "//*[@resource-id='configuration']/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.EditText[@resource-id[contains(.,'input_')]]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_Selected_Password;

	@AndroidFindBy(xpath = "//*[@text='Alert Dialog']/android.view.View[2]/android.widget.Button")
	@iOSFindBy(xpath = "")
    public MobileElement btn_Ok_AlertDialog;
	
	@AndroidFindBy(xpath = "//*[@text='QRScan']")
	@iOSFindBy(xpath = "")
    public MobileElement btn_QRCodeScanner;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.schneiderelectric.worktaskspro:id/barcodeText']")
	@iOSFindBy(xpath = "")
    public MobileElement txt_QRCodeScanMsg;
	
	@AndroidFindBy(xpath = "//*[@text='Alert Dialog']/android.view.View[1]/android.view.View[2]")
	@iOSFindBy(xpath = "")
    public MobileElement txt_AlertDialog_Msg;
	
	
    public String Item_RepositoryName_Xpath(String repoName)
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return "//*[@Name='{" +  repoName +  "}']";
            case "IOS":
                return "//XCUIElementTypeOther[text()='{" +  repoName +  "}']";
            case "Android":
                return "//android.view.View[@text='{" +  repoName +  "}']";
            default:
                return "";
        }

    }
    
    
    public String Btn_DemoMode_Xpath()
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {

            case "Windows":
                return "//*[@LocalizedControlType='check box' and @Name='DemoMode']";
            case "Android":
                return "//*[@resource-id='configuration']/android.view.View[2]/android.widget.CheckBox";
        }
        return "";
    }

}
