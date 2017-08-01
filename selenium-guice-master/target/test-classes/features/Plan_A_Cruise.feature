Feature: Finding the Cruise

  @test
  Scenario: Finding the Cruise status
    When I launch the Princess cruise application
    Then Application shuold be launched successfully
    When I move the mouse on the Plan A Cruises
    Then Plan and Book a cruise section should apper as result
    When I click on the Find Cruises link 
    Then Search Cruises grid section should open as a result 
    When I select the Destination as "Alaska"
    And select the Daparture as "Singapore"
    And select the Length of the cruise as "16 or More Days"
    And Select a month from the calendar 
    And click on the view result button
    Then Filters Cruiser details should display as result 
    And Available dates should be displayed on the table 
    