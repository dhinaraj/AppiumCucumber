package stepdefinition.steps_WTA.generaNavSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import base.genericLib_Mob.*;



public class App_Install_Uninstall_Steps {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
	@Given("^I uninstall if worktaskspro app is already installed$")
	public void i_uninstall_if_worktaskspro_app_is_already_installed() throws Throwable {
		
		MobCommonFunctions.UninstallApp();

	}

	@Given("^I install worktaskspro app$")
	public void i_install_worktaskspro_app() throws Throwable {
		MobCommonFunctions.InstallApp();
	}

	@When("^I Lanuch the app$")
	public void i_Lanuch_the_app() throws Throwable {

		MobCommonFunctions.LaunchApp();

	}



}
