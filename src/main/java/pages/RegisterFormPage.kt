package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

class RegisterFormPage(driver: WebDriver) : BasePageObject(driver) {

    fun chooseGender() {
        waitForVisibilityOf(genderButtonLocator)
        clickOnElement(genderButtonLocator)
    }

    fun typeName(customerFirstName: String) {
        waitForVisibilityOf(customerFirstNameLocator)
        typeText(customerFirstName, customerFirstNameLocator)
    }

    fun typeLastName(customerLastName: String) {
        waitForVisibilityOf(customerLastNameLocator)
        typeText(customerLastName, customerLastNameLocator)
    }

    fun typePassword(password: String) {
        typeText(password, registerFormPasswordLocator)
    }

    fun selectBirthDay(value: String) {
        val daysDropdown = findElement(registerFormDayLocator)
        val dropdown = Select(daysDropdown)
        dropdown.selectByValue(value)
    }

    fun selectBirthMonth(value: String) {
        val monthDropdown = findElement(registerFormMonthLocator)
        val dropdown = Select(monthDropdown)
        dropdown.selectByValue(value)
    }

    fun selectBirthYear(value: String) {
        val yearDropdown = findElement(registerFormYearLocator)
        val dropdown = Select(yearDropdown)
        dropdown.selectByValue(value)
    }

    fun clickOnNewsletterCheckbox() {
        clickOnElement(newsletterCheckboxLocator)
    }

    fun clickOnSpecialOfferCheckbox() {
        clickOnElement(specialOffersCheckboxLocator)
    }

    fun typeAddress(address: String) {
        typeText(address, address1)
    }

    fun typeCity(cityName: String) {
        typeText(cityName, city)
    }

    fun selectCountry(value: String) {
        val countryDropdown = findElement(country)
        val dropdown = Select(countryDropdown)
        dropdown.selectByValue(value)
    }

    fun selectState(value: String) {
        val stateDropdown = findElement(state)
        val dropdown = Select(stateDropdown)
        dropdown.selectByValue(value)
    }

    fun typeMobilePhone(phoneNumber: String) {
        typeText(phoneNumber, mobilePhone)
    }

    fun typePostalCode(postalCode: String) {
        typeText(postalCode, postalCodeLocator)

    }

    fun clickOnSubmitButton(): MyAccountPage {
        clickOnElement(submitButton)

        return MyAccountPage(driver)
    }

    fun isGenderSelected(): Boolean {
        findElement(genderButtonLocator).isSelected

        return true
    }

    fun getEmailFromRegisterText(): String {
        return findElement(registerFormEmailLocator).getAttribute("value")
    }

    fun getFirstNameText(): String {
        return findElement(firstName).getAttribute("value")
    }

    fun getLastNameText(): String {
        return findElement(lastName).getAttribute("value")
    }

    fun getPasswordText(): String {
        return findElement(registerFormPasswordLocator).getAttribute("value")
    }

    fun getBirthDatText(): String {
        val daysDropdown = findElement(registerFormDayLocator)
        val dropdown = Select(daysDropdown)
        return dropdown.firstSelectedOption.text
    }

    fun getMonthText(): String {
        val monthDropdown = findElement(registerFormMonthLocator)
        val dropdown = Select(monthDropdown)
        return dropdown.firstSelectedOption.text
    }

    fun getYearText(): String {
        val yearDropdown = findElement(registerFormYearLocator)
        val dropdown = Select(yearDropdown)
        return dropdown.firstSelectedOption.text
    }

    fun getAddressText(): String {
        return findElement(address1).getAttribute("value")
    }

    fun getCityText(): String {
        return findElement(city).getAttribute("value")
    }

    fun getCountrySelectedText(): String {
        val countryDropdown = findElement(country)
        val dropdown = Select(countryDropdown)
        return dropdown.firstSelectedOption.text
    }

    fun getStateSelectedText(): String {
        val stateDropdown = findElement(state)
        val dropdown = Select(stateDropdown)
        return dropdown.firstSelectedOption.text
    }

    fun getPostCodeText(): String {
        return findElement(postalCodeLocator).getAttribute("value")
    }

    fun getMobilePhoneText(): String {
        return findElement(mobilePhone).getAttribute("value")
    }

    fun getAliasText(): String {
        return findElement(aliasAddress).getAttribute("value")
    }

    companion object {
        private val genderButtonLocator = By.id("uniform-id_gender1")
        private val customerFirstNameLocator = By.id("customer_firstname")
        private val customerLastNameLocator = By.id("customer_lastname")
        private val registerFormEmailLocator = By.id("email")
        private val registerFormPasswordLocator = By.id("passwd")
        private val registerFormDayLocator = By.id("days")
        private val registerFormMonthLocator = By.id("months")
        private val registerFormYearLocator = By.id("years")
        private val newsletterCheckboxLocator = By.id("newsletter")
        private val specialOffersCheckboxLocator = By.id("optin")
        private val firstName = By.id("firstname")
        private val lastName = By.id("lastname")
        private val address1 = By.id("address1")
        private val city = By.id("city")
        private val country = By.id("id_country")
        private val mobilePhone = By.id("phone_mobile")
        private val state = By.id("id_state")
        private val postalCodeLocator = By.id("postcode")
        private val aliasAddress = By.id("alias")
        private val submitButton = By.id("submitAccount")
    }
}