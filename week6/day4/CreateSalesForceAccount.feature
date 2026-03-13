Feature: Create Salesforce account
Background: 
	Given User logs into Salesforce using url "https://login.salesforce.com"
Scenario Outline: Verify user can create Salesforce account
	Given User navigates to Sales page from App Launcher
	And User clicks on Accounts tab
	And User clicks on New button
	And User creates a new Salesforce account with name "<Name>"
	Then Account "<Name>" should be created successfully
Examples:
| Name |
| Lakshmi |

	
	