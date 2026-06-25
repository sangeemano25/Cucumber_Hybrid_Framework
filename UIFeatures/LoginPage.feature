Feature: Login feature in Creatio CRM
To use this feature file to verify all the test scenarios related to Login Page

Background: Initialize the pages
    Given Initialize the page objects

@SignUp
Scenario: Verify sign-up link functionality.
    Given Launch the application
    Then Verify the cookies popup is displayed.
    When User select "allow all" button
    Then Verify the cookies popup is closed.
    And Verify Login page is displayed
    When User click on the Sign-up link
    Then Verify the Sign-up page should be displayed.

Scenario: Verify Forgot Password Link functionality.
    Given Launch the application
    Then Verify the cookies popup is displayed.
    When User select "allow all" button
    Then Verify the cookies popup is closed.
    And Verify Login page is displayed
    When User enter valid business email "test@test.com"
    And User click on the Forgot Password link
    Then User should get reset password confirmation message
    
Scenario: Verify social media links displayed in the login page.
    Given Launch the application
    Then Verify the cookies popup is displayed.
    Then Verify the cookies popup is closed.
    And Verify Login page is displayed
    And Social media links should be displayed within the login page
    
Scenario Outline: Verify login functionality with <Scenario>

    Given Launch the application
    Then Verify the cookies popup is displayed.
    When User select "allow all" button
    Then Verify the cookies popup is closed.
    And Verify Login page is displayed
    When User enter <Email> and <Password>
    And User click on the Login button
    

Examples:
| Scenario | Email                          | Password                  |
| Valid    | bharathtechacademy20@outlook.com | BharathTechAcademy@123  |
| Invalid  | invalidemail@gmail.com         | invalidPassword123        |