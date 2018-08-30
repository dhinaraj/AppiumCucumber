package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class InformationWorkItemPage extends WTAPageObject {
	
	@AndroidFindBy(xpath = "//*[@resource-id='workitem']/android.view.View[3]/android.view.View/android.widget.Button")
	@iOSFindBy(id = "Remove")
	public MobileElement btn_Remove;
	

}
