package hooks.mobileAppHooks;

import base.genericLib_Mob.MobCommonFunctions;

public class ChangeDeviceLangHook {
	
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
