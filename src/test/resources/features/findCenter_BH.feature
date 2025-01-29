Feature: Find a Center option functionality

  @Test2
  Scenario Outline: Verify comments
    Given Navigate to BH home page
    When Click on Find a Center option
    Then Verify that "<locator>" as a part of its URL
    And Search location as  "<location>"
    Then verify if a number of found centers is the same as a number of centers displayed in the list
    Then Click on the first center on the list
    Then Verify whether the center name and the address are the same in the list and in the popup

    Examples:
      | locator             | location |
      | /child-care-locator | New York |