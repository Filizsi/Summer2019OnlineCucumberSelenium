@Vehicles_column_names
Feature: Vehicle page
  Scenario: Vehicle page column names display
    Given user is on the login page
   Then user logs in as store manager
    And user navigates to "Fleet" then to "Vehicles"
    Then user verifies  column names are displayed
