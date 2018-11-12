@Mobile
Feature: User Story 810247:End-End Scenarios for Work Task App

@ReadyForBuild @Android @IOS
Scenario: BeforeFeatureSteps
	Given Trun on internet before feature
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	
	
@807772  @ReadyForBuild @Android @IOS
Scenario: Validate if the EULA Screen is displayed when the App is launched for the first time
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	Then I should see the Agree and Cancel Buttons on EULA screen
	And I should be able to scroll down until the end of the EULA page
	
@807775 @807774 @ReadyForBuild @Android @IOS
Scenario: Validate if EULA is displayed on Cancel_Minimise_Launch the App again
	Given I clear the app data
	When I Lanuch the app
	When I click on Cancel on EULA
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS if visible
	Then I should see the Agree and Cancel Buttons on EULA screen

	
@807841 @ReadyForBuild @Android @IOS
Scenario: Validate if the EULA Screen is displayed when the App is uninstalled and installed
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	Then I should see the Agree and Cancel Buttons on EULA screen
	When I click on Accept on EULA
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	Then I should see the Agree and Cancel Buttons on EULA screen
	
@809271 @ReadyForBuild @Android @IOS
Scenario: Validate Server Path field on the Configuration Screen of Work Tasks
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure with invalid server paths
	Then I should get appropriate error messages for invalid serverpath
	
	
@809299 @ReadyForBuild @Android @IOS
Scenario: Validate Authentication Failure for Repository Users in the Configuration Screen of Work Tasks
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure with invalid login details
	Then I should get appropriate warning messages for authentication errors
	

### Write all http URL tests here ###	
@809266 @ReadyForBuild @Android @IOS
Scenario Outline: Validate Log on to the Work Tasks App using http EC URL
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	
	Examples:
	|serverpath|repository|providers|username|password|
	|httpurl|EndToEndScenarios|providers|admin|admin|
	
@810257 @ReadyForBuild @Android @IOS
Scenario Outline: Start---Worktasks App---http URL---Skelta Repo List---Login Successful---All Items Page---Approval Workitems Page---Flag-Approval---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "Approval" Workitems page
	And I update the flag for workitem with "<WorkItemtitle>"
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenarios|providers|admin|admin|3-Automation Approval Item|
	
@810471 @ReadyForBuild @Android @IOS
Scenario Outline: Start---Worktasks App---http URL---Skelta Repo List---Login Successful---Invoke Form Page---Flag---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "Invoke Form" Workitems page
	And I update the flag for workitem with "<WorkItemtitle>"
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenarios|providers|admin|admin|1-Automation Invoke Form Item|
	
	
@810471 @ReadyForBuild @Android @IOS
Scenario Outline: Start---Worktasks App---http URL---Skelta Repo List---Login Successful---Search---Local Search---Flag-Local Search---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "All Items" Workitems page
	And I search for item with title "<WorkItemtitle>"
	And I update the flag for workitem with "<WorkItemtitle>"
	When I clear the inbox search
	When I click the back button on inbox search
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenarios|providers|admin|admin|2-Automation Information Item|
	
	
@810834 @ReadyForBuild @Android @IOS
Scenario Outline: Start---Worktasks App---http URL---Skelta Repo List---Login Successful---Fill Form---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I get the first work item title
	When I navigate to "Fill Form" menu option
	And I open Fill Form "Form With Inputs"
	And I submit Form With Inputs with "TestName" , "TestEmail@gmail.com" , "11/11/2001"
	When I navigate to "Inbox" menu option
	Then the new work item should be displayed
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenarios|providers|admin|admin|2-Automation Information Item|
	
	
	
@810250 @ReadyForBuild @Android @IOS @TestingNow
Scenario Outline: Start---Worktasks App---http URL---Active Directrory Provider---Login Successful---All Items Page---Approval Workitems Page---Flag-Approval---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "Approval" Workitems page
	And I update the flag for workitem with "<WorkItemtitle>"
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenariosAD|providers|indsollabusr|IndSolusr101|3-Automation Approval Item|
	
@810463 @ReadyForBuild @Android @IOS @TestingNow
Scenario Outline: Start---Worktasks App---http URL---Active Directrory Provider---Login Successful---Invoke Form Page---Flag---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "Invoke Form" Workitems page
	And I update the flag for workitem with "<WorkItemtitle>"
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenariosAD|providers|indsollabusr|IndSolusr101|1-Automation Invoke Form Item|
	
	
@815991 @ReadyForBuild @Android @IOS @TestingNow
Scenario Outline: Start---Worktasks App---http URL---Active Directrory Provider---Login Successful---Search---Local Search---Flag-Local Search---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I navigate to "Flagged" Workitems page
	And I clear all flagged items if present
	When I navigate to "All Items" Workitems page
	And I search for item with title "<WorkItemtitle>"
	And I update the flag for workitem with "<WorkItemtitle>"
	When I clear the inbox search
	When I click the back button on inbox search
	When I navigate to "Flagged" Workitems page
	Then the item must be listed in flagged items with title "<WorkItemtitle>"
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenariosAD|providers|indsollabusr|IndSolusr101|2-Automation Information Item|
	
	
@810827 @ReadyForBuild @Android @IOS @TestingNow @TestingNow
Scenario Outline: Start---Worktasks App---http URL---Active Directrory Provider---Login Successful---Fill Form---End
	Given I clear the app data
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	When I get the first work item title
	When I navigate to "Fill Form" menu option
	And I open Fill Form "Form With Inputs"
	And I submit Form With Inputs with "TestName" , "TestEmail@gmail.com" , "11/11/2001"
	When I navigate to "Inbox" menu option
	Then the new work item should be displayed
	
	Examples:
	|serverpath|repository|providers|username|password|WorkItemtitle|
	|httpurl|EndToEndScenariosAD|providers|indsollabusr|IndSolusr101|2-Automation Information Item|
	
	
### Write all https URL tests here ###	



### Write all Azure Services URL tests here ###
	
	

