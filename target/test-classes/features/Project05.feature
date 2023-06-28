@Project05
Feature:Project05 automation

  Background:
    Given user navigates to "https://techglobal-training.com/frontend/project-5"

  Scenario: Test Case 01 - Validate the main content

    Then user should see the first "Pagination" heading
    And user should see second the "World City Populations 2022" heading
    And user should see the "What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:" paragraph

  Scenario: Test Case 02 - Validate the Pagination Next/Previous buttons

    Then user should see the "Previous" button is disabled
    And user should see the "Next" button is enabled
    When user clicks on the "Next" button
    And user should see the "Previous" button is enabled
    And user clicks on the "Next" button till it becomes disabled
    Then user should see the "Previous" button is enabled
    And  user should see the "Next" button is disabled

  Scenario:Test Case 03 - Validate the Pagination Cities content
    Then user should see "Tokyo" City with the info below and an image

      | City: Tokyo            |
      | Country: Japan         |
      | Population: 37,435,191 |
    When user clicks on the "Next" button
    Then user should see "Delhi" City with the info below and an image

      | City: Delhi            |
      | Country: India         |
      | Population: 29,399,141 |
    When  user clicks on the "Next" button
    Then  user should see "Shangai" City with the info below and an image

      | City: Shangai          |
      | Country: China         |
      | Population: 26,317,104 |
    When user clicks on the "Next" button
    Then user should see "Sao Paulo" City with the info below and an image

      | City: Sao Paulo        |
      | Country: Brasil        |
      | Population: 21,846,507 |
    When user clicks on the "Next" button
    Then user should see "Mexico City" City with the info below and an image

      | City: Mexico City      |
      | Country: Mexico        |
      | Population: 21,671,908 |