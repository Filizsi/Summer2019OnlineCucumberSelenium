Feature: Login
  As user, I want to be able to login into Vytrack under different roles with username and password

  #ant steps that was implemented before, van be reused
  #if test steps has yellow background, that means it doesn't have implementation yet
  #I had somewhere from 2-25 scenarios in every feature file
  #by passing parameters/strings in double cotes"", we can reuse test steps
  #in my projects, I was trying to keep scenarios short
  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" page subtitle is displayed
  @driver
  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as driver
    And user verifies that "Dashboard" page subtitle is displayed
  @sales_manager
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" page subtitle is displayed

  @negative_test
  Scenario: verify that warning message is displayed, when password is not correct
    Given user is on the login page
    Then user enters "storemanager85" username and "wrong"Password
    And user verifies that "Invalid use name or password"message is displayed

  @negative_test
  Scenario: verify that warning message is displayed, when username is not correct
    Given user is on the login page
    Then user enters "wrong username" username and "UserUser123"Password
    And user verifies that "Invalid use name or password"message is displayed


  @driver_with_data_table
  Scenario: Login as driver (data table example)
    Given user is on the login page
    Then user logs in as driver with following credentials
      | username | user160     |
      | password | UserUser123 |
    And user verifies that "Quick Launchpad" page subtitle is displayed


