package stepdefinition.steps_WTA.generaNavSteps;

import org.testng.Assert;

import base.genericLib_Mob.MobCommonFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pageObjects_WTA.app_Pages.*;


public class MenuNavSteps {
	
	Inbox_Page Inbox_Page = new Inbox_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	
	@When("^I navigate to \"([^\"]*)\" menu option$")
	public void i_navigate_to_menu_option(String menuName) throws Throwable {
		
		MenuNav_Page.navigateToMenuOption(menuName);
	  
	}

}
