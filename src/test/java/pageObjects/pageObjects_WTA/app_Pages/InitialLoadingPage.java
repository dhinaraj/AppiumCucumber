package pageObjects.pageObjects_WTA.app_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import base.config.GlobalSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.pageObjects_WTA.WTAPageObject;

public class InitialLoadingPage extends WTAPageObject  {
	
	


	@AndroidFindBy(id = "imageView1")
	//@iOSFindBy(xpath = "")
	public MobileElement img_InitialAppLoadingImage;


}
