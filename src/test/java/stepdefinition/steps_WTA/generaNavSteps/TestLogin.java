package stepdefinition.steps_WTA.generaNavSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.genericLib_Mob.MobProp;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.pageObjects_WTA.app_Pages.Account_Settings_Page;
import pageObjects.pageObjects_WTA.app_Pages.InitialLoadingPage;

import base.genericLib_Mob.*;



public class TestLogin {
	
    Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
/*    InitialLoadingPage InitialLoadingPage = new InitialLoadingPage();
    MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();*/
	
	@Given("^I want to login to application$")
	public void i_want_to_login_to_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PageFactory.initElements(new AppiumFieldDecorator(MobProp.getMobDriver()), Account_Settings_Page);
		//waitUntilElementIsNoLongerInDom(InitialLoadingPage.img_InitialAppLoadingImage, 20);
		Account_Settings_Page.txt_ServerPath.sendKeys("http://10.184.208.160/EnterpriseConsole");
		
		//MobCommonFunctions.changeAppLanguage();
		///obProp.getMobDriver().closeApp();
		////MobProp.getMobDriver().launchApp();

		
	}
	
	

    
    
    public static void waitUntilElementIsNoLongerInDom(MobileElement element, int seconds)
    {
    	WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
        wait.until(ExpectedConditions.stalenessOf(element));


    }

}
