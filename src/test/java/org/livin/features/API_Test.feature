Feature:Api Assignment

  Scenario: Assignment1
    Given I make a Get call to venues endpoint
    Then I validate response code is 200
    And I get the count of each categories in the response
    And I get all the Names of Food Category
    And I get all the GeoLocations of Food Category