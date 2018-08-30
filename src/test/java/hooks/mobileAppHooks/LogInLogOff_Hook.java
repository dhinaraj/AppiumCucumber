package hooks.mobileAppHooks;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobileAppiumFunctions;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class LogInLogOff_Hook {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	LogOff_In_Page LogOff_In_Page = new LogOff_In_Page();
	MenuNav_Page MenuNav_Page = new MenuNav_Page();
	
	
	 public  void LogIn_BeforeFeatureHook()
     {
         try
         {
             MobCommonFunctions.LaunchApp();
             if (LogOff_In_Page.CheckIfAccountLoggedOff())
             {
                 LogOff_In_Page.LogIn(GlobalSettings.getUserName(), GlobalSettings.getPassword());
                 MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 30);

             }

             MobCommonFunctions.CloseApp();
         }
         catch (Exception e)
         {


         }


     }
	 
	 
	 public  void LogIn_AfterFeatureHook()
     {
         try
         {
             MobCommonFunctions.LaunchApp();
             if (LogOff_In_Page.CheckIfAccountLoggedOff())
             {
                 LogOff_In_Page.LogIn(GlobalSettings.getUserName(), GlobalSettings.getPassword());
                 MobileAppiumFunctions.waituntilElementIsVisible(MenuNav_Page.btn_HamBurgerMenu, 30);

             }

             MobCommonFunctions.CloseApp();
         }
         catch (Exception e)
         {


         }

     }

}
