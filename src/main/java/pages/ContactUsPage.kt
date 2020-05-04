package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select

class ContactUsPage(driver: WebDriver) :  BasePageObject(driver) {

    fun selectSubject(text: String) {
        waitFor(ExpectedConditions.presenceOfElementLocated(dropdownId), 5)
        val subjectHeader = findElement(dropdownId)

        val subjectDropdown = Select(subjectHeader)
        subjectDropdown.selectByVisibleText(text)
    }

    fun typeEmail(userMail: String) {
        typeText(userMail, userMailLocator)
    }

    fun typeOrder(orderText: String) {
        typeText(orderText, userOrderLocator)
    }

    fun typeMessageText(messageText: String) {
        typeText(messageText, messageLocator)
    }

    fun clickOnUploadFile() {
        val filePath = "/Users/bartosz.dybczak/Desktop/Rare pepe2.jpg"
        typeText(filePath, fileUploadLocator)
    }

    fun clickOnSubmitButton() {
        clickOnElement(submitButtonId)
    }

    fun getCustomerServiceText(): String {
        waitForVisibilityOf(customerServiceHeaderLocator)
        return findElement(customerServiceHeaderLocator).text
    }

    fun getSuccessMessage(): String {
        waitForVisibilityOf(successMessageLocator)
        return findElement(successMessageLocator).text
    }

    fun getEmailText(): String {
        waitForVisibilityOf(userMailLocator)
        return findElement(userMailLocator).getAttribute("value")
    }

    fun getOrderText(): String {
        waitForVisibilityOf(userOrderLocator)
        return findElement(userOrderLocator).getAttribute("value")
    }

    fun getUserMessageText(): String {
        waitForVisibilityOf(messageLocator)
        return findElement(messageLocator).getAttribute("value")
    }

    fun getSubjectText(): String {
        val dropdownElement = findElement(dropdownId)
        val dropdown = Select(dropdownElement)
        return dropdown.firstSelectedOption.text
    }

    fun getUploadedFileText(): String {
        return findElement(fileUploadLocator).getAttribute("value")
    }

    companion object {
        private val customerServiceHeaderLocator = By.xpath("//*[@class='page-heading bottom-indent']")
        private val dropdownId = By.id("id_contact")
        private val userMailLocator = By.id("email")
        private val userOrderLocator = By.id("id_order")
        private val messageLocator = By.id("message")
        private val fileUploadLocator = By.id("fileUpload")
        private val submitButtonId = By.id("submitMessage")
        private val successMessageLocator = By.xpath("//*[@class='alert alert-success']")
    }
}