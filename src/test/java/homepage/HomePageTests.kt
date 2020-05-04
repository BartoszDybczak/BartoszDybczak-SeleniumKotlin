package homepage

import base.TestBase
import pages.HomePage
import org.testng.Assert
import org.testng.annotations.Test
import pages.SearchPage

class HomePageTests() : TestBase() {

    @Test
    fun userCanSeeContactNumber() {
        val homePage = HomePage(driver)
        homePage.openHomePage()

        val expectedPhoneNumber = "0123-456-789"
        Assert.assertEquals(homePage.getPhoneNumberText(), expectedPhoneNumber)
    }

    @Test
    fun userCanClickOnItemCard() {
        val homePage = HomePage(driver)
        homePage.openHomePage()
        val itemDetailPage = homePage.clickOnItemCard()

        val expectedPrice = "$16.51"
        Assert.assertEquals(itemDetailPage.getPriceText(), expectedPrice)
    }

    @Test
    fun userCanSearchForAnItem() {
        val homePage = HomePage(driver)
        val search = SearchPage(driver)

        homePage.openHomePage()
        search.searchForItem("dress")
        search.clickOnSearchButton()

        Assert.assertTrue(search.getProductListingText().contains("SEARCH"))

        val expectedItem = "\"DRESS\""
        Assert.assertEquals(search.getDressText(), expectedItem)

        val msg = "7 results have been found."
        Assert.assertEquals(search.getResultsFoundText(), msg)
    }

    @Test
    fun userCanWriteEmailMessage() {
        val homePage = HomePage(driver)
        homePage.openHomePage()

        val contactUsPage = homePage.clickOnContactUs()
        contactUsPage.selectSubject("Customer service")

        val subjectText = "Customer service"
        Assert.assertEquals(contactUsPage.getSubjectText(), subjectText)

        val customerServiceHeaderText = "Customer service - Contact us"
        Assert.assertEquals(contactUsPage.getCustomerServiceText(), customerServiceHeaderText.toUpperCase())

        contactUsPage.typeEmail("johnKowalski2137@wp.pl")

        val userEmail = "johnKowalski2137@wp.pl"
        Assert.assertEquals(contactUsPage.getEmailText(), userEmail)

        contactUsPage.typeOrder("X3670D")

        val userOrder = "X3670D"
        Assert.assertEquals(contactUsPage.getOrderText(), userOrder)

        val userMessage = "Generic message with complaint"

        contactUsPage.typeMessageText(userMessage)

        val userMessageText = "Generic message with complaint"
        Assert.assertTrue(contactUsPage.getUserMessageText().contains(userMessageText))

        contactUsPage.clickOnUploadFile()

        val fileName = "Rare pepe2.jpg"
        Assert.assertTrue(contactUsPage.getUploadedFileText().contains(fileName))

        contactUsPage.clickOnSubmitButton()

        val successMsg = "Your message has been successfully sent to our team."
        Assert.assertEquals(contactUsPage.getSuccessMessage(), successMsg)
    }
}