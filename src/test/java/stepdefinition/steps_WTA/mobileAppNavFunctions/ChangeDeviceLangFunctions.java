package stepdefinition.steps_WTA.mobileAppNavFunctions;

import base.genericLib_Mob.MobCommonFunctions;

public class ChangeDeviceLangFunctions {
	
	MobCommonFunctions MobCommonFunctions =  new MobCommonFunctions();
	
	
	public  void ChangeDeviceLangToEng_Hook()
    {
        try
        {
            MobCommonFunctions.changeDeviceLanguage("en" , "US");
        }
        catch (Exception e)
        {


        }

    }
	
	

}
