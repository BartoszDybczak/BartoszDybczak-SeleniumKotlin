package Pages;

import Base.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;


    public BasePageObject(WebDriver driver, Logger log) {
    }

    /**
     * Open webpage with provided URL
     */
    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    /**
     * Find webpage element using provided locator
     */
    protected WebElement findElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    /**
     * Find all webpage elements using provided locator
     */
    protected List<WebElement> findAllElements(By elementLocator) {
        return driver.findElements(elementLocator);
    }

    protected void clickOnElement(By elementLocator) {

        findElement(elementLocator).click();
    }

    protected void typeText(String input, By locator) {
        waitForVisibilityOf(locator);

        findElement(locator).sendKeys(input);
    }

    /**
     * Wait for given ExpectedCondition for the  amount of time provided in seconds
     */
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 20;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By elementLocator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(elementLocator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    protected void HighLightElementUsingJavaScript(By locator) {
        WebElement element = findElement(locator);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')",
                element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        javascriptExecutor.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

    }

    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
