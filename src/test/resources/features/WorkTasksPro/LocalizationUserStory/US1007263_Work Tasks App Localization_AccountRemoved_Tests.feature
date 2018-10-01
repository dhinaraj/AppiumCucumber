@Mobile
@TurnONInternet_BeforeFeatureHook
@RemoveAccount_BeforeFeatureHook
Feature: US1007263_Work Tasks App Localization_AccountRemoved_Tests

@ReadyForBuild @Android
Scenario: BeforeFeatureSteps
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	And I Lanuch the app
	And I click on Accept on EULA
	And Trun on internet before feature
	
@ReadyForBuild @Android
Scenario: Validate the Localization key on Account Settings Page_FirstTimeConfiguration
	Then Validate the Localization key on Account Settings Page for 'Demo Mode', 'Server Path','Repository', 'Provider', 'User Name', 'Password', 'Show Password', 'Logon'


@ReadyForBuild @Android
Scenario: Validate the Localization key for errors from Manage Account Settings Page
	Then Validate the Localization key for errors from Manage Account Settings Page for 'Error_99' , 'Error_100' , 'Error_130'


@AcceptEulaHook_AfterScenarioHook
@ReadyForBuild @Android
Scenario: Validate the Localization key on Eula Page
	Then Validate the Localization key on Eula Page for 'Eula_Accept' , 'Eula_Cancel'

