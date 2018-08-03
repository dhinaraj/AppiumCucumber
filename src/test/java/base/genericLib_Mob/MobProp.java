package base.genericLib_Mob;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class MobProp {
	

	private static AppiumDriver<MobileElement> newAppiumDriver;
	
	public static AppiumDriver<MobileElement> getMobDriver() {
		
		return newAppiumDriver;
	}

	public static void setMobDriver(AppiumDriver<MobileElement> MobDriver) {
		newAppiumDriver = MobDriver;
	}


}
