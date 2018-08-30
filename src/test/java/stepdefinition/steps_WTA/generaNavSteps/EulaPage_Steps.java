package stepdefinition.steps_WTA.generaNavSteps;

import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.testng.Assert;

import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.pageObjects_WTA.app_Pages.*;



public class EulaPage_Steps {
	
	Eula_Page Eula_Page = new Eula_Page();
	
	@Then("^I should see the Agree and Cancel Buttons on EULA screen$")
	public void i_should_see_the_Agree_and_Cancel_Buttons_on_EULA_screen() throws Throwable {
		
		String agreeButtonText = Eula_Page.btn_Eula_Accept.getText();
		String cancelButtonText = Eula_Page.btn_Eula_Cancel.getText();
		
		Assert.assertEquals(agreeButtonText, "Accept");
		Assert.assertEquals(cancelButtonText, "Cancel");
	}
	
	
	@Then("^I should be able to scroll down until the end of the EULA page$")
	public void i_should_be_able_to_scroll_down_until_the_end_of_the_EULA_page() throws Throwable {
		

		for(int i =0; i<5; i++)
		{
		MobileAppiumFunctions.verticalSwipeByPercentages(0.8, 0.01);
		}

	}
	
	@When("^I click on Cancel on EULA$")
	public void i_click_on_Cancel_on_EULA() throws Throwable {
		Eula_Page.btn_Eula_Cancel.click();

	}
	
	@When("^I click on Accept on EULA$")
	public void i_click_on_Accept_on_EULA() throws Throwable {
		Eula_Page.btn_Eula_Accept.click();

	}
   
	
	



}
