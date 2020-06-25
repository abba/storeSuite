@search
Feature: MyStore Search
  As a User on MyStore website
  I want to be able to search products using the search functionality
  So that I can see the list of valid results

  Background: Pre-requisite
    Given User navigates to MyStore
    Then User should be on MyStore

  @validSearch
  Scenario: Searches for valid item
    When User search for "Dresses"
    Then relevant search results should be returned

  @invalidSearch
  Scenario: Searches for an invalid item
    When User search for "adsfsfd"
    Then No results should be returned
    And Message "No results were found for your search" should be displayed


  @sortBy
  Scenario Outline: User Search Results Sorting
    Given User search for "<SearchKeyword>"
    And Sort By "<SortBy>"
    Then Result should be Sorted By "<SortBy>"

    Examples: Results Sorting
      | SearchKeyword | SortBy                   |
      | Dress         | Reference: Highest first |
      | Dresses       | Reference: Lowest first  |
      | Dress         | In stock                 |
      | Dresses       | Product Name: Z to A     |
      | Dress         | Product Name: A to Z     |
      | Dresses       | Price: Highest first     |
      | Dress         | Price: Lowest first |
