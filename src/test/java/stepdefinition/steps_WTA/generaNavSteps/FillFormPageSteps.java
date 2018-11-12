package stepdefinition.steps_WTA.generaNavSteps;

import org.testng.Assert;

import base.genericLib_Mob.MobCommonFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pageObjects_WTA.app_Pages.*;
import pageObjects.pageObjects_WTA.formPages.*;

public class FillFormPageSteps {
	
	Inbox_Page Inbox_Page = new Inbox_Page();
	FillForm_Page FillForm_Page = new FillForm_Page();
	FormWithInputs FormWithInputs = new FormWithInputs();

	@When("^I open Fill Form \"([^\"]*)\"$")
	public void i_open_Fill_Form(String fillFormName) throws Throwable {
		FillForm_Page.TapOnFillFormName(fillFormName);
	}
	
	
	@When("^I submit Form With Inputs with \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void submit_Form_With_Inputs_with(String arg1, String arg2, String arg3) throws Throwable {
		
		FormWithInputs.enterFormInputAndSubmit(arg1, arg2, arg3);
	   
	}



}
