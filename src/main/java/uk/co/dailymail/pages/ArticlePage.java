package uk.co.dailymail.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.co.dailymail.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArticlePage extends Utility {
    private static final Logger log = LogManager.getLogger(ArticlePage.class.getName());

    public ArticlePage() {
        PageFactory.initElements(driver, this);
    }

    static int tryCount;
    @CacheLookup
    @FindBy(xpath = "(//h2[@class='linkro-darkred']//a)[1]")
    WebElement firstArticleLink;
    @CacheLookup
    @FindBy(xpath = "(//button//div[contains(text(),'View gallery')])//preceding-sibling::div")
    WebElement galleryIcon;
    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='Next']")
    WebElement nextArrowOfGallery;
    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='Previous']")
    WebElement previousArrowOfGallery;
    @CacheLookup
    @FindBy(xpath = "//div[@class='counter-1RYOX']")
    WebElement insideImageCount;
    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement closeGalleryButton;

    @CacheLookup
    @FindBy(xpath = "(//li[@class='linkItem-2NXrW shareIcon-8A2dW'])[1]")
    WebElement shareIcon;

    @CacheLookup
    @FindBy(xpath = "(//li[@class='linkItem-2NXrW'])[1]")
    WebElement facebookIcon;
    @CacheLookup
    @FindBy(xpath = "//button//span[contains(text(),'Fullscreen')]")
    WebElement expandVideoButton;
    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='Skip Ad']")
    WebElement skipAd;
    @CacheLookup
    @FindBy(xpath = "//div[@style='min-width: 300px; min-height: 168.75px;']")
    WebElement expandVideoButton1;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='top']/div[@id='page-container']/div[@id='content']/div[4]/div[1]/div[1]/div[3]/div[4]/video-js[1]/div[7]/button[3]/span[1]")
    WebElement collapseVideoButton;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Football']")
    WebElement footballMenuTab;

    @CacheLookup
    @FindBy(xpath = "//table[@cellspacing='0']")
    WebElement pointTable;
    @CacheLookup
    @FindBy(xpath = "//table[@cellspacing='0']/tbody[1]/tr/td[5]")
    List<WebElement> pointList;
    @CacheLookup
    @FindBy(xpath = "//table[@cellspacing='0']/tbody[1]/tr/td[1]")
    List<WebElement> pointListNo;
    @CacheLookup
    @FindBy(xpath = "(//td[contains(text(),'Liverpool')]//ancestor::tr)[1]")
    WebElement teamDetails;


    public int clickOnFacebookIcon() throws InterruptedException {
        log.info("Click on Facebook ICon : " + shareIcon.toString());
        mouseHoverToElementAndClick(shareIcon);
        mouseHoverToElementAndClick(facebookIcon);
        Thread.sleep(2000);//To get exact windows count
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All windows :" + allHandles);
        return allHandles.size();
    }

    public void clickOnCloseButtonOfGallery() {
        log.info("Click on close button of Gallery : " + closeGalleryButton.toString());
        mouseHoverToElementAndClick(closeGalleryButton);
    }

    public void clickOnExpandVideoButton() throws InterruptedException {
        try {
            log.info("Click on Expand Video Button : ");
            JavascriptExecutor je = (JavascriptExecutor) driver;
            //Identify the WebElement which will appear after scrolling down
            WebElement element = driver.findElement(By.xpath("//div//video[@tabindex='-1']"));
            je.executeScript("window.scrollBy(0,550)", "");
            // now execute query which actually will scroll until that element is not appeared on page.
            je.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(3000);
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(By.xpath("//div//video[@tabindex='-1']"))).perform();
            //  je.executeScript("document.getElementById('ID').style.display='block';");
            System.out.println("Video found");
            try {
                clickOnElement(skipAd);
                actions.doubleClick(expandVideoButton);
            } catch (Exception e) {
                System.out.println("First expand video not worked :" + e);
            }
            try {
                expandVideoButton1.click();
            } catch (Exception e) {
                System.out.println("Second expand video not worked :" + e);
            }
        } catch (Exception e) {
            System.out.println("No video embedded within the article ");
        }
    }

    public int getImageCountFromGalleryIcon() {
        log.info("Get image count from gallery icon : " + galleryIcon.toString());
        String count = galleryIcon.getText().replace("+", "").replace("\n" +
                "View gallery", "");
        int imageCount = Integer.parseInt(count);
        return imageCount;
    }

    public int getImageCountFromInsideGallery() {
        log.info("Get image count from gallery icon : " + insideImageCount.toString());
        String count = insideImageCount.getText().replace("1 of ", "");
        int imageCount = Integer.parseInt(count);
        return imageCount - 1;
    }

    public int getImageCountFromInsideGalleryAfterClickNextArrow() {
        log.info("Get image count from gallery icon : " + insideImageCount.toString());
        String count = String.valueOf(insideImageCount.getText().charAt(0));
        int imageCount = Integer.parseInt(count);
        return imageCount;
    }

    public int getImageCountFromInsideGalleryAfterClickPreviousArrow() {
        log.info("Get image count from gallery icon : " + insideImageCount.toString());
        String count = String.valueOf(insideImageCount.getText().charAt(0));
        int imageCount = Integer.parseInt(count);
        return imageCount;
    }

    public void clickOnNextArrowOfGallery() {
        log.info("Click on Next Arrow of Gallery : " + nextArrowOfGallery.toString());
        clickOnElement(nextArrowOfGallery);
    }

    public void clickOnPreviousArrowOfGallery() {
        log.info("Click on Previous Arrow of Gallery : " + previousArrowOfGallery.toString());
        clickOnElement(previousArrowOfGallery);
    }

    public void clickOnGalleryIcon() {
        waitUntilVisibilityOfElementLocated(galleryIcon, 20);
        log.info("Click on Gallery Icon : " + galleryIcon.toString());

        mouseHoverToElementAndClick(galleryIcon);
    }

    public void clickOnFirstArticle() {
        try {
            mouseHoverToElementAndClick(firstArticleLink);
        } catch (Exception e) {
            System.out.println("First try :");
            tryCount = 1;
        }
        try {
            if (tryCount == 1) {
                WebElement element = driver.findElement(By.id("sliding-element-container"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='hidden'", element);
                mouseHoverToElementAndClick(firstArticleLink);
            }
        } catch (Exception e) {
            System.out.println("Second try article not clicked :");
            tryCount = 2;
        }
        try {
            if (tryCount == 2) {
                clickOnElement(footballMenuTab);
                mouseHoverToElementAndClick(firstArticleLink);
            }
        } catch (Exception e) {
            System.out.println("Third try Article Inside iframe :");
        }

    }


    public String getTeamDetails(String teamName) {
        By team = By.xpath("(//td[contains(text(),'" + teamName + "')]//ancestor::tr)[1]");
        log.info("Get team details : " + team.toString());
        System.out.println("Liverpool : " + getTextFromElement(team));
        return getTextFromElement(team);
    }

    public void getPointTable() {
        log.info("Point table : " + pointTable.toString());
        System.out.println("Point Table : " + pointTable.getText());

    }


    public void checkPointTable() {
        List<Double> point1 = new ArrayList<>();
        for (WebElement p :
                pointList) {
            point1.add(Double.parseDouble(p.getText()));
        }
        int n = point1.size();
        for (int i = 1; i <= n - 1; i++) {
            System.out.println(point1.get(i));
            //System.out.println(point1.get(i)> point1.get(i+1));
            Assert.assertTrue(point1.get(i - 1) >= point1.get(i), "Premier league table not in descending order");
        }
    }

    public void checkPointTableNo() {
        List<Double> point1 = new ArrayList<>();
        for (WebElement p :
                pointListNo) {
            point1.add(Double.parseDouble(p.getText()));
        }
        int n = point1.size();
        for (int i = 1; i <= n - 1; i++) {
            System.out.println(point1.get(i - 1));
            //System.out.println(point1.get(i)> point1.get(i+1));
            Assert.assertTrue(point1.get(i - 1) <= point1.get(i), "Premier league table number not in ascending order");
        }


    }

}
