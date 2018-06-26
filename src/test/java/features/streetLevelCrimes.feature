Feature: Street level crimes

  Scenario : User calls web service for crimes at street-level with a specific point
    Given  I have  one point on map "52.629729" longitude "-1.131592"  latitude
    When  a user retrieves the specific response
    Then  the status code is 200
    And   response includes the following
      | category 	 	| anti-social-behaviour                 |
      | location_type	| Force									|