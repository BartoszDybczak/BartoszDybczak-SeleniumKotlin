package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class OrderSummaryPage(driver: WebDriver) : BasePageObject(driver) {

    fun clickOnPlusButton() {
        clickOnElement(plusButtonLocator)
    }

    fun clickOnProceedToCheckout(): SignInPage {
        waitForVisibilityOf(proceedToCheckout)
        clickOnElement(proceedToCheckout)
        return SignInPage(driver)
    }

    fun getItemTotalPrice(): String {
        waitForVisibilityOf(itemPriceLocator)
        return findElement(itemPriceLocator).text
    }

    fun getSummaryText(): String {
        return findElement(summaryHeaderLocator).text
    }

    fun getOrderQuantityValue(): String {
        val wait = WebDriverWait(driver, 5)
        wait.until(ExpectedConditions.attributeContains(findElement(itemQuantityLocator), "value", "2"))

        return findElement(itemQuantityLocator).getAttribute("value")
    }

    companion object {
        private val plusButtonLocator = By.xpath("//*[@class='cart_quantity_up btn btn-default button-plus']")
        private val itemQuantityLocator = By.xpath("//*[@class='cart_quantity_input form-control grey']")
        private val itemPriceLocator = By.xpath("//*[@class='cart_total']")
        private val summaryHeaderLocator = By.xpath("//*[@class='step_current  first']")
        private val proceedToCheckout = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1'][@title='Proceed to checkout']")
    }
}