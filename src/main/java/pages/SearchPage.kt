package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SearchPage(driver: WebDriver) : BasePageObject(driver) {

    fun searchForItem(itemName: String) {
        typeText(itemName, searchBarLocator)
    }

    fun clickOnSearchButton() {
        clickOnElement(searchButtonLocator)
    }

    fun getProductListingText(): String {
        waitForVisibilityOf(searchLocator)

        return findElement(searchLocator).text
    }

    fun getDressText(): String {
        waitForVisibilityOf(dressTextLocator)

        return findElement(dressTextLocator).text
    }

    fun getResultsFoundText(): String {
        waitForVisibilityOf(searchResultsLocator)

        return findElement(searchResultsLocator).text
    }

    companion object {
        private val searchBarLocator = By.id("search_query_top")
        private val searchButtonLocator = By.xpath("//*[@class='btn btn-default button-search']")
        private val searchLocator = By.xpath("//*[@class='page-heading  product-listing']")
        private val dressTextLocator = By.xpath("//*[@class='lighter']")
        private val searchResultsLocator = By.xpath("//*[@class='heading-counter']")
    }
}