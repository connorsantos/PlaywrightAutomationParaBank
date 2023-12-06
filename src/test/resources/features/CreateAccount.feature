@createaccount
Feature: Register new account to Parabank

  Scenario: Register new account to Parabank and verify the new account by logging in

  Given I am on the Register Page
  When I fill out the sign in form and click register
  Then Account should be created successfully