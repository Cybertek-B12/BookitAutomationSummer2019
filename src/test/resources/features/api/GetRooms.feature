@api
Feature: Rooms

  Scenario: 1. Verify that amount of rooms is equals to 18
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends GET request to "/api/rooms"
    Then user should be able to see 18 rooms
    And user verifies that response status code is 200