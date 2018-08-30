package hooks.mobileAppHooks;

import base.genericLib_Mob.MobCommonFunctions;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class AcceptEulaHook {
	
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
