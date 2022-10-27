$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/resources/featurefile/test.feature");
formatter.feature({
  "line": 1,
  "name": "Test Homepage feature",
  "description": "As a User,I want to check given tests on the webpage.",
  "id": "test-homepage-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5581612300,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "User is on Homepage",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I open the given URL in browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I accept the cookies",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I am on the homepage of dailymail website",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.iOpenTheGivenURLInBrowser()"
});
formatter.result({
  "duration": 78140200,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iAcceptTheCookies()"
});
formatter.result({
  "duration": 617374500,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iAmOnTheHomepageOfDailymailWebsite()"
});
formatter.result({
  "duration": 11300,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "check given test on the webpage",
  "description": "",
  "id": "test-homepage-feature;check-given-test-on-the-webpage",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I am on the Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I can see webpage displays current date and time",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I can navigate to Sport menu",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I navigate Football subMenu and verify the colour of both menu",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I click on First article",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I can click on Gallery Icon and verify the image count",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I click on previous and next arrows buttons and verify it navigates to the appropriate gallery picture",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I click on the Facebook share icon and verify it opens Facebook modal dialog",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click on video embedded within the article and click the full screen button on the right-hand corner",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I can verify Premier League Table section and exhibit the points or positions from the Premier league table for the \"Liverpool\" team",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.iAmOnTheHomepage()"
});
formatter.result({
  "duration": 14300,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iCanSeeWebpageDisplaysCurrentDateAndTime()"
});
formatter.result({
  "duration": 29286800,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iCanNavigateToSportMenu()"
});
formatter.result({
  "duration": 75397815300,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iNavigateFootballSubMenuAndVerifyTheColourOfBothMenu()"
});
formatter.result({
  "duration": 28095048000,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iClickOnFirstArticle()"
});
formatter.result({
  "duration": 5162816600,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iCanClickOnGalleryIconAndVerifyTheImageCount()"
});
formatter.result({
  "duration": 854529400,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iClickOnPreviousAndNextArrowsButtonsAndVerifyItNavigatesToTheAppropriateGalleryPicture()"
});
formatter.result({
  "duration": 956014700,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iClickOnTheFacebookShareIconAndVerifyItOpensFacebookModalDialog()"
});
formatter.result({
  "duration": 2499617100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iClickOnVideoEmbeddedWithinTheArticleAndClickTheFullScreenButtonOnTheRightHandCorner()"
});
formatter.result({
  "duration": 64388382900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Liverpool",
      "offset": 117
    }
  ],
  "location": "MyStepdefs.iCanVerifyPremierLeagueTableSectionAndExhibitThePointsOrPositionsFromThePremierLeagueTableForTheTeam(String)"
});
formatter.result({
  "duration": 1339212000,
  "status": "passed"
});
formatter.after({
  "duration": 211500,
  "status": "passed"
});
});