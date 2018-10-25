@Mobile
Feature: User Story 810247:End-End Scenarios for Work Task App

@ReadyForBuild
Scenario: BeforeFeatureSteps
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	Given Trun on internet before feature
#	
@807772  @ReadyForBuild @Android @IOS
Scenario: Validate if the EULA Screen is displayed when the App is launched for the first time
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
	Then I should see the Agree and Cancel Buttons on EULA screen
	And I should be able to scroll down until the end of the EULA page
	
@807775 @ReadyForBuild @Android @IOS
Scenario: Validate if EULA is displayed on Cancel_Minimise_Launch the App again
	Given I clear the app data
	When I Lanuch the app
	When I click on Cancel on EULA
	When I Lanuch the app
	And I allow camera and camera access and notifications on IOS
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
	|httpurl|UpgradeTestRepo_Base2017R2|providers|admin|admin|
	
	
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
	
	

