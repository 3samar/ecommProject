Feature: User Authentication Scenarios
#@demo
#  Scenario: Successful registration with valid details
#    Given the user is on the registration page
#    When the user enters valid registration details
#      | email         | test@email.com  |
#      | password      | 12345678@Ajc    |
#      | firstName     | Joe             |
#      |phone.number   | 9999999999      |
#    Then the user should see the phone number in message
#    |PHONE_NUMBER |
#    |9999999999   |
#
#  Scenario: Successful login with valid credentials
#    Given the user is on the login page
#    When the user enters valid credentials
#    Then the user should be redirected to the dashboard
#

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
      | email         | test@email.com  |
      | password      | 12345678@Ajc    |
    Then an error message should be displayed
#
#  Scenario: Successful logout
#    Given the user is logged in
#    When the user clicks on the logout button
#    Then the user should be redirected to the login page
