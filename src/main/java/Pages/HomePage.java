package Pages;

import Base.TestUtilities;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BasePageObject {

    private String pageUrl = "http://automationpractice.com/index.php";

    private By phoneNumberLocator = By.cssSelector("nav  strong");
    private By searchBarLocator = By.xpath("//input[@id='search_query_top']");
    private By searchButtonLocator = By.xpath("//button[@name='submit_search']");
    private By shortSleeveLocator = By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']");

    public HomePage(WebDriver driver, Logger log) {

        super(driver, log);
    }

    /**
     * Open HomePage with it's url
     */
    public void openHomePage() {
        log.info("Opening page " + pageUrl);
        openPage(pageUrl);
        log.info(pageUrl + " opened!");
    }


    public String getPhoneNumberText() {
        String phoneNumberText = findElement(phoneNumberLocator).getText();

        return phoneNumberText;
    }




}
