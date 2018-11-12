package stepdefinition.steps_WTA.generaNavSteps;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import base.config.GlobalSettings;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pageObjects_WTA.app_Pages.*;


public class InboxPageSteps {
	
	Inbox_Page Inbox_Page = new Inbox_Page();
	
	private Map<String, String> expectedStrings = new HashMap<String, String>();
	

	@When("^I navigate to \"([^\"]*)\" Workitems page$")
	public void i_navigate_to_page(String WorkItemPage) throws Throwable {
		Inbox_Page.NavigateToWorkItemFilter(WorkItemPage);
	    
	}

	@When("^I flag an approval item$")
	public void i_flag_an_approval_items() throws Throwable {
		Inbox_Page.btn_WorkItem_Flag_FirstItem.click();	

	}

	@When("^I update the flag for workitem with \"([^\"]*)\"$")
	public void i_update_the_flag_for_workitem_with(String WorkItemTitle) throws Throwable {
		Inbox_Page.clickOnPriorityFlagOnWorkItemWithTitle(WorkItemTitle); 
	}

	@Then("^the item must be listed in flagged items with title \"([^\"]*)\"$")
	public void the_item_must_be_listed_in_flagged_items_with_title(String WorkItemTitle) throws Throwable {
		
		String expectedWorkTitemTitle = "";
		
		if(GlobalSettings.getMobilePlatformToRunTest().equals("IOS"))
		{
			expectedWorkTitemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getAttribute("name");
		}
		if(GlobalSettings.getMobilePlatformToRunTest().equals("Android"))
		{
			expectedWorkTitemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getText();
		}
		
		
		Assert.assertEquals(expectedWorkTitemTitle, WorkItemTitle, "Test Failed as the expected work item title does not match");
	}
	
	
	@When("^I clear all flagged items if present$")
	public void i_clear_all_flagged_items_if_present() throws Throwable {
		Inbox_Page.clearAllFlaggedItemsIfExists();
	}
	
	
	@When("^I search for item with title \"([^\"]*)\"$")
	public void i_search_for_item_with_title(String workItemTitle) throws Throwable {
		Inbox_Page.searchForWorkItemWithTitle(workItemTitle);
	
	}
	
	@When("^I clear the inbox search$")
    public void i_clear_the_inbox_search() throws Throwable {
		Inbox_Page.btn_SearchClear.click();
        
    }
	
	@When("^I click the back button on inbox search$")
	public void i_click_the_back_button_on_inbox_search() throws Throwable {
		Inbox_Page.btn_SearchBack.click();
	    
	}
	
	
	@Then("^the new work item should be displayed$")
	public void the_new_work_item_should_be_displayed() throws Throwable {
	   
		String newWorkItemTitle = "";
		
		if(GlobalSettings.getMobilePlatformToRunTest().equals("IOS"))
		{
			newWorkItemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getAttribute("name");
		}
		if(GlobalSettings.getMobilePlatformToRunTest().equals("Android"))
		{
			newWorkItemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getText();
		}
		
		Assert.assertNotEquals(newWorkItemTitle, expectedStrings.get("LastWorkItemTitle"), "New Work Item did not appear");


	}
	
	
	@When("^I get the first work item title$")
	public void i_get_the_first_work_item_title() throws Throwable {

		String currentWorkItemTitle = "";
		
		if(GlobalSettings.getMobilePlatformToRunTest().equals("IOS"))
		{
			currentWorkItemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getAttribute("name");
		}
		if(GlobalSettings.getMobilePlatformToRunTest().equals("Android"))
		{
			currentWorkItemTitle = Inbox_Page.btn_workItemTitle_FirstItem.getText();
		}
		
		expectedStrings.put("LastWorkItemTitle", currentWorkItemTitle);
	    
	}


}
