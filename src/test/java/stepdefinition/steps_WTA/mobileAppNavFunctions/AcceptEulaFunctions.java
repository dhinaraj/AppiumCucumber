package stepdefinition.steps_WTA.mobileAppNavFunctions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.CucumberHelperTestSteps;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class AcceptEulaFunctions {
	
	
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	Eula_Page Eula_Page = new Eula_Page();
	

	        public void AcceptEulaHook_BeforeFeatureHook()
	        {
	        	MobCommonFunctions.LaunchApp();
	            if (Eula_Page.btn_Eula_Accept.isDisplayed())
	            {
	                Eula_Page.btn_Eula_Accept.click();

	            }

	            MobCommonFunctions.CloseApp();


	        }
	        
	        public  void AcceptEulaHook_AfterFeatureHook()
	        {
	            MobCommonFunctions.LaunchApp();
	            if (Eula_Page.btn_Eula_Accept.isDisplayed())
	            {
	                Eula_Page.btn_Eula_Accept.click();

	            }

	            MobCommonFunctions.CloseApp();

	        }
	        
	        public  void AcceptEulaHook_BeforeScenarioHook()
	        {
	            MobCommonFunctions.LaunchApp();
	            if (Eula_Page.btn_Eula_Accept.isDisplayed())
	            {
	                Eula_Page.btn_Eula_Accept.click();

	            }

	            MobCommonFunctions.CloseApp();

	        }
	        
	        public  void AcceptEulaHook_AfterScenarioHook()
	        {
	            MobCommonFunctions.LaunchApp();
	            if (Eula_Page.btn_Eula_Accept.isDisplayed())
	            {
	                Eula_Page.btn_Eula_Accept.click();

	            }

	            MobCommonFunctions.CloseApp();

	        }

}
