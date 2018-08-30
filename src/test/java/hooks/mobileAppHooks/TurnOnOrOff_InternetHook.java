package hooks.mobileAppHooks;

import base.genericLib_Mob.MobCommonFunctions;

public class TurnOnOrOff_InternetHook {
	
	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	
    public  void TurnONInternet_BeforeFeatureHook()
    {

        try
        {
            MobCommonFunctions.SwitchToOnlineMode();
        }
        catch (Exception e)
        {


        }
    }
    
    public  void TurnONInternet_AfterFeatureHook()
    {

        try
        {
            MobCommonFunctions.SwitchToOnlineMode();
        }
        catch (Exception e)
        {


        }
    }
    
    
    public  void TurnOffInternet_AfterScenarioHook()
    {
        try
        {
            MobCommonFunctions.SwitchToOfflineMode();
        }
        catch (Exception e)
        {


        }

    }

}
