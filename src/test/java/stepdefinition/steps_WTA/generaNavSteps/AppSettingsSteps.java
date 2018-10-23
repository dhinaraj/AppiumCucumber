package stepdefinition.steps_WTA.generaNavSteps;

import cucumber.api.java.en.Given;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class AppSettingsSteps {
	
	AppSettings_Page AppSettings_Page = new AppSettings_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	
	
	
	@Given("^I Turn on Drafts in Settings page$")
	public void i_turn_on_drafts_in_settings_page() throws Throwable {
		
		AppSettings_Page.turnOnDraftsInSettings();
		MenuNav_Page.btn_Back.click();
		
		}
		
	

}
