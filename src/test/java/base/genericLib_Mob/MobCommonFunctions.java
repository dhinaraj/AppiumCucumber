package base.genericLib_Mob;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.pageObjects_IOSSETTINGS.SettingsPage;
import pageObjects.pageObjects_WTA.app_Pages.Account_Settings_Page;

public class MobCommonFunctions {
	
	
	private static AppiumDriver<MobileElement> newAppiumDriver;
	
	 SettingsPage SettingsPage = new SettingsPage();
	
	public void changeAppLanguage()
	{
		
		
		DesiredCapabilities IOSCapabilities = new DesiredCapabilities();

        IOSCapabilities.setCapability("automationName", "XCUITest");
        IOSCapabilities.setCapability("platformName", "iOS");
        IOSCapabilities.setCapability("platformVersion", "11.4.1");
        IOSCapabilities.setCapability("deviceName", "Auron's iPhone");
        IOSCapabilities.setCapability("udid", "32798c6c811f74f62ac6e73c24258f7286484ee2");
        IOSCapabilities.setCapability("noReset", "true");
        //IOSCapabilities.setCapability("bundleId", "com.schneiderelectric.worktaskspro");
        IOSCapabilities.setCapability("app", "Settings");
        IOSCapabilities.setCapability("clearSystemFiles", true);
        
        IOSCapabilities.setCapability("ignoreUnimportantViews", "true");
        IOSCapabilities.setCapability("newCommandTimeout", "300");
        IOSCapabilities.setCapability("report.disable", true);
        IOSCapabilities.setCapability("maxTypingFrequency ", 30);
        try
        {
        	newAppiumDriver = (new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), IOSCapabilities));
        }
        catch (Exception e)
        {

            System.out.printf("%s", e.getMessage());
            System.out.printf("%s",e.getStackTrace().toString());
            System.out.printf("Mobile Driver Could not be intitialized");
        }
        
        PageFactory.initElements(new AppiumFieldDecorator(newAppiumDriver), SettingsPage);
        
        SettingsPage.btn_GeneralSettings.click();
        SettingsPage.btn_LanguageAndRegion.click();
        SettingsPage.btn_Language.click();
        newAppiumDriver.quit();

		
	}

}
