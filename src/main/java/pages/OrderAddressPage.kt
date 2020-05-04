package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class OrderAddressPage(driver: WebDriver) : BasePageObject(driver) {

    fun clickOnProceedButton(): ShippingPage {
        clickOnElement(proceedButtonLocator)

        return ShippingPage(driver)
    }

    fun getNameText(): String {
        return findElement(lastNameFistName).text
    }

    fun getAddressText(): String {
        return findElement(addressLocator).text
    }

    fun getAddress2Text(): String {
        return findElement(address2Locator).text
    }

    fun getCountryText(): String {
        return findElement(countryLocator).text
    }

    fun getMobilePhoneText(): String {
        return findElement(mobilePhoneLocator).text
    }

    companion object {
        private val lastNameFistName = By.xpath("//*[@id='address_delivery']/li[@class='address_firstname address_lastname']")
        private val addressLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_address1 address_address2']")
        private val address2Locator = By.xpath("//*[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']")
        private val countryLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_country_name']")
        private val mobilePhoneLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_phone_mobile']")
        private val proceedButtonLocator = By.xpath("//*[@name='processAddress']")
    }
}