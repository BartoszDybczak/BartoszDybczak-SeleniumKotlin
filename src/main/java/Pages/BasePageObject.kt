package Pages

import Base.TestBase
import org.openqa.selenium.By
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePageObject(driver: WebDriver) : TestBase(driver) {

    fun openPage(pageUrl: String) {
        driver.get(pageUrl)
    }

    fun findElement(elementLocator: By): WebElement {
        return driver.findElement(elementLocator)
    }

    fun findAllElements(elementLocator: By): List<WebElement> {
        return driver.findElements(elementLocator)
    }

    fun clickOnElement(elementLocator: By) {
        findElement(elementLocator).click()
    }

    fun typeText(input: String, elementLocator: By) {

        findElement(elementLocator).sendKeys(input)
    }

    fun waitFor(condition: ExpectedCondition<WebElement>, timeOutInSeconds: Long?) {
        val wait = timeOutInSeconds?.let { WebDriverWait(driver, it) }

        wait?.until(condition)
    }

   fun waitForVisibilityOf(elementLocator: By, vararg timeOutInSeconds: Long) {
        var attempts = 0
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(elementLocator),
                        if (timeOutInSeconds.size > 0) timeOutInSeconds[0] else null)
                break
            } catch (e: StaleElementReferenceException) {
            }

            attempts++
        }
    }


}