Feature:Login

@ui @login
Scenario: Successful login
Given user is on login page
When user logs in with username "demo" and password "demo123"
Then user should be logged in
