@api @create_student
Feature: Create student

  Scenario: 1. Create student as a team member and verify status code 422
    Given authorization token is provided for "team member"
    And user accepts content type as "application/json"
    When user sends POST request to "/api/students/student" with following information:
      | first-name | last-name | email             | password | role                | campus-location | batch-number | team-name      |
      | Lesly      | McDonald  | lesslee@email.com | 1111     | student-team-member | VA              | 12           | Online_Hackers |
    And user verifies that response status code is 403


  Scenario: 2. Create student as a teacher and verify status code 201
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends POST request to "/api/students/student" with following information:
      | first-name | last-name | email               | password | role                | campus-location | batch-number | team-name      |
      | Lesly      | SDET      | lesly2020@email.com | 1111     | student-team-member | VA              | 12           | Online_Hackers |
    And user verifies that response status code is 201
    Then user deletes previously added students
      | first-name | last-name | email               | password | role                | campus-location | batch-number | team-name      |
      | Lesly      | SDET      | lesly2020@email.com | 1111     | student-team-member | VA              | 12           | Online_Hackers |

#    we can add only one student
#  so to resolve this issue, we can delete added student at the end of the test