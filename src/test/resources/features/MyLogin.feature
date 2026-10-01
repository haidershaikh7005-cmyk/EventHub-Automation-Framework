Feature: Login functionality for MyNewSite

  Scenario: Verify login works with valid credentials
    Given user navigates to login page
    And user enters username
    And user enters password
    And user click login button
    Then verify that user is logged in and navigated to EventHub page