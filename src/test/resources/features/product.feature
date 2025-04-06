Feature: Product Search & Filter Scenarios
  @demo
    Scenario: Successful product search with valid keyword
        Given the user is on the product search page
        When the user enters a valid search keyword
        | keyword       | BAG           |
        Then the user should see relevant products in the search results
          | keyword       | BAG           |