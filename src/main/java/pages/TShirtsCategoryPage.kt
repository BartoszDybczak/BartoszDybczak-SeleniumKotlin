package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class TShirtsCategoryPage(driver: WebDriver) : BasePageObject(driver) {

    fun getTShirtsCategoryText(): String {
        waitForVisibilityOf(tShirtsText)
        return findElement(tShirtsText).text
    }

    companion object {
        private val tShirtsText = By.xpath("//*[@class='category-name']")
    }

}