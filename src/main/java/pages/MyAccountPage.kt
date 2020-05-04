package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class MyAccountPage(driver: WebDriver) : BasePageObject(driver) {

    fun getAccountInfoText(): String {
        return findElement(accountInfoCaption).text
    }

    fun getHeaderText(): String {
        return findElement(myAccountHeader).text
    }

    companion object {
        private val accountInfoCaption = By.xpath("//*[@class='info-account']")
        private val myAccountHeader = By.xpath("//*[@class='page-heading']")
    }
}