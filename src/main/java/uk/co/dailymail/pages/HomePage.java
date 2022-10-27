package uk.co.dailymail.pages;

import gherkin.lexer.Th;
import org.apache.commons.compress.utils.Lists;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.dailymail.utility.Utility;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Got it')]")
    WebElement acceptCookies;
    @CacheLookup
    @FindBy(css = "body div[id='top'] div[id='page-container'] div[class='page-header bdrgr2'] div[id='weather-wrapper'] strong:nth-child(1)")
    WebElement date;

    @CacheLookup
    @FindBy(xpath = "//div[@id='weather-wrapper'] //a//span[1]")
    WebElement timeRangeFirst;
    @CacheLookup
    @FindBy(xpath = "//div[@id='weather-wrapper'] //a//span[3]")
    WebElement timeRangeLast;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav-primary cleared bdrgr3 cnr5']//a[normalize-space()='Sport']")
    WebElement sportMenu;
    @CacheLookup
    @FindBy(xpath = "//div[@class='sport nav-secondary-container']//div[@class='nav-secondary wocc link-lccox cleared bdrgr3']")
    WebElement footballMenu;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Football']")
    WebElement footballMenuTab;


    public void clickOnSportMenu() {
        log.info("click on sport menu : " + sportMenu.toString());
        clickOnElement(sportMenu);
    }

    public void clickOnFootballMenu() {
        waitUntilVisibilityOfElementLocated(footballMenuTab, 20);
        log.info("click on football menu : " + footballMenuTab.toString());
        clickOnElement(footballMenuTab);
    }

    public String getFootballMenuColour() {
        log.info("Navigate to football submenu and get colour background : " + footballMenu.toString());
        return footballMenu.getCssValue("background-color");
    }

    public String getSportMenuColour() {
        log.info("Navigate to sport menu and get colour background : " + sportMenu.toString());
        return sportMenu.getCssValue("background-color");
    }

    public String getDateFromTheWebpage() {
        log.info("Get Date from the webpage :" + date.toString());
        String actualDate = date.getText().replace("nd ", "th ").replace("st ", "th ").replace("rd ", "th ");
        return actualDate;
    }

    public void clickOnGotItButtonToAcceptCookies() {
        log.info("Click on Got it button to accept cookies : " + acceptCookies.toString());
        clickOnElement(acceptCookies);
    }

}
