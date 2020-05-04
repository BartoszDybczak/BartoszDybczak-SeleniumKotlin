package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class PaymentPage(driver: WebDriver) : BasePageObject(driver) {

    fun clickOnBankWirePayment() {
        clickOnElement(payByBankWireLocator)
    }

    fun clickOnConfirmOrderButton() {
        clickOnElement(confirmOrderButton)
    }

    fun getTotalPriceText(): String {
        return findElement(totalItemPriceLocator).text
    }

    fun getPayByBankWireText(): String {
        return findElement(payByBankWireLocator).text
    }

    fun getBankWireText(): String {
        return findElement(bankWire2TextLocator).text
    }

    fun getCompletedOrderText(): String {
        return findElement(completeOrderText).text
    }

    companion object {
        private val totalItemPriceLocator = By.id("total_price")
        private val payByBankWireLocator = By.xpath("//*[@title='Pay by bank wire']")
        private val bankWire2TextLocator = By.xpath("//strong[contains(text(),'You have chosen to pay by bank wire')]")
        private val confirmOrderButton = By.xpath("//button[@class='button btn btn-default button-medium']")
        private val completeOrderText = By.xpath("//strong[contains(text(),'Your order on My Store is complete')]")
    }
}