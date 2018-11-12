package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import hooks.TestInitializeHook;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class LogOff_In_Page extends WTAPageObject {
	
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	
	@AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id[contains(., 'input')]])[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement fld_UserName;

	@AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id[contains(., 'input')]])[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement fld_Password;

	@AndroidFindBy(xpath = "//*[@resource-id='login']/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement loc_fld_UserName;

	@AndroidFindBy(xpath = "//*[@resource-id='login']/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement loc_fld_Password;

	@AndroidFindBy(xpath = "//*[@resource-id='login']//*[@class='android.widget.CheckBox']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement chkbox_ShowPassword;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='login']/android.view.View[3]/android.view.View/android.widget.Button")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_LogOn;

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'dialogContent')]]/android.view.View[1]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement text_LoginPage_DialogTitle;

	@AndroidFindBy(xpath = "//*[@resource-id[contains(.,'dialogContent')]]/android.view.View[2]")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement text_LoginPage_DialogError;

	@AndroidFindBy(xpath = "//*[@text='Alert Dialog']/android.view.View[2]/android.widget.Button")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_Login_Page_DialogOK;
	
    public void LogIn(String UserName, String Password)
    {

                fld_UserName.clear();
                fld_UserName.sendKeys(UserName);
                fld_Password.clear();
                fld_Password.sendKeys(Password);


        btn_LogOn.click();

    }
    
    
    public void LogOff()
    {
    	MenuNav_Page.btn_HamBurgerMenu.click();
    	MenuNav_Page.btn_LogOff.click();
        MobileAppiumFunctions.waituntilElementclickable(fld_UserName);

    }

    public boolean CheckIfAccountLoggedOff()
    {

    	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMin());
        if (fld_UserName.isEnabled())
        {
        	TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
            return true;  
        }
        TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
        return false;

      

    }

}
