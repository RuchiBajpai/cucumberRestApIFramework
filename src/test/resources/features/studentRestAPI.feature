Feature: Testing a Student REST API
  Users should be able to submit GET, POST, PUT and Delete requests to a web service,
  represented by StudentController

  Scenario: Post request to create a new student

  Given I create the following student using the rest API:
    | id           | 0      |
    | firstName    | Neha   |
    | lastName     | Sharma |
    | nationality  | Indian |
    | studentClass | Grade1 |




