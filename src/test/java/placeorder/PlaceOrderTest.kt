package placeorder

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Test
import pages.ItemDetailPage
import pages.OrderAddressPage

class PlaceOrderTest : TestBase() {
    @Test
    fun userCanPlaceOrder() {
        val itemDetailPage = ItemDetailPage(driver)

        itemDetailPage.openItemDetailPage()
        itemDetailPage.clickOnAddToCart()

        val orderSummaryPage = itemDetailPage.clickOnProceedToCheckout()
        orderSummaryPage.clickOnPlusButton()

        Assert.assertEquals(orderSummaryPage.getOrderQuantityValue(), "2")
        Assert.assertEquals(orderSummaryPage.getItemTotalPrice(), "$33.02")
        Assert.assertEquals(orderSummaryPage.getSummaryText(), "01. Summary")

        val signInPage = orderSummaryPage.clickOnProceedToCheckout()
        signInPage.typeUsername("johnKowalski2137@wp.pl")
        signInPage.typePassword("tttttt")
        signInPage.clickOnLoginButton()

        val orderAddressPage = OrderAddressPage(driver)

        Assert.assertEquals(orderAddressPage.getNameText(), "John Kowalski")
        Assert.assertEquals(orderAddressPage.getAddressText(), "Cherry Avn. 2")
        Assert.assertEquals(orderAddressPage.getAddress2Text(), "Las Vegas, Oregon 02137")
        Assert.assertEquals(orderAddressPage.getCountryText(), "United States")
        Assert.assertEquals(orderAddressPage.getMobilePhoneText(), "8822335566")

        val shippingPage = orderAddressPage.clickOnProceedButton()
        shippingPage.clickOnTermsOfService()

        Assert.assertTrue(shippingPage.isTermsOfServiceChecked())
        Assert.assertEquals(shippingPage.getShippingText(), "$2.00")

        val paymentPage = shippingPage.clickOnProceedButton()

        Assert.assertEquals(paymentPage.getTotalPriceText(), "$35.02")
        Assert.assertTrue(paymentPage.getPayByBankWireText().contains("Pay by bank wire"))

        paymentPage.clickOnBankWirePayment()

        Assert.assertTrue(paymentPage.getBankWireText().contains("You have chosen to pay by bank wire."))

        paymentPage.clickOnConfirmOrderButton()

        Assert.assertTrue(paymentPage.getCompletedOrderText().contains("Your order on My Store is complete."))
    }
}