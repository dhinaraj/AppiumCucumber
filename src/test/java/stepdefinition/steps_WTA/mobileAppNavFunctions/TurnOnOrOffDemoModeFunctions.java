package stepdefinition.steps_WTA.mobileAppNavFunctions;

import base.genericLib_Mob.MobCommonFunctions;
import pageObjects.pageObjects_WTA.app_Pages.Account_Settings_Page;

public class TurnOnOrOffDemoModeFunctions {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
	
    public  void ConfigureAccountIfNotConfiguredAlready()
    {
        try
        {
            MobCommonFunctions.LaunchApp();
            Account_Settings_Page.TurnONDemoMode();
            MobCommonFunctions.CloseApp();
        }
        catch (Exception e)
        {


        }

    }
    
    
    public  void ConfigureAccountIfNotConfiguredAlreadyAfterFeature()
    {
        try
        {
            MobCommonFunctions.LaunchApp();
            Account_Settings_Page.TurnONDemoMode();
            MobCommonFunctions.CloseApp();
        }
        catch (Exception e)
        {


        }

    }

}
