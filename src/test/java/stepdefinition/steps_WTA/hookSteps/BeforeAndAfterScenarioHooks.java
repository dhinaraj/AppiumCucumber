package stepdefinition.steps_WTA.hookSteps;

import base.genericLib_Mob.MobCommonFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfterScenarioHooks {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
	@Before("@InstallAppBeforeScenario")
    public void installAppBeforeScenario(){
		MobCommonFunctions.InstallApp();
    }	
	
	@After("@UninstallAppAfterScenario")
    public void uninstallAppAfterScenario(){
		MobCommonFunctions.UninstallApp();
    }
	
	@Before("@UninstallAppAndInstallApp")
    public void UninstallAppAndInstallAppBeforeScenario(){
		MobCommonFunctions.UninstallApp();
		MobCommonFunctions.InstallApp();
    }

}
