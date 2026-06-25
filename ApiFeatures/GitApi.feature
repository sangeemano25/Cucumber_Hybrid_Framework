Feature: Git Repository API Validations
  I want to use this feature file to verify all the scenarios related to GitHub API requests.

Scenario Outline: Request to create a new repository for the authenticated user with "<scenario>"
    Given User sets the repository name as "<RepoName>" and description as "<RepoDescription>"
    When User sends a "POST" request with end point "/user/repos" to create the repository with visibility "<Visibility>"
    Then User should get the response code as <StatusCode>
    And User should get the response message as "<ResponseMessage>"
    And User should get the response within 5 seconds
    And Response body should contain "<Key>" with value "<ExpectedValue>"

Examples:
      | scenario | RepoName              | RepoDescription        | Visibility | StatusCode | ResponseMessage      | Key                | ExpectedValue                       |
      | InValid  | JMeterRepo            | This is a invalid repo | true       | 422        | Unprocessable Entity | errors[0].message  | name already exists on this account |
      | Valid    | RestAssuredRepository | This is a valid repo   | false      | 201        | Created              | name               | RestAssuredRepository               |

Scenario: Request to get the existing repository for the authenticated user.
    Given User sends a "GET" request with endpoint "/repos/bharathtechacademy05/RestAssuredRepository" to get the repo
    Then User should get the response code as 200
    And User should get the response message as "OK"
    And User should get the response within 5 seconds
    And Response body should contain "name" with value "RestAssuredRepository"

Scenario: Request to update the existing repository for the authenticated user.
    Given User sends a "PATCH" request with endpoint "/repos/bharathtechacademy05/RestAssuredRepository" to update the repo visibility "true"
    Then User should get the response code as 200
    And User should get the response message as "OK"
    And User should get the response within 5 seconds
    And Response body should contain "name" with value "RestAssuredRepository"
    And Response body should contain "private" with value "true"

  Scenario: Request to delete the existing repository for the authenticated user.
    Given User sends a "DELETE" request with endpoint "/repos/bharathtechacademy05/RestAssuredRepository" to delete the repo
    Then User should get the response code as 204
    And User should get the response message as "No Content"
    And User should get the response within 5 seconds