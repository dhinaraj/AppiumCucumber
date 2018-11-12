package stepdefinition.steps_WTA.generaNavSteps;

import base.genericLib_Mob.MobCommonFunctions;
import cucumber.api.java.en.Then;


public class TurnOnOffInternetSteps {
	

	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
	@Then("^Trun on internet before feature$")
	public void trun_on_internet_before_feature() throws Throwable {
		
        try
        {
            MobCommonFunctions.SwitchToOnlineMode();
        }
        catch (Exception e)
        {


        }

	}


}
