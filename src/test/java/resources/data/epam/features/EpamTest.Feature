Feature: Contact Form submitting

  Scenario: Scenario_test1
    Given Login as "admin"
    And Open Contact Form page
    When Fill form by with "entity_1"
    And Submit Contact Form
    Then Result contains "entity_1"