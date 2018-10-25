#@Mobile
#@TurnONInternet_BeforeFeatureHook
#@RemoveAccount_BeforeFeatureHook
#Feature: US1007263_Work Tasks App Localization_AccountRemoved_Tests
#
#@ReadyForBuild @Android @Localization
#Scenario: BeforeFeatureSteps
#	Given I clear the app data
#	And I Lanuch the app
#	And I allow camera and camera access and notifications on IOS
#	And I click on Accept on EULA
#	And Trun on internet before feature
#	
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Account Settings Page_FirstTimeConfiguration
#	Then Validate the Localization key on Account Settings Page for 'Demo Mode', 'Server Path','Repository', 'Provider', 'User Name', 'Password', 'Show Password', 'Logon'
#
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key for errors from Manage Account Settings Page
#	Then Validate the Localization key for errors from Manage Account Settings Page for 'Error_99' , 'Error_100' , 'Error_130'
#
#
#@AcceptEulaHook_AfterScenarioHook
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Eula Page
#	Then Validate the Localization key on Eula Page for 'Eula_Accept' , 'Eula_Cancel'
#
