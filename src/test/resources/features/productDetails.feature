Feature: Product Detail Verification Scenarios
  @demo
  @TC04
  Scenario: Verify product title, price, and description display correctly
    Given the user is on the product search page
    When the user enters a valid search keyword
      | keyword       | RED ZARA TEMPTATION EDP 30 ML / 1.01 oz           |
    And the user selects a product from the search results
    Then the product title should be displayed correctly
    | productTitle   | RED ZARA TEMPTATION EDP 30 ML / 1.01           |
    | productPrice   | 950                                                |
    | productDescription | Eau de parfum disguised with the warm, textured facets of precious saffron and coriander spices, bitter orange adds a fruity and colourful touch to the luminous floral bouquet           |