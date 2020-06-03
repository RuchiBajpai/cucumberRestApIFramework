@api
Feature: Testing a Student REST API
  Users should be able to submit GET, POST, PUT and Delete requests to a web service,
  represented by StudentController

  @createStudent
  Scenario: Post request to create a new student

  Given I create the following student using the rest API:
    | id           | 0      |
    | firstName    | Neha   |
    | lastName     | Sharma |
    | nationality  | Indian |
    | studentClass | Grade1 |
    Then I should be able to fetch the student for a specific student id "0" using the rest API

  @updateStudent
  Scenario: Put request to update an existing student
    Given I update the following student using the rest API:
      | id           | 0      |
      | firstName    | Neha1   |
      | lastName     | Sharma |
      | nationality  | Indian |
      | studentClass | Grade1 |
    Then I should be able to fetch the student for a specific student id "0" using the rest API

  @deleteStudent
  Scenario: Delete request to delete an existing student
    Given I delete the student with student id "0" using the rest API
    Then I should not be able to fetch the deleted student for a specific student id "0" using the rest API





