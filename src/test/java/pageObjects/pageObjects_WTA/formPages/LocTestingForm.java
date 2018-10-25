package pageObjects.pageObjects_WTA.formPages;


import io.appium.java_client.MobileElement;
import java.util.List;
import org.testng.Assert;
import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Mob.MobileAppiumFunctions;
import io.appium.java_client.pagefactory.*;
import pageObjects.pageObjects_WTA.WTAPageObject;


public class LocTestingForm extends WTAPageObject {
	
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	public MobileElement fld_Name;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	public MobileElement fld_Email;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
	@iOSFindBy(xpath = "(//XCUIElementTypeOther[following-sibling::*[@id='select']])[2]")
	public MobileElement fld_DOB;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Finish']")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(., 'Finish')]")
	public MobileElement btn_Finish;
	
	@AndroidFindBy(xpath = "//*[@text='Save']")
	@iOSFindBy(xpath = "Dummy")
	public MobileElement btn_SaveDraft;
	
      public void EnterFormInput(String Name, String EmailID, String DOB)
      {
          fld_Name.sendKeys(Name);
          fld_Email.sendKeys(EmailID);
          fld_DOB.sendKeys(DOB);
      }




      public void EditFormInputAndSubmit(String Name, String EmailID, String DOB)
      {
          fld_Name.clear();
          fld_Name.sendKeys(Name);
          fld_Email.clear();
          fld_Email.sendKeys(EmailID);
          fld_DOB.clear();
          fld_DOB.sendKeys(DOB);
          btn_Finish.click();

      }

      public void VerifyFormInput(String name, String email, String date)
      {

	      Assert.assertTrue(fld_Name.getText() == name);
	      Assert.assertTrue(fld_DOB.getText()== date);
	      Assert.assertTrue(fld_Email.getText() == email);

      }



}
