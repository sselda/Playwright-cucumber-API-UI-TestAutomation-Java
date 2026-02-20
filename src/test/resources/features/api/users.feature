@api
Feature:Users API

Scenario: Get list of users
    When user sends "GET" request to "/users?page=2"
    Then response status should be 200
    And response should contain field "data"
    And first user email should be "micheal.lawson@reqres.in"
    And response should match schema "users-schema.json"

@ui
Scenario: Create user via API and verify in UI
    When user creates a new user via API
    Then created user should appear in UI

@ui
Scenario: Login via API and access Dashboard
    When user logs in via API with "eva.holt@reqres.in" and "cityslicka"
    Given user is authenticated in UI
    Then homepage should be loaded
