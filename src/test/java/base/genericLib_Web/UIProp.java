package base.genericLib_Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.*;



public class UIProp {
	
	private static WebDriver newWebDriver;
	

    public static Actions Actions;
	
	
	public static WebDriver getUIDriver() {
		return newWebDriver;
	}

	public static void setUIDriver(WebDriver UIDriver) {
		newWebDriver = UIDriver;
	}
	

    
	public static Actions getActions() {
		return Actions;
	}

	public static void setActions(Actions Action) {
		Actions = Action;
	}
}

