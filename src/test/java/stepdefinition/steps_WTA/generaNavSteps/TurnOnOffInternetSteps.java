package stepdefinition.steps_WTA.generaNavSteps;

import cucumber.api.java.en.Then;
import stepdefinition.steps_WTA.mobileAppNavFunctions.*;

public class TurnOnOffInternetSteps {
	

	TurnOnOrOff_InternetFunctions TurnOnOrOff_InternetHook = new TurnOnOrOff_InternetFunctions();
	
	@Then("^Trun on internet before feature$")
	public void trun_on_internet_before_feature() throws Throwable {
		
		TurnOnOrOff_InternetHook.TurnONInternet_BeforeFeatureHook();

	}


}
