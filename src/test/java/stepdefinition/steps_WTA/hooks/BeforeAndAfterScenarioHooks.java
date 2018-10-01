package stepdefinition.steps_WTA.hooks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.CucumberHelperTestSteps;
import main.*;

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
	
	@Before(order = 0)
	public static void before( Scenario scenario) {
	    CucumberHelperTestSteps.scenario = scenario;
	}
	
	@After(order = 0)
	public void afterScenario(Scenario scenario) {
		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
		{
		//if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll("\\s", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath =  ((TakesScreenshot) MobProp.getMobDriver()).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(CucumberRunner.cucumberAbsoluteReportPath +"/screenshots/"+ screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath("../" + CucumberRunner.cucumberRelativeReportPath +"/screenshots/" + screenshotName + ".png");
			} catch (IOException e) {
			//} 
			}
		}
	}

}
