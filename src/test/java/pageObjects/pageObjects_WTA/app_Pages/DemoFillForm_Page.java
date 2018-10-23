package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class DemoFillForm_Page extends WTAPageObject {
	
	FillForm_Page FillForm_Page = new FillForm_Page();
	
	@AndroidFindBy(id = "N1")
	@iOSFindBy(xpath = "xpath=((//XCUIElementTypeOther)[22])")
	public MobileElement txt_Number;
	
	@AndroidFindBy(xpath = "//*[@resource-id='T2']")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	public MobileElement txt_SystemStatus;
	
	@AndroidFindBy(xpath = "//*[@resource-id='T3']")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	public MobileElement txt_CostCenter;
	
	@AndroidFindBy(xpath = "//*[@text='SUBMIT']")
	@iOSFindBy(id = "SUBMIT")
	public MobileElement btn_Save;
	
	
    public MobileElement Radio_Priority(String priorityName)
    {
            switch (GlobalSettings.getMobilePlatformToRunTest())
            {
                case "Windows":
                    return MobProp.getMobDriver().findElementByXPath("//*[contains(@Name, '"+ priorityName +"')]");
                case "IOS":
                    return MobProp.getMobDriver().findElementByXPath("//*[@text='"+ priorityName +"']");
                case "Android":
                    return MobProp.getMobDriver().findElementByXPath("//*[@text='"+ priorityName +"]");
                default:
                    return null;
            }
    }
    
    
    public MobileElement Dropdown_Type(String initialTypeValue)
    {

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return MobProp.getMobDriver().findElementByXPath("//*[contains(@Name, '"+ initialTypeValue +"')]");
            case "IOS":
                return MobProp.getMobDriver().findElementByXPath("//*[contains(text(), '"+ initialTypeValue +"')]");
            case "Android":
                return MobProp.getMobDriver().findElementByXPath("//*[contains(@text, '"+ initialTypeValue +"')]");
            default:
                return null;
        }
    }
    
    public MobileElement  Dropdown_Type()
    {
    	MobileElement element = Dropdown_Type("G1");
    	return element;
    }
    
    
    public void Set_Dropdown_Type(String typeValue, String initialTypeValue)
    {
    	MobileElement element = Dropdown_Type(initialTypeValue);
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                element.sendKeys(typeValue);
                break;
            case "IOS":
                element.click();
                MobileElement dropdownList = MobProp.getMobDriver().findElementByXPath("//*[@class='UIAPickerWheel']");
                dropdownList.sendKeys(typeValue);
                break;
            case "Android":
                element.click();
                MobProp.getMobDriver().findElementByXPath("//*[@text='"+ typeValue +"']").click();
                break;
        }
    }
    
    public void Set_Dropdown_Type(String typeValue)
    {
    	Set_Dropdown_Type(typeValue, "G1");
    }
    
    public MobileElement Dropdown_AssetLocation(String assetValue)
    {

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                return MobProp.getMobDriver().findElementByXPath("//*[@Name='Select']");
            case "IOS":
                MobProp.getMobDriver().findElementByXPath("//*[text()='Select']").click();
                return MobProp.getMobDriver().findElementByXPath("//*[@class='UIAPickerWheel']");
            case "Android":
                MobProp.getMobDriver().findElementByXPath("//*[@text='Select']").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                return MobProp.getMobDriver().findElementByXPath("//*[@text='"+ assetValue +"']");
            default:
                return null;
        }
    }
    
    public MobileElement Dropdown_AssetLocation()
    {
    	MobileElement element = Dropdown_AssetLocation("Dummy");
    	return element;
    }
		
    public void FillForm(String type, String number, String systemStatus, String priority, String costCenter, String assetLocation, String breakdown)
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                Set_Dropdown_Type(type);
                txt_Number.sendKeys(number);
                txt_SystemStatus.sendKeys(systemStatus);
                Radio_Priority(priority).click();
                txt_CostCenter.sendKeys(costCenter);
                Dropdown_AssetLocation().sendKeys(assetLocation);
                break;
            case "IOS":
                Set_Dropdown_Type(type);
                MobProp.getMobDriver().findElementById("Done").click();
                MobProp.getMobDriver().findElementByXPath("//*[@text='Increase Value']").click();
                MobProp.getMobDriver().findElementByXPath("//*[@text='Decrease Value']").click();
                txt_Number.sendKeys(number);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                txt_SystemStatus.sendKeys(systemStatus);
                Radio_Priority(priority).click();
                txt_CostCenter.sendKeys(costCenter);
                MobProp.getMobDriver().findElementById("Done").click();
                MobileAppiumFunctions.swipe(200, 600, 200, 300, 1000);
                Dropdown_AssetLocation().sendKeys(assetLocation);
                MobProp.getMobDriver().findElementById("Done").click();
                break;
            case "Android":
                Set_Dropdown_Type(type);
                int num = Integer.parseInt(number);
                String valueChange = "";
                if(num > 0)
                {
                    valueChange = "Increase";
                }
                else if (num < 0)
                {
                    valueChange = "Decrease";
                    num *= -1;
                }
                
                for (int i = 0; i < num; i++)
                {
                    MobProp.getMobDriver().findElementByXPath("//*[contains(@text,'" + valueChange+" Value')]").click();
                }

                txt_SystemStatus.sendKeys(systemStatus);
                MobileAppiumFunctions.swipe(200, 800, 200, 0, 1000);
                Radio_Priority(priority).click();
                txt_CostCenter.sendKeys(costCenter);
                Dropdown_AssetLocation(assetLocation).click();
                break;
        }
    }
    
    public void VerifyFormInput(String type, String status)
    {
        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Windows":
                FillForm_Page.windowsTextFieldContains(Dropdown_Type(type), type);
                FillForm_Page.windowsTextFieldContains(txt_SystemStatus, status);
                break;
            case "IOS":
                Assert.assertEquals(Dropdown_Type(type).getText(), type);
                Assert.assertEquals(txt_SystemStatus.getText() , status);
                break;
            case "Android":
                Assert.assertNotNull(Dropdown_Type(type));
                Assert.assertEquals(txt_SystemStatus.getText() , status);
                break;
        }
    }


    

}
