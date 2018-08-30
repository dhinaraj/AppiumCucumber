@Mobile
Feature: User Story 810247:End-End Scenarios for Work Task App


@ReadyForBuild @Android
Scenario: BeforeFeatureSteps
	Then Trun on internet before feature
	
@807772 @ReadyForBuild @Android
Scenario: Validate if the EULA Screen is displayed when the App is launched for the first time
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	Then I should see the Agree and Cancel Buttons on EULA screen
	And I should be able to scroll down until the end of the EULA page
	
@807775 @ReadyForBuild @Android
Scenario: Validate if EULA is displayed on Cancel-->Minimise-->Launch the App again
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	Then I should see the Agree and Cancel Buttons on EULA screen
	When I click on Cancel on EULA
	When I Lanuch the app
	Then I should see the Agree and Cancel Buttons on EULA screen
	
@807841 @ReadyForBuild @Android
Scenario: Validate if the EULA Screen is displayed when the App is uninstalled and installed
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	Then I should see the Agree and Cancel Buttons on EULA screen
	When I click on Accept on EULA
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	Then I should see the Agree and Cancel Buttons on EULA screen
	
	
@809266 @ReadyForBuild @Android
Scenario Outline: Validate Log on to the Work Tasks App using http:// EC URL
	Given I uninstall if worktaskspro app is already installed
	And I install worktaskspro app
	When I Lanuch the app
	And I click on Accept on EULA
	When I configure "<serverpath>", "<repository>", "<providers>", "<username>" and "<password>"
	Then logon should be sucessful and user can see the hamburger menu icon
	
	Examples:
	|serverpath|repository|providers|username|password|
	|http://10.184.208.160/EnterpriseConsole|multipleattachment|providers|admin|admin|
