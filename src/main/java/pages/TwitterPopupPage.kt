package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class TwitterPopupPage(driver: WebDriver) : BasePageObject(driver) {

    fun getTwitterText(): String {
        waitForVisibilityOf(twitterLoginButtonLocator)
        return findElement(twitterLoginButtonLocator).getAttribute("value")
    }

    companion object {
        private val twitterLoginButtonLocator = By.xpath("//*[@value='Log in and Tweet']")
    }
}