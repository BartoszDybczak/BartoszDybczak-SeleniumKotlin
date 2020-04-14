package Pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class HomePage(driver: WebDriver) : BasePageObject(driver) {

    companion object {
        private const val PAGE_URL = "http://automationpractice.com/index.php"
        private val phoneNumberLocator = By.cssSelector("nav  strong")
        private val searchBarLocator = By.xpath("//input[@id='search_query_top']")
        private val searchButtonLocator = By.xpath("//button[@name='submit_search']")
        private val shortSleeveLocator = By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']")
    }

    fun openHomePage() {
        openPage(PAGE_URL)
    }

    fun getPhoneNumberText(): String {
        val phoneNumberText = findElement(phoneNumberLocator)

        return phoneNumberText.text
    }
}