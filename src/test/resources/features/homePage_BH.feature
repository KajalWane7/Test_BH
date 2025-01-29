Feature: BrightHorizons website

  @Test1
  Scenario Outline: Verify search functionality
    Given Navigate to BH home page
    When Click on search icon
    Then Verify if search field is visible on the page
    And Search for "<Text>"
    Then Verify if the first search result is exact match to what you typed into search "<Text>"
    Examples:
      | Text                                            |
      | Employee Education in 2018: Strategies to Watch |