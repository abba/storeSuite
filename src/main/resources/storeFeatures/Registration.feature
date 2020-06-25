@registration
Feature: Registration and Login
  As a Registered User on MyStore website
  I want to be able to Login using valid details
  So that I can see my Account

  Background: Pre-requisite
    Given User navigates to MyStore
    Then User should be on MyStore

  Scenario: User registration
    Given User is on account registration page
    When User provides valid details for registration
    Then User should be successfully registered on my store