@Smoke
Feature: Test Homepage feature
  As a User,I want to check given tests on the webpage.

  Background: User is on Homepage
    Given I open the given URL in browser
    And I accept the cookies
    Then I am on the homepage of dailymail website

  Scenario: check given test on the webpage
    Given I am on the Homepage
    When I can see webpage displays current date and time
    And I can navigate to Sport menu
    Then I navigate Football subMenu and verify the colour of both menu
    And I click on First article
    Then I can click on Gallery Icon and verify the image count
    And I click on previous and next arrows buttons and verify it navigates to the appropriate gallery picture
    And I click on the Facebook share icon and verify it opens Facebook modal dialog
    And I click on video embedded within the article and click the full screen button on the right-hand corner
    Then I can verify Premier League Table section and exhibit the points or positions from the Premier league table for the "Liverpool" team
