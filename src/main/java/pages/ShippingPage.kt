package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ShippingPage(driver: WebDriver) : BasePageObject(driver) {

    fun clickOnTermsOfService() {
        clickOnElement(termsOfServiceLocator)
    }

    fun clickOnProceedButton(): PaymentPage {
        clickOnElement(proceedButton)
        return PaymentPage(driver)
    }

    fun isTermsOfServiceChecked(): Boolean {
        findElement(termsOfServiceLocator).isSelected
        return true
    }

    fun getShippingText(): String {
        return findElement(shippingPriceLocator).text
    }

    companion object {
        private val termsOfServiceLocator = By.id("cgv")
        private val shippingPriceLocator = By.xpath("//div[@class='delivery_option_price']")
        private val proceedButton = By.xpath("//*[@name='processCarrier']")
    }
}