package stepdefinition.steps_WTA.hookSteps;

import cucumber.api.java.en.Then;
import hooks.mobileAppHooks.*;

public class WTAHookSteps {
	
	TurnOnOrOff_InternetHook TurnOnOrOff_InternetHook = new TurnOnOrOff_InternetHook();
	
	@Then("^Trun on internet before feature$")
	public void trun_on_internet_before_feature() throws Throwable {
		
		TurnOnOrOff_InternetHook.TurnONInternet_BeforeFeatureHook();

	}

}
