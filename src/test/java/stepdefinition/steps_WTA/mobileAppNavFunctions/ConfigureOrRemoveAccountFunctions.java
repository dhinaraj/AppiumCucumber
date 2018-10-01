package stepdefinition.steps_WTA.mobileAppNavFunctions;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import pageObjects.pageObjects_WTA.app_Pages.*;

public class ConfigureOrRemoveAccountFunctions {

	MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
	Account_Settings_Page Account_Settings_Page = new Account_Settings_Page();

	public void ConfigureRepoIfNotConfiguredAlready() {
		try {
			MobCommonFunctions.LaunchApp();
			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), GlobalSettings.getRepoName(),
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
				MobCommonFunctions.sleep(2000);
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), GlobalSettings.getRepoName(),
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else {
				if (!Account_Settings_Page.checkIfDesiredAccountIsAlreadyConfigured(GlobalSettings.getWebAppUrl(),
						GlobalSettings.getRepoName(), GlobalSettings.getUserName())) {
					Account_Settings_Page.RemoveConfiguredAccount();
					Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(),
							GlobalSettings.getRepoName(), GlobalSettings.getUserName(), GlobalSettings.getPassword());
				}

			}

			MobCommonFunctions.CloseApp();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void ConfigureRepoIfNotConfiguredAlreadyAfterFeature() {
		try {

			MobCommonFunctions.LaunchApp();
			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), GlobalSettings.getRepoName(),
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
				MobCommonFunctions.sleep(2000);
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), GlobalSettings.getRepoName(),
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else {
				if (!Account_Settings_Page.checkIfDesiredAccountIsAlreadyConfigured(GlobalSettings.getWebAppUrl(),
						GlobalSettings.getRepoName(), GlobalSettings.getUserName())) {
					Account_Settings_Page.RemoveConfiguredAccount();
					Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(),
							GlobalSettings.getRepoName(), GlobalSettings.getUserName(), GlobalSettings.getPassword());
				}

			}

			MobCommonFunctions.CloseApp();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void ConfigureLocalizationRepoIfNotConfiguredAlready() {

		try {
			MobCommonFunctions.LaunchApp();
			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
				MobCommonFunctions.sleep(2000);
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else {
				if (!Account_Settings_Page.checkIfDesiredAccountIsAlreadyConfigured(GlobalSettings.getWebAppUrl(),
						"MobAutLoc_Testing", GlobalSettings.getUserName())) {
					Account_Settings_Page.RemoveConfiguredAccount();
					Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
							GlobalSettings.getUserName(), GlobalSettings.getPassword());
				}

			}

			MobCommonFunctions.CloseApp();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void ConfigureLocalizationRepoIfNotConfiguredAlreadyAfterFeature() {

		try {
			MobCommonFunctions.LaunchApp();
			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
				MobCommonFunctions.sleep(2000);
				Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
						GlobalSettings.getUserName(), GlobalSettings.getPassword());
			} else {
				if (!Account_Settings_Page.checkIfDesiredAccountIsAlreadyConfigured(GlobalSettings.getWebAppUrl(),
						"MobAutLoc_Testing", GlobalSettings.getUserName())) {
					Account_Settings_Page.RemoveConfiguredAccount();
					Account_Settings_Page.ConfigureNewAccount(GlobalSettings.getWebAppUrl(), "MobAutLoc_Testing",
							GlobalSettings.getUserName(), GlobalSettings.getPassword());
				}

			}

			MobCommonFunctions.CloseApp();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}



	public void RemoveAccountIfAlreadyConfigured() {
		try {
			MobCommonFunctions.LaunchApp();

			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				return;
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
			} else {
				Account_Settings_Page.RemoveConfiguredAccount();
			}

			MobCommonFunctions.CloseApp();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

	public void RemoveAccountIfAlreadyConfigured_BeforeSceario() {
		try {
			MobCommonFunctions.LaunchApp();

			if (Account_Settings_Page.checkIfAccountNotConfigured()) {
				return;
			} else if (Account_Settings_Page.CheckIfDemoModeOn()) {
				Account_Settings_Page.TurnOFFDemo();
			} else {
				Account_Settings_Page.RemoveConfiguredAccount();
			}

			MobCommonFunctions.CloseApp();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
