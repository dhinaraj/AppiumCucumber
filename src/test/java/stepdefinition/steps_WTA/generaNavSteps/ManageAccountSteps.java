package stepdefinition.steps_WTA.generaNavSteps;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileCommand;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class ManageAccountSteps {
	
	Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	Dialogs_Page Dialogs_Page = new Dialogs_Page();
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
	private Map<String, String> expectedStrings = new HashMap<String, String>();
	
	
	
	@When("^I configure \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_configure_and(String webAppUrl, String repoName, String arg3, String userName, String password) throws Throwable {
		String ulr = getServerPath(webAppUrl);
		
		Account_Settings_Page.ConfigureNewAccount(ulr, repoName, userName, password);
	}


	@Then("^logon should be sucessful and user can see the hamburger menu icon$")
	public void logon_should_be_sucessful_and_user_can_see_the_hamburger_menu_icon() throws Throwable {
		MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 120);
	}
	
	@When("^I configure with invalid server paths$")
	public void i_configure_with_invalid_server_paths() throws Throwable {
		
		String[] invalidServerPaths = {"http://testInvalidServer.com", "https://testInvalidServer.com", "htt://testInvalidServer.com"};
		
		
		for(int i=0; i<invalidServerPaths.length;i++) {
			MobCommonFunctions.LaunchApp();
			Account_Settings_Page.txt_ServerPath.sendKeys(invalidServerPaths[i]);
			Account_Settings_Page.dropdown_Repository.click();
			String actualWarningText =Account_Settings_Page.txt_AlertDialog_Msg.getText();
			expectedStrings.put(invalidServerPaths[i],actualWarningText);
			
		}


	}

	@Then("^I should get appropriate error messages for invalid serverpath$")
	public void i_should_get_appropriate_error_messages() throws Throwable {
		
		Map<String, String> expectedWarningMessages = new HashMap<String, String>();
		expectedWarningMessages.put("http://testInvalidServer.com", "Failed to perform the operation");
		expectedWarningMessages.put("https://testInvalidServer.com" , "Failed to perform the operation");
		expectedWarningMessages.put("htt://testInvalidServer.com", "Invalid Server Path. Begin the server path with 'http://' or 'https://'");
		
		for ( String key : expectedStrings.keySet() ) {
			String expectedtext = expectedStrings.get(key);
			String actualText = expectedStrings.get(key);
			Assert.assertEquals(actualText, expectedtext, "Warning messages for invalid server path not matching");
		}
		
	}
	
	@When("^I configure with invalid login details$")
	public void i_configure_with_invalid_login_details() throws Throwable {
		
		String[][] credentials = {{"admin1", "admin", "admin2"}, {"admin1", "admin1", "admin"}};
		String serverPath = getServerPath("httpurl");
		
		for(int i=0 , j=0, x=0, y=1; i<3;i++) {
			MobCommonFunctions.LaunchApp();
			Account_Settings_Page.txt_ServerPath.sendKeys(serverPath);
			Account_Settings_Page.dropdown_Repository.click();
			Account_Settings_Page.select_Repo(GlobalSettings.getTestRepoName());
			Account_Settings_Page.txt_Username.sendKeys(credentials[x][i]);
			Account_Settings_Page.txt_Password.sendKeys(credentials[y][j]);
			if(GlobalSettings.getMobilePlatformToRunTest().equals("IOS"))
			{
				//Hides Keyboard and submits for login on IOS
				MobProp.getMobDriver().hideKeyboard();
			
			}
			if(GlobalSettings.getMobilePlatformToRunTest().equals("Android"))
			{
				Account_Settings_Page.btn_LogOn.click();;
			}
			
			String actualWarningText =Account_Settings_Page.txt_AlertDialog_Msg.getText();
			expectedStrings.put(credentials[x][i],actualWarningText);
			i++;
			j++;
		}

	   
	}

	@Then("^I should get appropriate warning messages for authentication errors$")
	public void i_should_get_appropriate_warning_messages_for_authentication_errors() throws Throwable {
		
		Map<String, String> expectedWarningMessages = new HashMap<String, String>();
		expectedWarningMessages.put("admin1", "Invalid Username or Password");
		expectedWarningMessages.put("admin" , "Invalid Username or Password");
		expectedWarningMessages.put("admin2", "Invalid Username or Password");
		
		for ( String key : expectedStrings.keySet() ) {
			String expectedtext = expectedStrings.get(key);
			String actualText = expectedStrings.get(key);
			Assert.assertEquals(actualText, expectedtext, "Warning messages for authentication errors not matching");
		}
		

	}
	
	
	public String getServerPath(String serverURL)
	{
		String serverPath = "";
		
		if(serverURL.equalsIgnoreCase("httpurl"))
		{
			serverPath = GlobalSettings.getHttpUrl();
		}
		if(serverURL.equalsIgnoreCase("httpsurl"))
		{
			serverPath = GlobalSettings.getHttpsUrl();
		}
		if(serverURL.equalsIgnoreCase("azureurl"))
		{
			serverPath = GlobalSettings.getAzureServiceBusUrl();
		}
		
		return serverPath;
	}
	
	
	@Given("^I configure \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" account if it is not already configured$")
	public void i_configure_and_account_if_it_is_not_already_configured(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {

	}

}
