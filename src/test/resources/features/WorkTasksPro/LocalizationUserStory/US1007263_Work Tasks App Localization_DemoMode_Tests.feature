#@Mobile
#@TurnONInternet_BeforeFeatureHook
#@RemoveAccount_BeforeFeatureHook
#Feature: US1007263_Work Tasks App Localization_DemoMode_Tests
#
#@ReadyForBuild @Android
#Scenario: BeforeFeatureSteps
#	Given I clear the app data
#	And I Lanuch the app
#	And I allow camera and camera access and notifications on IOS
#	And I click on Accept on EULA
#	And Trun on internet before feature
#
#
#@ReadyForBuild @Android
#Scenario: Validate the Localization key on Approval Work Item
#	Then Validate the Localization key on Approval Work Item Page for 'Approve', 'Reject' , 'CommentPlaceholder' , 'ApproveConfirmMessage' , 'ApproveSuccessMessage' , 'RejectConfirmMessage' , 'RejectSuccessMessage'
#
#@ReadyForBuild @Android
#Scenario: Validate the Localization key on Remove Work Item
#	Then Validate the Localization key on Remove Work Item Page for 'HoursAgo', 'MinutesAgo' , 'OneHourAgo' , 'Remove'
#
#@ReadyForBuild @Android
#Scenario: Validate the Localization key for not items available messages
#	Then Validate the Localization key for no item available messages 'Outbox_List_NoItemsAvailable' , 'SentItems_List_NoItemsAvailable', 'WorkItem_List_NoItemsAvailable', 'Drafts_List_NoItemsAvailable'