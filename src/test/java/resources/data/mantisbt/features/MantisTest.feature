Feature: MantisFeature
  Scenario: MantisScenario
    Given Login as "tester1"
    And Open "bug report page"
    And Fill bug report
    And Submit issue
    When Open "view all bug page"
    Then Should see bug report

    Given Reopen browser
    And Open "mantis site"
    And Login as "dev1"
    When Open "view all bug page"
    And Find bug report
    Then Open bug
    And Change bug status to "resolved"

    Given Reopen browser
    And Open "mantis site"
    And Login as "lead1"
    And Open "view all bug page"
    And Find bug report
    When Open bug
    And Change bug status to "closed"
    And Open "view all bug page"
    And Set filter hide status to "[none]"
    Then Find bug report
    




