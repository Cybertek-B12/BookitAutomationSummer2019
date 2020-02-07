@api @rooms
Feature: Rooms

  Scenario: 1. Verify that amount of rooms is equals to 18
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends GET request to "/api/rooms"
    Then user should be able to see 18 rooms
    And user verifies that response status code is 200

  @print_room_names
  Scenario: 2. Print rooms names
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends GET request to "/api/rooms"
    Then user should be able to see all room names
    And user verifies that response status code is 200

  @verify_room_names
  Scenario: 3. Verify rooms names
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends GET request to "/api/rooms"
    And user verifies that response status code is 200
    Then user payload contains following room names:
      | harvard     |
      | yale        |
      | princeton   |
      | stanford    |
      | duke        |
      | berkeley    |
      | kilimanjaro |
      | half dome   |
      | denali      |
      | meru        |
      | google      |
      | apple       |
      | microsoft   |
      | bay_area    |
      | amazon      |
      | tesla       |
      | facebook    |
      | ping pong   |