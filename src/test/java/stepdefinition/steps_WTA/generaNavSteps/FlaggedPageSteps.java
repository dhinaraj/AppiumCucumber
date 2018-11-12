package stepdefinition.steps_WTA.generaNavSteps;

import org.testng.Assert;

import base.genericLib_Mob.MobCommonFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pageObjects_WTA.app_Pages.*;


public class FlaggedPageSteps {
	
	Inbox_Page Inbox_Page = new Inbox_Page();
	

	@Then("^the approval item must be listed in flagged items$")
	public void the_approval_item_must_be_listed_in_flagged_items() throws Throwable {
		String flaggedItemActualText = Inbox_Page.btn_workItemTitle_FirstItem.getText();
		String flaggedItemExpectedText = "(No Subject)";
		 Assert.assertEquals(flaggedItemActualText, flaggedItemExpectedText, "Expected Flagged Item's title did not match");
		
	}

}
