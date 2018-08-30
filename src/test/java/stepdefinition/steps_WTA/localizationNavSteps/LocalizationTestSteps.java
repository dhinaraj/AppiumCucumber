package stepdefinition.steps_WTA.localizationNavSteps;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobileAppiumFunctions;
import base.helpers.excelHelpers.ExcelHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.pageObjects_WTA.app_Pages.*;
import pageObjects.pageObjects_WTA.localization_Pages.Loc_Account_Settings_Page;

import com.vimalselvam.cucumber.listener.*;

public class LocalizationTestSteps {
	


	private static String baseDirectory = "C:\\Users\\sesa473389\\Source\\Repos\\AppiumCucumber\\src\\test\\java\\base\\dataFiles\\";

    private String LocalizationDataSourceFile = baseDirectory+ "Localization.xlsx";
   
    
    MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
    
    Loc_Account_Settings_Page Loc_Account_Settings_Page = new Loc_Account_Settings_Page();
    About_Page About_Page = new About_Page();
    Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();
    ApproveWorkItemPage ApproveWorkItemPage = new ApproveWorkItemPage();
    AppSettings_Page AppSettings_Page = new AppSettings_Page();
    Dashboard_Page Dashboard_Page = new Dashboard_Page();
    DemoFillForm_Page DemoFillForm_Page = new DemoFillForm_Page();
    Dialogs_Page Dialogs_Page = new Dialogs_Page();
    Drafts_Page Drafts_Page = new Drafts_Page();
    Eula_Page Eula_Page = new Eula_Page();
    FillForm_Page FillForm_Page = new FillForm_Page();
    Inbox_Page Inbox_Page = new Inbox_Page();
    InformationWorkItemPage InformationWorkItemPage = new InformationWorkItemPage();
    InitialLoadingPage InitialLoadingPage = new InitialLoadingPage();
    LogOff_In_Page LogOff_In_Page = new LogOff_In_Page();
    MenuNav_Page MenuNav_Page = new MenuNav_Page();
    Outbox_Page Outbox_Page = new Outbox_Page();
    OverFlowIcon_Page OverFlowIcon_Page = new OverFlowIcon_Page();
    SentItems_Page SentItems_Page = new SentItems_Page();

/*   @Then("^^Validate the Localization key on Account Settings Page for 'Demo Mode', 'Server Path','Repository', 'Provider', 'User Name', 'Password', 'Show Password', 'Logon'$")
    public void validate_the_Localization_key_on_Account_Settings_Page_for_Demo_Mode_Server_Path_Repository_Provider_User_Name_Password_Show_Password_Logon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/
    
    @Then("^^Validate the Localization key on Account Settings Page for '(.*)', '(.*)','(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)'$")
    public void GivenThernValidateTheLocalizationKeyOnAccountSettingsPageFor(String DemoMode, String ServerPath, String Repository, String Provider, String UserName, String Password, String ShowPassword, String Logon) throws Throwable
    {
       
    	
    	Map<String, String> DemoModeDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", DemoMode);
        Map<String, String> ServerPathDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ServerPath);
        Map<String, String> RepositoryDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Repository);
        Map<String, String> ProviderDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Provider);
        Map<String, String> UserNameDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", UserName);
        Map<String, String> PasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Password);
        Map<String, String> ShowPasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ShowPassword);
        Map<String, String> LogonDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Logon);

        boolean OverAllTestResult = true;
        
        for ( String key : DemoModeDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	DemoModeDic.get(Language);
        	Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(DemoMode + "TranslatedString", DemoModeDic.get(Language));
            ExpectedTranslatedStrings.put(ServerPath + "TranslatedString", ServerPathDic.get(Language));
            ExpectedTranslatedStrings.put(Repository + "TranslatedString", RepositoryDic.get(Language));
            ExpectedTranslatedStrings.put(Provider + "TranslatedString", ProviderDic.get(Language));
            ExpectedTranslatedStrings.put(UserName + "TranslatedString", UserNameDic.get(Language));
            ExpectedTranslatedStrings.put(Password + "TranslatedString", PasswordDic.get(Language));
            ExpectedTranslatedStrings.put(ShowPassword + "TranslatedString", ShowPasswordDic.get(Language));
            ExpectedTranslatedStrings.put(Logon + "TranslatedString", LogonDic.get(Language));
            
            
            //Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            MobileAppiumFunctions.waituntilElementExists(Loc_Account_Settings_Page.Txt_ServerPathXpath(), 20);

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(DemoMode + "TranslatedString", Loc_Account_Settings_Page.switch_DemoMode.getText());
            ActualTranslatedStrings.put(ServerPath + "TranslatedString", Loc_Account_Settings_Page.txt_ServerPath.get(0).getText());
            ActualTranslatedStrings.put(Repository + "TranslatedString", Loc_Account_Settings_Page.dropdown_Repository.get(0).getText());
            ActualTranslatedStrings.put(Provider + "TranslatedString", Loc_Account_Settings_Page.dropdown_Provider.get(1).getText());
            ActualTranslatedStrings.put(UserName + "TranslatedString", Loc_Account_Settings_Page.txt_Username.get(1).getText());
            ActualTranslatedStrings.put(Password + "TranslatedString", Loc_Account_Settings_Page.txt_Password.get(2).getText());
            ActualTranslatedStrings.put(ShowPassword + "TranslatedString", Loc_Account_Settings_Page.chk_ShowPassword.getText());
            ActualTranslatedStrings.put(Logon + "TranslatedString", Loc_Account_Settings_Page.btn_LogOn.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() ) {

                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);
                
                

                if (ExpectedString.equals(ActualString))
                {
                	
                	Reporter.addStepLog("Expected String: " + ExpectedString + "-----" + "Actual String: " + ActualString);


                }
                else
                {

                	Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString + "-----" + "Actual String: " + ActualString);
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        //Assert.assertEquals(OverAllTestResult, true, "Test Failed as some expected Strings were not matching, please check report");
    }
        


    @Given("^Validate the Localization key on Account Settings Page_ExistingConfiguration for '(.*)','(.*)', '(.*)', '(.*)', '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnAccountSettingsPage_ExistingConfigurationFor(String ServerPath, String Repository, String Provider, String UserName, String Password, String ShowPassword) throws Exception
    {

        Map<String, String> ServerPathDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ServerPath);
        Map<String, String> RepositoryDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Repository);
        Map<String, String> ProviderDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Provider);
        Map<String, String> UserNameDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", UserName);
        Map<String, String> PasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Password);
        Map<String, String> ShowPasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ShowPassword);

        boolean OverAllTestResult = true;
        
        for ( String key : ServerPathDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	ServerPathDic.get(Language);
        	
            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(ServerPath + "TranslatedString", ServerPathDic.get(Language));
            ExpectedTranslatedStrings.put(Repository + "TranslatedString", RepositoryDic.get(Language));
            ExpectedTranslatedStrings.put(Provider + "TranslatedString", ProviderDic.get(Language));
            ExpectedTranslatedStrings.put(UserName + "TranslatedString", UserNameDic.get(Language));
            ExpectedTranslatedStrings.put(Password + "TranslatedString", PasswordDic.get(Language));
            ExpectedTranslatedStrings.put(ShowPassword + "TranslatedString", ShowPasswordDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemFlagDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AccountSettings.get(0).click();


            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(ServerPath + "TranslatedString", Loc_Account_Settings_Page.txt_Selected_ServerPath.getText());
            ActualTranslatedStrings.put(Repository + "TranslatedString", Loc_Account_Settings_Page.dropdown_Selected_Repository.getText());
            ActualTranslatedStrings.put(Provider + "TranslatedString", Loc_Account_Settings_Page.dropdown_Selected_Provider.getText());
            ActualTranslatedStrings.put(UserName + "TranslatedString", Loc_Account_Settings_Page.txt_Selected_Username.getText());
            ActualTranslatedStrings.put(Password + "TranslatedString", Loc_Account_Settings_Page.txt_Selected_Password.getText());
            ActualTranslatedStrings.put(ShowPassword + "TranslatedString", Loc_Account_Settings_Page.chk_ShowPassword.getText());



            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() ) {
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);
                

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));

                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }
   }




    @Given("Validate the Localization key on Menu Navigation page for '(.*)','(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnMenuNavigationPageFor(String Inbox, String FillForm, String Drafts, String SentItems, String Outbox, String Sync, String ManageAccount, String Settings, String Help, String LogOff) throws Exception
    {
        Map<String, String> InboxDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Inbox);
        Map<String, String> FillFormDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", FillForm);
        Map<String, String> DraftsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Drafts);
        Map<String, String> SentItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", SentItems);
        Map<String, String> OutboxDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Outbox);
        Map<String, String> SyncDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Sync);
        Map<String, String> ManageAccountDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", ManageAccount);
        Map<String, String> SettingsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Settings);
        Map<String, String> HelpDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", Help);
        Map<String, String> LogOffDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "MenuNav", LogOff);

        boolean OverAllTestResult = true;

        for ( String key : InboxDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	InboxDic.get(Language);
        	
        	
            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Inbox + "TranslatedString", InboxDic.get(Language));
            ExpectedTranslatedStrings.put(FillForm + "TranslatedString", FillFormDic.get(Language));
            ExpectedTranslatedStrings.put(Drafts + "TranslatedString", DraftsDic.get(Language));
            ExpectedTranslatedStrings.put(SentItems + "TranslatedString", SentItemsDic.get(Language));
            ExpectedTranslatedStrings.put(Outbox + "TranslatedString", OutboxDic.get(Language));
            ExpectedTranslatedStrings.put(Sync + "TranslatedString", SyncDic.get(Language));
            ExpectedTranslatedStrings.put(ManageAccount + "TranslatedString", ManageAccountDic.get(Language));
            ExpectedTranslatedStrings.put(Settings + "TranslatedString", SettingsDic.get(Language));
            ExpectedTranslatedStrings.put(Help + "TranslatedString", HelpDic.get(Language));
            ExpectedTranslatedStrings.put(LogOff + "TranslatedString", LogOffDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(Inbox + "TranslatedString", MenuNav_Page.btn_Inbox.getText());
            ActualTranslatedStrings.put(FillForm + "TranslatedString", MenuNav_Page.btn_FillForm.getText());
            ActualTranslatedStrings.put(Drafts + "TranslatedString", MenuNav_Page.btn_Drafts.getText());
            ActualTranslatedStrings.put(SentItems + "TranslatedString", MenuNav_Page.btn_SentItems.getText());
            ActualTranslatedStrings.put(Outbox + "TranslatedString", MenuNav_Page.btn_Outbox.getText());
            ActualTranslatedStrings.put(Sync + "TranslatedString", MenuNav_Page.btn_Sync.getText());
            ActualTranslatedStrings.put(ManageAccount + "TranslatedString", MenuNav_Page.btn_AccountSettings.get(0).getText());
            ActualTranslatedStrings.put(Settings + "TranslatedString", MenuNav_Page.btn_AppSettings.getText());
            ActualTranslatedStrings.put(Help + "TranslatedString", MenuNav_Page.btn_Help.getText());
            ActualTranslatedStrings.put(LogOff + "TranslatedString", MenuNav_Page.btn_LogOff.getText());


            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() ) 
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Given("Validate the Localization key on Work Item Category Fiter for '(.*)','(.*)', '(.*)', '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnOnWorkItemCategoryFiter(String AllItems, String Approval, String Flagged, String Information, String InvokeFormItem) throws Exception
    {

        Map<String, String> AllItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItemFilter", AllItems);
        Map<String, String> ApprovalDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItemFilter", Approval);
        Map<String, String> FlaggedDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItemFilter", Flagged);
        Map<String, String> InformationDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItemFilter", Information);
        Map<String, String> InvokeFormItemDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItemFilter", InvokeFormItem);
        

        boolean OverAllTestResult = true;

        for ( String key : AllItemsDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	AllItemsDic.get(Language);
        	

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(AllItems + "TranslatedString", AllItemsDic.get(Language));
            ExpectedTranslatedStrings.put(Approval + "TranslatedString", ApprovalDic.get(Language));
            ExpectedTranslatedStrings.put(Flagged + "TranslatedString", FlaggedDic.get(Language));
            ExpectedTranslatedStrings.put(Information + "TranslatedString", InformationDic.get(Language));
            ExpectedTranslatedStrings.put(InvokeFormItem + "TranslatedString", InvokeFormItemDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_Inbox_Dropdown.click();
            

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(AllItems + "TranslatedString", MenuNav_Page.btn_AllItems.getText());
            ActualTranslatedStrings.put(Approval + "TranslatedString", MenuNav_Page.btn_Approval.getText());
            ActualTranslatedStrings.put(Flagged + "TranslatedString", MenuNav_Page.btn_Flagged.getText());
            ActualTranslatedStrings.put(Information + "TranslatedString", MenuNav_Page.btn_Information.getText());
            ActualTranslatedStrings.put(InvokeFormItem + "TranslatedString", MenuNav_Page.btn_InvokeForm.getText());


            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Given("Validate the Localization key on About Page for '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnAboutPageFor(String About, String AppName, String Version, String Copyright, String PrivacyPolicy, String ViewOnline, String TechnicalSupport, String ContactUs) throws Exception
    {
        Map<String, String> AboutDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", About);
        Map<String, String> AppNameDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", AppName);
        Map<String, String> VersionDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Version);
        Map<String, String> CopyrightDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Copyright);
        Map<String, String> PrivacyPolicyDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", PrivacyPolicy);
        Map<String, String> ViewOnlineDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ViewOnline);
        Map<String, String> TechnicalSupportDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", TechnicalSupport);
        Map<String, String> ContactUsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ContactUs);


        boolean OverAllTestResult = true;

        for ( String key : AboutDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	AboutDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(About + "TranslatedString", AboutDic.get(Language));
            ExpectedTranslatedStrings.put(AppName + "TranslatedString", AppNameDic.get(Language));
            ExpectedTranslatedStrings.put(Version + "TranslatedString", VersionDic.get(Language));
            ExpectedTranslatedStrings.put(Copyright + "TranslatedString", CopyrightDic.get(Language));
            ExpectedTranslatedStrings.put(PrivacyPolicy + "TranslatedString", PrivacyPolicyDic.get(Language));
            ExpectedTranslatedStrings.put(ViewOnline + "TranslatedString", ViewOnlineDic.get(Language));
            ExpectedTranslatedStrings.put(TechnicalSupport + "TranslatedString", TechnicalSupportDic.get(Language));
            ExpectedTranslatedStrings.put(ContactUs + "TranslatedString", ContactUsDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AccountSettings.get(0).click();
            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(1000);
            OverFlowIcon_Page.btn_OverFlowAbout.click();
            sleep(1000);


            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(About + "TranslatedString", About_Page.txt_About.getText());
            ActualTranslatedStrings.put(AppName + "TranslatedString", About_Page.txt_AppName.getText());
            ActualTranslatedStrings.put(Version + "TranslatedString", About_Page.txt_Version.getText().split(" ")[0]);
            ActualTranslatedStrings.put(Copyright + "TranslatedString", About_Page.txt_CopyRight.getText());
            ActualTranslatedStrings.put(PrivacyPolicy + "TranslatedString", About_Page.txt_PrivacyPolicy.getText());
            ActualTranslatedStrings.put(ViewOnline + "TranslatedString", About_Page.txt_ViewOnline.getText());
            ActualTranslatedStrings.put(TechnicalSupport + "TranslatedString", About_Page.txt_TechinicalSupport.getText());
            ActualTranslatedStrings.put(ContactUs + "TranslatedString", About_Page.txt_Contact.getText());


            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Given("Validate the Localization key on Manage Account Overflow Icon for '(.*)' , '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnManageAccountOverflowIconFor(String DeleteAccount, String Help, String About) throws Exception
    {
        Map<String, String> DeleteAccountDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", DeleteAccount);
        Map<String, String> HelpDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Help);
        Map<String, String> AboutDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", About);


        boolean OverAllTestResult = true;

        for ( String key : DeleteAccountDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	DeleteAccountDic.get(Language);
        	
            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(DeleteAccount + "TranslatedString", DeleteAccountDic.get(Language));
            ExpectedTranslatedStrings.put(Help + "TranslatedString", HelpDic.get(Language));
            ExpectedTranslatedStrings.put(About + "TranslatedString", AboutDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AccountSettings.get(0).click();
            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(1000);



            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(DeleteAccount + "TranslatedString", OverFlowIcon_Page.btn_OverFlowDeleteAccount.getText());
            ActualTranslatedStrings.put(Help + "TranslatedString", OverFlowIcon_Page.btn_OverFlowHelp.getText());
            ActualTranslatedStrings.put(About + "TranslatedString", OverFlowIcon_Page.btn_OverFlowAbout.getText());



            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Given("Validate the Localization key on clear account settings Warning for '(.*)' , '(.*)', '(.*)', '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnDeleteAccountWarningFor(String DeleteAccount, String DeleteAccountWarning, String OK, String Cancel) throws Exception
    {
        Map<String, String> DeleteAccountDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", DeleteAccount);
        Map<String, String> DeleteAccountWarningDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", DeleteAccountWarning);
        Map<String, String> OKDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", OK);
        Map<String, String> CancelDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", Cancel);


        boolean OverAllTestResult = true;


        for ( String key : DeleteAccountDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	DeleteAccountDic.get(Language);
        	
            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(DeleteAccount + "TranslatedString", DeleteAccountDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteAccountWarning + "TranslatedString", DeleteAccountWarningDic.get(Language));
            ExpectedTranslatedStrings.put(OK + "TranslatedString", OKDic.get(Language));
            ExpectedTranslatedStrings.put(Cancel + "TranslatedString", CancelDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AccountSettings.get(0).click();
            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();
            sleep(1000);
            OverFlowIcon_Page.btn_OverFlowDeleteAccount.click();
            sleep(1000);



            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(DeleteAccount + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(DeleteAccountWarning + "TranslatedString", Dialogs_Page.text_DialogError.getText());
            ActualTranslatedStrings.put(OK + "TranslatedString", Dialogs_Page.btn_DialogOK.getText());
            ActualTranslatedStrings.put(Cancel + "TranslatedString", Dialogs_Page.btn_Cancel.getText());



            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Given("Validate the Localization key on App Settings Page for '(.*)', '(.*)' , '(.*)' , '(.*)' , '(.*)' '(.*)', '(.*)', '(.*)', '(.*)' '(.*)'$")
    public void GivenValidateTheLocalizationKeyOnAppSettingsPageFor(String SettingsText, String LoggingListButton, String SyncListButton, String LoggingText, String SyncText, String Level, String Error, String Warning, String Information, String ItemsToSyncDataAndLookUp) throws Exception
    {
        Map<String, String> SettingsTextDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", SettingsText);
        Map<String, String> LoggingListButtonDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", LoggingListButton);
        Map<String, String> SyncListButtonDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", SyncListButton);
        Map<String, String> LoggingTextDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", LoggingText);
        Map<String, String> SyncTextDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", SyncText);
        Map<String, String> LevelDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", Level);
        Map<String, String> ErrorDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", Error);
        Map<String, String> WarningDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", Warning);
        Map<String, String> InformationDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", Information);
        Map<String, String> ItemsToSyncDataAndLookUpDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile + LocalizationDataSourceFile, "AppSettingsPage", ItemsToSyncDataAndLookUp);


        boolean OverAllTestResult = true;

        for ( String key : SettingsTextDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	SettingsTextDic.get(Language);
        	
            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(SettingsText + "TranslatedString", SettingsTextDic.get(Language));
            ExpectedTranslatedStrings.put(LoggingListButton + "TranslatedString", LoggingListButtonDic.get(Language));
            ExpectedTranslatedStrings.put(SyncListButton + "TranslatedString", SyncListButtonDic.get(Language));
            ExpectedTranslatedStrings.put(LoggingText + "TranslatedString", LoggingTextDic.get(Language));
            ExpectedTranslatedStrings.put(SyncText + "TranslatedString", SyncTextDic.get(Language));
            ExpectedTranslatedStrings.put(Level + "TranslatedString", LevelDic.get(Language));
            ExpectedTranslatedStrings.put(Error + "TranslatedString", ErrorDic.get(Language));
            ExpectedTranslatedStrings.put(Warning + "TranslatedString", WarningDic.get(Language));
            ExpectedTranslatedStrings.put(Information + "TranslatedString", InformationDic.get(Language));
            ExpectedTranslatedStrings.put(ItemsToSyncDataAndLookUp + "TranslatedString", ItemsToSyncDataAndLookUpDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_AppSettings.click();
            sleep(1000);




            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(SettingsText + "TranslatedString", AppSettings_Page.txt_Settings.getText());
            ActualTranslatedStrings.put(LoggingListButton + "TranslatedString", AppSettings_Page.btn_Logging.getText());
            ActualTranslatedStrings.put(SyncListButton + "TranslatedString", AppSettings_Page.btn_Sync.getText());


            //Navigate to Logging Page
            AppSettings_Page.btn_Logging.click();
            sleep(1000);

            ActualTranslatedStrings.put(LoggingText + "TranslatedString", AppSettings_Page.txt_Logging.getText());
            ActualTranslatedStrings.put(Level + "TranslatedString", AppSettings_Page.txt_Level.getText());
            ActualTranslatedStrings.put(Error + "TranslatedString", AppSettings_Page.txt_Error.getText());
            ActualTranslatedStrings.put(Warning + "TranslatedString", AppSettings_Page.txt_Warning.getText());
            ActualTranslatedStrings.put(Information + "TranslatedString", AppSettings_Page.txt_Information.getText());

            //Navigate to Sync Page
            MenuNav_Page.btn_Back.click();
            AppSettings_Page.btn_Sync.click();
            sleep(1000);

            ActualTranslatedStrings.put(SyncText + "TranslatedString", AppSettings_Page.txt_Sync.getText());
            ActualTranslatedStrings.put(ItemsToSyncDataAndLookUp + "TranslatedString", AppSettings_Page.txt_ItemsToSyncForLookupAndData.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Then("^Validate the Localization key on Approval Work Item Page for '(.*)', '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnApprovalWorkItemPageFor(String Approve, String Reject, String CommentPlaceholder, String ApproveConfirmMessage, String ApproveSuccessMessage, String RejectConfirmMessage, String RejectSuccessMessage) throws Exception
    {
        Map<String, String> ApproveDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", Approve);
        Map<String, String> RejectDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", Reject);
        Map<String, String> CommentPlaceholderDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", CommentPlaceholder);
        Map<String, String> ApproveConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", ApproveConfirmMessage);
        Map<String, String> ApproveSuccessMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", ApproveSuccessMessage);
        Map<String, String> RejectConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", RejectConfirmMessage);
        Map<String, String> RejectSuccessMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", RejectSuccessMessage);



        boolean OverAllTestResult = true;

        for ( String key : ApproveDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	ApproveDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Approve + "TranslatedString", ApproveDic.get(Language));
            ExpectedTranslatedStrings.put(Reject + "TranslatedString", RejectDic.get(Language));
            ExpectedTranslatedStrings.put(CommentPlaceholder + "TranslatedString", CommentPlaceholderDic.get(Language));
            ExpectedTranslatedStrings.put(ApproveConfirmMessage + "TranslatedString", ApproveConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(ApproveSuccessMessage + "TranslatedString", ApproveSuccessMessageDic.get(Language));
            ExpectedTranslatedStrings.put(RejectConfirmMessage + "TranslatedString", RejectConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(RejectSuccessMessage + "TranslatedString", RejectSuccessMessageDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Account_Settings_Page.TurnONDemoMode();
            sleep(1000);
            Inbox_Page.NavigateToWorkItemFilter("Approval");
            sleep(1000);
            Inbox_Page.clickOnWorkItemContainingTitle("Request for an putitional raw material order");
            sleep(1000);
            MobileAppiumFunctions.waituntilElementclickable(ApproveWorkItemPage.btn_Approve);

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(Approve + "TranslatedString", ApproveWorkItemPage.btn_Approve.getText());
            ActualTranslatedStrings.put(Reject + "TranslatedString", ApproveWorkItemPage.btn_Reject.getText());
            ActualTranslatedStrings.put(CommentPlaceholder + "TranslatedString", ApproveWorkItemPage.txt_Comments.getText());

            //Navigate to Approval Confirmation Page
            ApproveWorkItemPage.btn_Approve.click();
            sleep(1000);
            ActualTranslatedStrings.put(ApproveConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_DialogOK.click();
            ActualTranslatedStrings.put(ApproveSuccessMessage + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());
            
            MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);

            //Navigate to Reject Confirmation Page
            Inbox_Page.clickOnWorkItemContainingTitle("Recipe has been successfully updated");
            sleep(1000);
            MobileAppiumFunctions.waituntilElementclickable(ApproveWorkItemPage.btn_Approve);

            ApproveWorkItemPage.btn_Reject.click();
            sleep(1000);
            ActualTranslatedStrings.put(RejectConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_DialogOK.click();
            ActualTranslatedStrings.put(RejectSuccessMessage + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());


            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Then("^Validate the Localization key on Remove Work Item Page for '(.*)', '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnRemoveWorkItemPageFor(String HoursAgo, String MinutesAgo, String OneHourAgo, String Remove) throws Exception
    {

        Map<String, String> HoursAgoDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", HoursAgo);
        Map<String, String> MinutesAgoDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", MinutesAgo);
        Map<String, String> OneHourAgoDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", OneHourAgo);
        Map<String, String> RemoveDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", Remove);
        

        boolean OverAllTestResult = true;

        for ( String key : HoursAgoDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	HoursAgoDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(MinutesAgo + "TranslatedString", MinutesAgoDic.get(Language));
            ExpectedTranslatedStrings.put(OneHourAgo + "TranslatedString", OneHourAgoDic.get(Language));
            ExpectedTranslatedStrings.put(HoursAgo + "TranslatedString", HoursAgoDic.get(Language));
            ExpectedTranslatedStrings.put(Remove + "TranslatedString", RemoveDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Account_Settings_Page.TurnONDemoMode();
            sleep(1000);

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(MinutesAgo + "TranslatedString", Inbox_Page.txt_WorkItemSyncTime.get(0).getText().split(" ")[1]);
            ActualTranslatedStrings.put(OneHourAgo + "TranslatedString", Inbox_Page.txt_WorkItemSyncTime.get(1).getText());
            ActualTranslatedStrings.put(HoursAgo + "TranslatedString", Inbox_Page.txt_WorkItemSyncTime.get(2).getText().split(" ")[1]);


            //Navigate to Remove Information Item Page
            Inbox_Page.NavigateToWorkItemFilter("Information");
            sleep(1000);
            Inbox_Page.clickOnWorkItemContainingTitle("Request for Maintenance Action has been cancelled");
            MobileAppiumFunctions.waituntilElementclickable(InformationWorkItemPage.btn_Remove);

            ActualTranslatedStrings.put(Remove + "TranslatedString", InformationWorkItemPage.btn_Remove.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key for no item available messages '(.*)' , '(.*)', '(.*)', '(.*)'$")
    public void ThenValidateTheLocalizationKeyForNoItemAvailableMessages( String Outbox_List_NoItemsAvailable, String SentItems_List_NoItemsAvailable, String WorkItem_List_NoItemsAvailable, String Drafts_List_NoItemsAvailable) throws Exception
    {
        Map<String, String> WorkItem_List_NoItemsAvailableDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", WorkItem_List_NoItemsAvailable);
        Map<String, String> Drafts_List_NoItemsAvailableDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Drafts", Drafts_List_NoItemsAvailable);
        Map<String, String> Outbox_List_NoItemsAvailableDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Outbox", Outbox_List_NoItemsAvailable);
        Map<String, String> SentItems_List_NoItemsAvailableDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "SentItems", SentItems_List_NoItemsAvailable);

        boolean OverAllTestResult = true;

        for ( String key : WorkItem_List_NoItemsAvailableDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	WorkItem_List_NoItemsAvailableDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(WorkItem_List_NoItemsAvailable + "TranslatedString", WorkItem_List_NoItemsAvailableDic.get(Language));
            ExpectedTranslatedStrings.put(Drafts_List_NoItemsAvailable + "TranslatedString", Drafts_List_NoItemsAvailableDic.get(Language));
            ExpectedTranslatedStrings.put(Outbox_List_NoItemsAvailable + "TranslatedString", Outbox_List_NoItemsAvailableDic.get(Language));
            ExpectedTranslatedStrings.put(SentItems_List_NoItemsAvailable + "TranslatedString", SentItems_List_NoItemsAvailableDic.get(Language));

            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Account_Settings_Page.TurnONDemoMode();
            Inbox_Page.NavigateToWorkItemFilter("Invoke Form");
            sleep(1000);
            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(WorkItem_List_NoItemsAvailable + "TranslatedString", Inbox_Page.txt_NoWorkItemsAvailable.getText());

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Drafts.click();
            ActualTranslatedStrings.put(Drafts_List_NoItemsAvailable + "TranslatedString", Drafts_Page.txt_NoItemsAvailable.getText());

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Outbox.click();
            ActualTranslatedStrings.put(Outbox_List_NoItemsAvailable + "TranslatedString", Outbox_Page.txt_NoItemsAvailable.getText());

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_SentItems.click();
            ActualTranslatedStrings.put(SentItems_List_NoItemsAvailable + "TranslatedString", SentItems_Page.txt_NoItemsAvailable.getText());



            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key on fill forms page for '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnFillFormsPageFor(String FillForm_SaveAsDraft_Success, String FillForm_Submission_Success) throws Exception
    {
        Map<String, String> FillForm_SaveAsDraft_SuccessDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "FillForms", FillForm_SaveAsDraft_Success);
        Map<String, String> FillForm_Submission_SuccessDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "FillForms", FillForm_Submission_Success);
        

        boolean OverAllTestResult = true;

        for ( String key : FillForm_SaveAsDraft_SuccessDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	FillForm_SaveAsDraft_SuccessDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(FillForm_SaveAsDraft_Success + "TranslatedString", FillForm_SaveAsDraft_SuccessDic.get(Language));
            ExpectedTranslatedStrings.put(FillForm_Submission_Success + "TranslatedString", FillForm_Submission_SuccessDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_FillForm.click();
            FillForm_Page.TapOnFillFormName("LocTestingForm");
            MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.box_Dialog_ProgressBar, 10);
            //sleep(500);
            FillForm_Page.btn_SaveDraft.click();
            sleep(500);
            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(FillForm_SaveAsDraft_Success + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());
            MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);

            FillForm_Page.EnterFormInput("TestName", "TestEmailgmail.com", "11/11/2001");
            ActualTranslatedStrings.put(FillForm_Submission_Success + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key on Drafts page for '(.*)' , '(.*)' , '(.*)', '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnDraftsPageFor(String ClearAll, String ClearAllErrorTitle, String ClearAll_ConfirmMessage, String DeleteSelectedItems, String DeleteSelectedItems_ConfirmMessage) throws Exception
    {
        Map<String, String> ClearAllDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll);
        Map<String, String> ClearAllErrorTitleDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAllErrorTitle);
        Map<String, String> ClearAll_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll_ConfirmMessage);
        Map<String, String> DeleteSelectedItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems);
        Map<String, String> DeleteSelectedItems_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems_ConfirmMessage);


        boolean OverAllTestResult = true;

        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_FillForm.click();
        FillForm_Page.TapOnFillFormName("LocTestingForm");
        //MobileAppiumFunctions.waitUntilElementIsVisible(FillForm_Page.btn_SaveDraft_Xpath(), 20);
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.box_Dialog_ProgressBar, 10);
        sleep(500);
        FillForm_Page.btn_SaveDraft.click();
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
        MobCommonFunctions.CloseApp();

        for ( String key : ClearAllDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	ClearAllDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(ClearAll + "TranslatedString", ClearAllDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", ClearAllErrorTitleDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", ClearAll_ConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", DeleteSelectedItemsDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", DeleteSelectedItems_ConfirmMessageDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Drafts.click();
            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(ClearAll + "TranslatedString", OverFlowIcon_Page.btn_OverFlowOptions.get(1).getText());

            OverFlowIcon_Page.btn_OverFlowOptions.get(1).click();
            ActualTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_Cancel.click();
            Drafts_Page.chkBox_OutboxListItems.get(0).click();
            MenuNav_Page.btn_OverFlowIcon.click();
            OverFlowIcon_Page.btn_OverFlowOptions.get(0).click();
            ActualTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key on sent items page for '(.*)' , '(.*)' , '(.*)', '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnSentItemsPageFor(String ClearAll, String ClearAllErrorTitle, String ClearAll_ConfirmMessage, String DeleteSelectedItems, String DeleteSelectedItems_ConfirmMessage) throws Exception
    {
        Map<String, String> ClearAllDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll);
        Map<String, String> ClearAllErrorTitleDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAllErrorTitle);
        Map<String, String> ClearAll_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll_ConfirmMessage);
        Map<String, String> DeleteSelectedItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems);
        Map<String, String> DeleteSelectedItems_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems_ConfirmMessage);


        boolean OverAllTestResult = true;

        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_FillForm.click();
        FillForm_Page.TapOnFillFormName("LocTestingForm");
        FillForm_Page.EnterFormInput("TestName", "TestEmailgmail.com", "11/11/2001");
        MobCommonFunctions.CloseApp();

        for ( String key : ClearAllDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	ClearAllDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(ClearAll + "TranslatedString", ClearAllDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", ClearAllErrorTitleDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", ClearAll_ConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", DeleteSelectedItemsDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", DeleteSelectedItems_ConfirmMessageDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_SentItems.click();
            sleep(1000);
            MenuNav_Page.btn_OverFlowIcon.click();

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(ClearAll + "TranslatedString", OverFlowIcon_Page.btn_OverFlowOptions.get(1).getText());

            OverFlowIcon_Page.btn_OverFlowOptions.get(1).click();
            ActualTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_Cancel.click();

            Drafts_Page.chkBox_OutboxListItems.get(0).click();
            MenuNav_Page.btn_OverFlowIcon.click();
            OverFlowIcon_Page.btn_OverFlowOptions.get(0).click();
            ActualTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key on outbox page for '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnOutboxPageFor(String ClearAll, String ClearAllErrorTitle, String ClearAll_ConfirmMessage, String DeleteSelectedItems, String DeleteSelectedItems_ConfirmMessage, String Outbox_List_SubHeader_FillForms, String Outbox_List_SubHeader_WorkItems) throws Exception
    {
        Map<String, String> ClearAllDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll);
        Map<String, String> ClearAllErrorTitleDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAllErrorTitle);
        Map<String, String> ClearAll_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ClearAll_ConfirmMessage);
        Map<String, String> DeleteSelectedItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems);
        Map<String, String> DeleteSelectedItems_ConfirmMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", DeleteSelectedItems_ConfirmMessage);
        Map<String, String> Outbox_List_SubHeader_FillFormsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Outbox", Outbox_List_SubHeader_FillForms);
        Map<String, String> Outbox_List_SubHeader_WorkItemsDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Outbox", Outbox_List_SubHeader_WorkItems);


        boolean OverAllTestResult = true;

        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_FillForm.click();
        FillForm_Page.TapOnFillFormName("LocTestingForm");
        FillForm_Page.SubmitEmptyFillForm();
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_Inbox.click();
        Inbox_Page.btn_Refresh.click();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();

        MobCommonFunctions.SwitchToOfflineMode();
        MenuNav_Page.WaitUnitlNetworkConnectionNotAvailableMessageAppears();
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_FillForm.click();
        FillForm_Page.TapOnFillFormName("LocTestingForm");
        FillForm_Page.SubmitEmptyFillForm();
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
        MenuNav_Page.btn_HamBurgerMenu.click();
        MenuNav_Page.btn_Inbox.click();
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
        Inbox_Page.btn_workItemTitle.get(0).click();
        ApproveWorkItemPage.btn_Approve.click();
        Dialogs_Page.btn_DialogOK.click();
        MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
        MobCommonFunctions.CloseApp();

        for ( String key : ClearAllDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	ClearAllDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(ClearAll + "TranslatedString", ClearAllDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", ClearAllErrorTitleDic.get(Language));
            ExpectedTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", ClearAll_ConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", DeleteSelectedItemsDic.get(Language));
            ExpectedTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", DeleteSelectedItems_ConfirmMessageDic.get(Language));
            ExpectedTranslatedStrings.put(Outbox_List_SubHeader_FillForms + "TranslatedString", Outbox_List_SubHeader_FillFormsDic.get(Language));
            ExpectedTranslatedStrings.put(Outbox_List_SubHeader_WorkItems + "TranslatedString", Outbox_List_SubHeader_WorkItemsDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Outbox.click();
            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(Outbox_List_SubHeader_FillForms + "TranslatedString", Outbox_Page.txt_FillForms_Header.getText());
            ActualTranslatedStrings.put(Outbox_List_SubHeader_WorkItems + "TranslatedString", Outbox_Page.txt_WorkItems_Header.getText());

            sleep(500);
            MenuNav_Page.btn_OverFlowIcon.click();


            ActualTranslatedStrings.put(ClearAll + "TranslatedString", OverFlowIcon_Page.btn_OverFlowOptions.get(1).getText());

            OverFlowIcon_Page.btn_OverFlowOptions.get(1).click();
            ActualTranslatedStrings.put(ClearAllErrorTitle + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(ClearAll_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_Cancel.click();

            Drafts_Page.chkBox_OutboxListItems.get(0).click();
            MenuNav_Page.btn_OverFlowIcon.click();
            OverFlowIcon_Page.btn_OverFlowOptions.get(0).click();
            ActualTranslatedStrings.put(DeleteSelectedItems + "TranslatedString", Dialogs_Page.text_DialogTitle.getText());
            ActualTranslatedStrings.put(DeleteSelectedItems_ConfirmMessage + "TranslatedString", Dialogs_Page.text_DialogError.getText());

            Dialogs_Page.btn_Cancel.click();

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key on work items page for '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnWorkItemsPageFor(String NoSubject, String LoadMore, String SecondsAgo) throws Exception
    {
        Map<String, String> WorkItem_List_NoSubjectDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", NoSubject);
        Map<String, String> LoadMoreDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", LoadMore);
        Map<String, String> SecondsAgoDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "WorkItems", SecondsAgo);
       
        boolean OverAllTestResult = true;

        //Navigate to the Page and Verify

        String FirstWorkItemTitle = "";



        for ( String key : WorkItem_List_NoSubjectDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	WorkItem_List_NoSubjectDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(NoSubject + "TranslatedString", WorkItem_List_NoSubjectDic.get(Language));
            ExpectedTranslatedStrings.put(LoadMore + "TranslatedString", LoadMoreDic.get(Language));
            ExpectedTranslatedStrings.put(SecondsAgo + "TranslatedString", SecondsAgoDic.get(Language));



            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_FillForm.click();
            FillForm_Page.TapOnFillFormName("LocTestingForm");
            FillForm_Page.EnterFormInput("TestName", "TestEmailgmail.com", "11/11/2001");
            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_SentItems.click();
            sleep(1000);
            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(SecondsAgo + "TranslatedString", SentItems_Page.txt_SentItemsSyncTime.get(0).getText().split(" ")[1]);

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Inbox.click();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();

            if (Inbox_Page.CheckIfFirstWorkItemPresent())
            {
                FirstWorkItemTitle = Inbox_Page.btn_workItemTitle.get(0).getText();
            }
            else
            {
                Inbox_Page.RefreshInboxUntilFirstWorkItemTitleChanges(FirstWorkItemTitle, 5);
                FirstWorkItemTitle = Inbox_Page.btn_workItemTitle.get(0).getText();
            }
            Inbox_Page.btn_Refresh.click();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            ActualTranslatedStrings.put(NoSubject + "TranslatedString", FirstWorkItemTitle);
            ActualTranslatedStrings.put(LoadMore + "TranslatedString", Inbox_Page.btn_LoadMore.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Then("^Validate the Localization key on login page for '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnLoginPageFor(String UserName, String Password, String ShowPassword, String Logon, String Error_114, String ModalDialog_TitleError) throws Exception
    {
        Map<String, String> UserNameDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", UserName);
        Map<String, String> PasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Password);
        Map<String, String> ShowPasswordDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", ShowPassword);
        Map<String, String> LogonDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", Logon);
        Map<String, String> Error_114Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_114);
        Map<String, String> ModalDialog_TitleErrorDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "PopUpCommonItems", ModalDialog_TitleError);

        boolean OverAllTestResult = true;

        //Navigate to the Page and Verify
        MobCommonFunctions.LaunchApp();
        Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
        LogOff_In_Page.LogOff();
        MobCommonFunctions.CloseApp();

        for ( String key : UserNameDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	UserNameDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(UserName + "TranslatedString", UserNameDic.get(Language));
            ExpectedTranslatedStrings.put(Password + "TranslatedString", PasswordDic.get(Language));
            ExpectedTranslatedStrings.put(ShowPassword + "TranslatedString", ShowPasswordDic.get(Language));
            ExpectedTranslatedStrings.put(Logon + "TranslatedString", LogonDic.get(Language));
            ExpectedTranslatedStrings.put(Error_114 + "TranslatedString", Error_114Dic.get(Language));
            ExpectedTranslatedStrings.put(ModalDialog_TitleError + "TranslatedString", ModalDialog_TitleErrorDic.get(Language));



            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            MobileAppiumFunctions.waituntilElementclickable(LogOff_In_Page.fld_UserName);

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(UserName + "TranslatedString", LogOff_In_Page.loc_fld_UserName.getText());
            ActualTranslatedStrings.put(Password + "TranslatedString", LogOff_In_Page.loc_fld_Password.getText());
            ActualTranslatedStrings.put(ShowPassword + "TranslatedString", LogOff_In_Page.chkbox_ShowPassword.getText());
            ActualTranslatedStrings.put(Logon + "TranslatedString", LogOff_In_Page.btn_LogOn.getText());

            LogOff_In_Page.LogIn("admin1","admin");
            sleep(1000);
            ActualTranslatedStrings.put(Error_114 + "TranslatedString", LogOff_In_Page.text_LoginPage_DialogError.getText());
            ActualTranslatedStrings.put(ModalDialog_TitleError + "TranslatedString", LogOff_In_Page.text_LoginPage_DialogTitle.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^Validate the Localization key when network connection is not available for '(.*)' , '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyWhenNetworkConnectionIsNotAvailableFor(String FillForm_Submission_Queued, String Error_Outbox_CannotViewIfAccountOnline, String Error_NoInternetConnectivity, String Error_0) throws Exception
    {
        Map<String, String> Error_NoInternetConnectivityDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_NoInternetConnectivity);
        Map<String, String> Error_0Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_0);
        Map<String, String> FillForm_Submission_QueuedDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "FillForms", FillForm_Submission_Queued);
        Map<String, String> Error_Outbox_CannotViewIfAccountOnlineDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_Outbox_CannotViewIfAccountOnline);

        boolean OverAllTestResult = true;

        for ( String key : Error_NoInternetConnectivityDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	Error_NoInternetConnectivityDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Error_NoInternetConnectivity + "TranslatedString", Error_NoInternetConnectivityDic.get(Language));
            ExpectedTranslatedStrings.put(Error_0 + "TranslatedString", Error_0Dic.get(Language));
            ExpectedTranslatedStrings.put(FillForm_Submission_Queued + "TranslatedString", FillForm_Submission_QueuedDic.get(Language));
            ExpectedTranslatedStrings.put(Error_Outbox_CannotViewIfAccountOnline + "TranslatedString", Error_Outbox_CannotViewIfAccountOnlineDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            Dialogs_Page.WaitUnitlUpdateWorkItemDialogDisappears();
            MobCommonFunctions.SwitchToOfflineMode();
            MenuNav_Page.WaitUnitlNetworkConnectionNotAvailableMessageAppears();
            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            ActualTranslatedStrings.put(Error_NoInternetConnectivity + "TranslatedString", Dialogs_Page.txt_NetworkConnectionNotAvailable.getText());

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_LogOff.click();
            sleep(500);
            ActualTranslatedStrings.put(Error_0 + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());
            MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);
         

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_FillForm.click();
            FillForm_Page.TapOnFillFormName("LocTestingForm");
            FillForm_Page.SubmitEmptyFillForm();
            sleep(500);
            ActualTranslatedStrings.put(FillForm_Submission_Queued + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());
            MobileAppiumFunctions.waituntilElementIsNoLongerInDom(Dialogs_Page.txt_ConfirmationMessgageInFooter, 20);

            MenuNav_Page.btn_HamBurgerMenu.click();
            MenuNav_Page.btn_Outbox.click();
            MobCommonFunctions.SwitchToOnlineMode();

            try
            {
                MenuNav_Page.WaitUnitlNetworkConnectionNotAvailableMessageDisAppears();
            }
            catch (Exception e)
            {
                Outbox_Page.OpenFirstFormFromOutbox();
                MenuNav_Page.btn_Back.click();
            }

            Outbox_Page.OpenFirstFormFromOutbox();
            sleep(500);
            ActualTranslatedStrings.put(Error_Outbox_CannotViewIfAccountOnline + "TranslatedString", Dialogs_Page.txt_ConfirmationMessgageInFooter.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.SwitchToOnlineMode();

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^^Validate the Localization key for errors from Manage Account Settings Page for '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyForErrorsFromManageAccountSettingsPageFor(String Error_99, String Error_100, String Error_130) throws Exception
    {
        Map<String, String> Error_99Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_99);
        Map<String, String> Error_100Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_100);
        Map<String, String> Error_130Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_130);

        boolean OverAllTestResult = true;

        for ( String key : Error_99Dic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	Error_99Dic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Error_99 + "TranslatedString", Error_99Dic.get(Language));
            ExpectedTranslatedStrings.put(Error_100 + "TranslatedString", Error_100Dic.get(Language));
            ExpectedTranslatedStrings.put(Error_130 + "TranslatedString", Error_130Dic.get(Language));



            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();
            sleep(1000);
            MobileAppiumFunctions.waituntilElementExists(Loc_Account_Settings_Page.Txt_ServerPathXpath(), 20);

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();


            Account_Settings_Page.txt_ServerPath.sendKeys("google.com");
            Account_Settings_Page.dropdown_Repository.click();

            sleep(1000);
            ActualTranslatedStrings.put(Error_99 + "TranslatedString", LogOff_In_Page.text_LoginPage_DialogError.getText());
            LogOff_In_Page.btn_Login_Page_DialogOK.click();

            Account_Settings_Page.txt_ServerPath.clear();
            Account_Settings_Page.txt_ServerPath.sendKeys("http://testurl:8000/EnterpriseConsole");
            Account_Settings_Page.dropdown_Repository.click();
            sleep(1000);

            ActualTranslatedStrings.put(Error_100 + "TranslatedString", LogOff_In_Page.text_LoginPage_DialogError.getText());
            LogOff_In_Page.btn_Login_Page_DialogOK.click();


            Account_Settings_Page.txt_ServerPath.clear();
            Account_Settings_Page.txt_ServerPath.sendKeys("http://10.184.208.160");
            Account_Settings_Page.dropdown_Repository.click();
            sleep(1000);

            ActualTranslatedStrings.put(Error_130 + "TranslatedString", LogOff_In_Page.text_LoginPage_DialogError.getText());
            LogOff_In_Page.btn_Login_Page_DialogOK.click();



            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }

    @Then("^^Validate the Localization key on Eula Page for '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnEulaPageFor(String Eula_Accept, String Eula_Cancel) throws Exception
    {
        Map<String, String> Eula_AcceptDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Eula", Eula_Accept);
        Map<String, String> Eula_CancelDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Eula", Eula_Cancel);
   

        boolean OverAllTestResult = true;
        //MobCommonFunctions.RemoveAppp();
        //MobCommonFunctions.InstallApp();

        for ( String key : Eula_AcceptDic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	Eula_AcceptDic.get(Language);

            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Eula_Accept + "TranslatedString", Eula_AcceptDic.get(Language));
            ExpectedTranslatedStrings.put(Eula_Cancel + "TranslatedString", Eula_CancelDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();


            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();

            ActualTranslatedStrings.put(Eula_Accept + "TranslatedString", Eula_Page.btn_Eula_Accept.getText());
            ActualTranslatedStrings.put(Eula_Cancel + "TranslatedString", Eula_Page.btn_Eula_Cancel.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " +"Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some expected Strings were not matching, please check report");
    }


    @Then("^Validate the Localization key on login for '(.*)' , '(.*)' , '(.*)'$")
    public void ThenValidateTheLocalizationKeyOnLoginFor(String Error_142, String Error_141, String QRCodeScannerMessage) throws Exception
    {
        Map<String, String> Error_142Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_142);
        //Map<String, String> Error_141Dic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "Errors", Error_141);
        Map<String, String> QRCodeScannerMessageDic = ExcelHelper.ReadLocalizationValues(LocalizationDataSourceFile, "AccountSettingsPage", QRCodeScannerMessage);


        boolean OverAllTestResult = true;
        //MobCommonFunctions.RemoveAppp();
        //MobCommonFunctions.InstallApp();

        for ( String key : Error_142Dic.keySet() ) {
        	String Language = key;
        	String[] LangCodeAndCountry = Language.split("-");
        	Error_142Dic.get(Language);


            Map<String, String> ExpectedTranslatedStrings = new HashMap<String, String>();
            ExpectedTranslatedStrings.put(Error_142 + "TranslatedString", Error_142Dic.get(Language));
            //ExpectedTranslatedStrings.put(Error_141 + "TranslatedString", Error_141Dic.get(Language));
            ExpectedTranslatedStrings.put(QRCodeScannerMessage + "TranslatedString", QRCodeScannerMessageDic.get(Language));


            // Change Device Language
            MobCommonFunctions.changeDeviceLanguage(LangCodeAndCountry[0], LangCodeAndCountry[1]);

            //Navigate to the Page and Verify
            MobCommonFunctions.LaunchApp();

            Account_Settings_Page.newAccountSetUpEnterAllDetailsWithoutClickingONLogin(GlobalSettings.getWebAppUrl(), "SearchFeature", GlobalSettings.getUserName(), GlobalSettings.getPassword());
            Account_Settings_Page.btn_LogOn.click();

            Map<String, String> ActualTranslatedStrings = new HashMap<String, String>();
            
            ActualTranslatedStrings.put(Error_142 + "TranslatedString", Account_Settings_Page.txt_AlertDialog_Msg.getText());
            Account_Settings_Page.btn_Ok_AlertDialog.click();

            Account_Settings_Page.btn_QRCodeScanner.click();

            ActualTranslatedStrings.put(QRCodeScannerMessage + "TranslatedString", Account_Settings_Page.txt_QRCodeScanMsg.getText());

            //ActualTranslatedStrings.put(Error_141 + "TranslatedString", Account_Settings_Page.txt_AlertDialog_Msg.getText());

            Reporter.addStepLog("Checking Translation For: " + Language);

            for ( String key2 : ExpectedTranslatedStrings.keySet() )
            {
                String ExpectedString = ExpectedTranslatedStrings.get(key2);
                String ActualString = ActualTranslatedStrings.get(key2);

                if (ExpectedString.equals(ActualString))
                {
                    Reporter.addStepLog("Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                }
                else
                {
                    Reporter.addStepLog("!!!!!String Mismatch!!!!! ---- " + "Expected String: " + ExpectedString.getBytes("UTF-8") + "-----" + "Actual String: " + ActualString.getBytes("UTF-8"));
                    OverAllTestResult = false;
                }

            }

            MobCommonFunctions.CloseApp();
        }

        Assert.assertEquals(OverAllTestResult , true, "Test Failed as some textss were not matching, please check report");
    }


    public void sleep(int milliSeconds)
    {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
