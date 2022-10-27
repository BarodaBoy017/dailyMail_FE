package uk.co.dailymail.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import uk.co.dailymail.pages.ArticlePage;
import uk.co.dailymail.pages.HomePage;
import uk.co.dailymail.utility.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertThat;

public class MyStepdefs {

    @Given("^I open the given URL in browser$")
    public void iOpenTheGivenURLInBrowser() {

    }

    @Then("^I am on the homepage of dailymail website$")
    public void iAmOnTheHomepageOfDailymailWebsite() {
    }

    @And("^I accept the cookies$")
    public void iAcceptTheCookies() {
        new HomePage().clickOnGotItButtonToAcceptCookies();
    }

    @Given("^I am on the Homepage$")
    public void iAmOnTheHomepage() {

    }

    @When("^I can see webpage displays current date and time$")
    public void iCanSeeWebpageDisplaysCurrentDateAndTime() throws ParseException {
        Assert.assertEquals("Date is not matched with current date : ", Utility.currentDate(), new HomePage().getDateFromTheWebpage());
    }

    @And("^I can navigate to Sport menu$")
    public void iCanNavigateToSportMenu() {
        new HomePage().clickOnSportMenu();
    }

    @Then("^I navigate Football subMenu and verify the colour of both menu$")
    public void iNavigateFootballSubMenuAndVerifyTheColourOfBothMenu() throws InterruptedException {
        Assert.assertEquals("Color not matched", new HomePage().getSportMenuColour(), new HomePage().getFootballMenuColour());
        new HomePage().clickOnFootballMenu();
    }

    @And("^I click on First article$")
    public void iClickOnFirstArticle() {
        new ArticlePage().clickOnFirstArticle();

    }

    @Then("^I can click on Gallery Icon and verify the image count$")
    public void iCanClickOnGalleryIconAndVerifyTheImageCount() {
        int imageCountOnGalleryIcon = new ArticlePage().getImageCountFromGalleryIcon();

        new ArticlePage().clickOnGalleryIcon();
        int imageCountFromInsideGallery = new ArticlePage().getImageCountFromInsideGallery();
        Assert.assertEquals("Image count not matched : ", imageCountOnGalleryIcon, imageCountFromInsideGallery);
    }

    @And("^I click on previous and next arrows buttons and verify it navigates to the appropriate gallery picture$")
    public void iClickOnPreviousAndNextArrowsButtonsAndVerifyItNavigatesToTheAppropriateGalleryPicture() {

        new ArticlePage().clickOnNextArrowOfGallery();
        int imageCountFromInsideGalleryAfterClickOnNextArrow = new ArticlePage().getImageCountFromInsideGalleryAfterClickNextArrow();
        new ArticlePage().clickOnPreviousArrowOfGallery();
        int imageCountFromInsideGalleryAfterClickOnPreviousArrow = new ArticlePage().getImageCountFromInsideGalleryAfterClickPreviousArrow();
        Assert.assertEquals("Image not changed after Click on next count : ", 2, imageCountFromInsideGalleryAfterClickOnNextArrow);
        Assert.assertEquals("Image not changed after Click on previous count : ", 1, imageCountFromInsideGalleryAfterClickOnPreviousArrow);
        new ArticlePage().clickOnCloseButtonOfGallery();

    }

    @And("^I click on the Facebook share icon and verify it opens Facebook modal dialog$")
    public void iClickOnTheFacebookShareIconAndVerifyItOpensFacebookModalDialog() throws InterruptedException {
        Assert.assertEquals("Facebook share page not opened : ", 2, new ArticlePage().clickOnFacebookIcon());

    }

    @And("^I click on video embedded within the article and click the full screen button on the right-hand corner$")
    public void iClickOnVideoEmbeddedWithinTheArticleAndClickTheFullScreenButtonOnTheRightHandCorner() throws InterruptedException {
        new ArticlePage().clickOnExpandVideoButton();
    }

    @Then("^I can verify Premier League Table section and exhibit the points or positions from the Premier league table for the \"([^\"]*)\" team$")
    public void iCanVerifyPremierLeagueTableSectionAndExhibitThePointsOrPositionsFromThePremierLeagueTableForTheTeam(String teamName) throws Throwable {
        new ArticlePage().getPointTable();
        new ArticlePage().checkPointTable();//check descending order of Premier league table
        new ArticlePage().checkPointTableNo();//check numbering of team
        Assert.assertTrue(teamName + " not found in Premier League Table : ", new ArticlePage().getTeamDetails(teamName).contains(teamName));
    }
}
