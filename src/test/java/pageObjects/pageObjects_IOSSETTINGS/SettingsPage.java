package pageObjects.pageObjects_IOSSETTINGS;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.pageObjects_WTA.WTAPageObject;

public class SettingsPage extends WTAPageObject {

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More Info\"])[8]")
	public MobileElement btn_GeneralSettings;
	
	
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More Info\"])[13]")
	public MobileElement btn_LanguageAndRegion;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More Info\"])[1]")
	public MobileElement btn_Language;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeSearchField")
	public MobileElement fld_Search;
	
	//XCUIElementTypeStaticText[@name="Deutsch"]
	

}
