#Feature: US1007263_Work Tasks App Localization_Online_WithinApp
#
#@ReadyForBuild @Android @Localization
#Scenario Outline: BeforeFeatureSteps
#	Given I clear the app data
#	When I Lanuch the app
#	And I allow camera and camera access and notifications on IOS
#	And I click on Accept on EULA
#	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
#	Then logon should be sucessful and user can see the hamburger menu icon
#	And I Turn on Drafts in Settings page
#	And Trun on internet before feature
#	
#	Examples:
#	|serverpath|repository|providers|username|password|
#	|httpurl|UpgradeTestRepo_Base2017R2|providers|admin|admin|
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Account Settings Page_ExistingConfiguration
#	Given Validate the Localization key on Account Settings Page_ExistingConfiguration for 'Server Path','Repository', 'Provider', 'User Name', 'Password', 'Show Password'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Menu Navigation
#	Given Validate the Localization key on Menu Navigation page for 'Inbox','Fill Form', 'Drafts', 'Sent Items', 'Outbox', 'Sync', 'Manage Account', 'Settings', 'Help', 'Log Off'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Work Item Category Fiter
#	Given Validate the Localization key on Work Item Category Fiter for 'All Items','Approval', 'Flagged', 'Information', 'Invoke Form Item'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on About Page
#	Given Validate the Localization key on About Page for 'AboutApp', 'App Name', 'Version', 'Copyright', 'Privacy Policy', 'View Online', 'Technical Support', 'Contact'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Manage Account Overflow Icon
#	Given Validate the Localization key on Manage Account Overflow Icon for 'Delete Account' , 'Help', 'AboutApp'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on clear account settings Warning
#	Given Validate the Localization key on clear account settings Warning for 'Delete Account' , 'DeleteAccountWarning', 'OK', 'Cancel'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on App Settings Page
#	Given Validate the Localization key on App Settings Page for 'SettingsText', 'LoggingListButton' , 'SyncListButton' , 'LoggingText' , 'SyncText' 'Level', 'Error', 'Warning', 'Information' 'ItemsToSyncDataAndLookUp'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Fill Forms Page
#	Then Validate the Localization key on fill forms page for 'FillForm_SaveAsDraft_Success' , 'FillForm_Submission_Success'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Drafts Page
#	Then Validate the Localization key on Drafts page for 'ClearAll' , 'ClearAllErrorTitle' , 'ClearAll_ConfirmMessage', 'DeleteSelectedItems' , 'DeleteSelectedItems_ConfirmMessage'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Sent items Page
#	Then Validate the Localization key on sent items page for 'ClearAll' , 'ClearAllErrorTitle' , 'ClearAll_ConfirmMessage', 'DeleteSelectedItems' , 'DeleteSelectedItems_ConfirmMessage'
#
#
#@TurnONInternet_AfterScenarioHook
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Outbox Page
#	Then Validate the Localization key on outbox page for 'ClearAll' , 'ClearAllErrorTitle' , 'ClearAll_ConfirmMessage' , 'DeleteSelectedItems' , 'DeleteSelectedItems_ConfirmMessage' , 'Outbox_List_SubHeader_FillForms' , 'Outbox_List_SubHeader_WorkItems'
#
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Work Items Page
#	Then Validate the Localization key on work items page for 'NoSubject' , 'LoadMore' , 'SecondsAgo'
#
#
#@LogIn_AfterScenarioHook
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key on Log in Page for
#	Then Validate the Localization key on login page for 'User Name' , 'Password' , 'Show Password' , 'Logon' , 'Error_114' , 'ModalDialog_TitleError'
#
#
#@TurnONInternet_AfterScenarioHook
#@ReadyForBuild @Android @Localization
#Scenario: Validate the Localization key when network connection is not available
#	Then Validate the Localization key when network connection is not available for 'FillForm_Submission_Queued' , 'Error_Outbox_CannotViewIfAccountOnline' , 'Error_NoInternetConnectivity' , 'Error_0' 
#
##@ReadyForBuild @Android
##Scenario: Validate the Localization key for insufficient rights and invalid qrcode and focus to scan qr code
##	Then Validate the Localization key on login for 'Error_142' , 'Error_141' , 'QRCodeScannerMessage'