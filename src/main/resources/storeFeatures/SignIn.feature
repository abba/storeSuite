@signIn
Feature: Registration and Login
  As a Registered User on MyStore website
  I want to be able to Login using valid details
  So that I can see my Account

  Background: Pre-requisite
    Given User navigates to MyStore
    Then User should be on MyStore

  @validUserSignIn
  Scenario: Valid User Signin
    Given User is on SignIn Page
    When User Signin using "usertest@test.com" and Password "12345"
    Then User should be signed in successfully

  @invalidUserSignIn
  Scenario Outline: Invalid User Signin Validation Messages
    Given User is on SignIn Page
    When User Signin using "<Email>" and Password "<Password>"
    Then User should be notified Message <Message>

    Examples: User Details
      | Email         | Password | Message                      |
      | test@test.com |          | "Password is required."     |
      |               | abcd1234 | "An email address required." |
