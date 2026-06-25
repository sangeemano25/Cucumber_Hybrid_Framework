Feature: Cookies feature with CRM Creatio application
As a user of Creatio CRM application,Validate cookiesand all its fields, functionality related validations

Background: Initalise page classes
Given Initialize the page objects

Scenario: Validate cookies pop up is displayed within login page
Given Launch the application
Then Verify the cookies popup is displayed.

Scenario: Validate cookies pop up content page 
Given Launch the application
Then Verify the cookies popup is displayed.
And Validate the cookies pop-up content message
| Content |
|We may use cookies and similar technologies to collect information about the ways you interact with and use the website, to support and enhance features and functionality, to monitor performance, to personalize content and experiences, for marketing and analytics, and for other lawful purposes. We also may share information about your use of our site with our social media, advertising and analytics partners who may combine it with other information that you’ve provided to them or that they’ve collected from your use of their services. Please, see more details on the "About" tab|

Scenario: Verify cookies pop-up logos
Given Launch the application
Then Verify the cookies popup is displayed.
And verify Cookies popup logos

Scenario: Verify cookies pop-up selection buttons
Given Launch the application
Then Verify the cookies popup is displayed.
And Verify cookies pop-up selection buttons

Scenario: Verify cookies pop-up switch buttons
Given Launch the application
Then Verify the cookies popup is displayed.
And Verify cookies pop-up switch buttons

Scenario: Verify cookies pop-up expanded view
Given Launch the application
Then Verify the cookies popup is displayed.
When user clicks on Show Details Link
Then cookies pop-up should be displayed in expanded view

Scenario: Verify cookies pop-up is closed for all the <selection> buttons
Given Launch the application
    Then Verify the cookies popup is displayed.
When user clicks on Show Details Link
Then cookies pop-up should be displayed in expanded view
When User clicks on the <selection> button
Then cookies pop-up should get closed

Examples:	
| selection |
|allow all|
|allow selection|
|deny|

