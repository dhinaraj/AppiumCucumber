package stepdefinition.steps_WTA.generaNavSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class ManageAccountSteps {
	
	Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
	
	@When("^I configure \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_configure_and(String webAppUrl, String repoName, String arg3, String userName, String password) throws Throwable {
		Account_Settings_Page.ConfigureNewAccount(webAppUrl, repoName, userName, password);
	}


	@Then("^logon should be sucessful and user can see the hamburger menu icon$")
	public void logon_should_be_sucessful_and_user_can_see_the_hamburger_menu_icon() throws Throwable {

	}

}
