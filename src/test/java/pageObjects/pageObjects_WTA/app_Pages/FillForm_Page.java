package pageObjects.pageObjects_WTA.app_Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;
import io.appium.java_client.ios.IOSElement;

public class FillForm_Page extends WTAPageObject {
	
	

	public MobileElement btn_FillForm_ByName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@iOSFindBy(xpath = "Dummy")
	public List<MobileElement> fld_FillForm_TextFieldList;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	@iOSFindBy(xpath = "Dummy")
	public List<MobileElement> fld_FillForm_ComboBoxList;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='FINISH']")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(., 'FINISH')]")
	public MobileElement btn_Finish;

	@AndroidFindBy(xpath = "//android.view.View[@text='Log Off']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_AlertDialog;

	@AndroidFindBy(xpath = "//android.view.View[@text='Form submitted successfully.']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement alert_FormSubmittedSucessfully;

	@AndroidFindBy(xpath = "//*[@resource-id='fillform']/android.view.View[2]/android.view.View")
	@iOSFindBy(xpath = "//*[@text='Save']")
	public MobileElement txt_NoFillFormsAvailable;

	@AndroidFindBy(xpath = "//*[@text='Save']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_SaveDraft;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='T1']")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	public MobileElement fld_Name_FWI;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='E1']")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	public MobileElement fld_Email_FWI;
	
	@AndroidFindBy(xpath = "//*[@LocalizedControlType='combo box']")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[following-sibling::*[@id='select']])[2]")
	public MobileElement fld_ComboBox_FWI;
	
	
	  public String Btn_SaveDraft_Xpath()
      {
          switch (GlobalSettings.getMobilePlatformToRunTest())
          {

              case "Windows":
                  return "";
              case "IOS":
                  return "";
              case "Android":
                  return "//*[@text='Save']";
              default:
                  return "";
          }
      }


      public void TapOnFillFormName(String FillFormName)
      {

          switch (GlobalSettings.getMobilePlatformToRunTest())
          {
              case "Windows":
                  btn_FillForm_ByName = MobProp.getMobDriver().findElementByName(FillFormName);
                  break;
              case "IOS":
                  btn_FillForm_ByName = MobProp.getMobDriver().findElementById(FillFormName);
                  break;
              case "Android":
                  btn_FillForm_ByName = MobProp.getMobDriver().findElementByXPath("//*[@text='"+FillFormName+"']");
                  break;
          }

          btn_FillForm_ByName.click();
      }


      public void SampleToClickOnAnElementUsingLocationAtrribute(String Name, String EmailID, String DOB)
      {
          fld_FillForm_TextFieldList.get(0).sendKeys(Name);
          fld_FillForm_TextFieldList.get(1).sendKeys(EmailID);
          fld_FillForm_TextFieldList.get(2).sendKeys(DOB);
          btn_Finish.click();

      }

      public void EnterFormInput(String Name, String EmailID, String DOB)
      {
          switch (GlobalSettings.getMobilePlatformToRunTest())
          {

              case "Windows":
                  fld_Name_FWI.clear();
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.clear();
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.clear();
                  fld_ComboBox_FWI.sendKeys(DOB);
                  break;
              case "IOS":
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.sendKeys(DOB);
                  MobProp.getMobDriver().findElementById("Done").click();
                  break;
              case "Android":
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.sendKeys(DOB);
                  break;
          }
          btn_Finish.click();
      }


      public void SubmitEmptyFillForm()
      {
         
    	  btn_Finish.click();
      }

      public void EditFormInput(String Name, String EmailID, String DOB)
      {
          switch (GlobalSettings.getMobilePlatformToRunTest())
          {

              case "Windows":
                  fld_Name_FWI.clear();
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.clear();
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.clear();
                  fld_ComboBox_FWI.sendKeys(DOB);
                  break;
              case "IOS":
                  fld_Name_FWI.click();
                  fld_Name_FWI.clear();
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.clear();
                  fld_Email_FWI.click();
                  fld_Email_FWI.clear();
                  fld_Email_FWI.click();
                  fld_ComboBox_FWI.clear();
                  fld_ComboBox_FWI.click();
                  fld_ComboBox_FWI.clear();
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.sendKeys(DOB);
                  MobProp.getMobDriver().findElementById("Done").click();
                  break;
              case "Android":
                  fld_Name_FWI.clear();
                  fld_Name_FWI.sendKeys(Name);
                  fld_Email_FWI.clear();
                  fld_Email_FWI.sendKeys(EmailID);
                  fld_ComboBox_FWI.clear();
                  fld_ComboBox_FWI.sendKeys(DOB);
                  break;
          }

      }

      public void VerifyFormInput(String name, String email, String date)
      {
          switch (GlobalSettings.getMobilePlatformToRunTest())
          {
              case "Windows":
                  windowsTextFieldContains(fld_Name_FWI, name);
                  windowsTextFieldContains(fld_Email_FWI, email);
                  windowsTextFieldContains(fld_ComboBox_FWI, date);
                  break;
              case "IOS":
              case "Android":
                  Assert.assertTrue(fld_Name_FWI.getText() == name);
                  Assert.assertTrue(fld_ComboBox_FWI.getText()== date);
                  Assert.assertTrue(fld_Email_FWI.getText() == email);
                  break;
          }
      }

      public void windowsTextFieldContains(MobileElement element, String expected)
      {
          String text = element.getText().replaceAll("\r\n", "");
          Assert.assertTrue(text == expected);
      }


}
