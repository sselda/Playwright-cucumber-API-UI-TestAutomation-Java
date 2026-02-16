Feature:Smoke

@ui
Scenario: Open homepage
    Given user opens the homepage
    Then homepage title should contain "Example"
