package itemdetail

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import pages.ItemDetailPage

class ItemDetailTest : TestBase() {

    @Test
    fun userCanIncreaseItemQuantity() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.clickOnPlusButton()

        val expectedQty = "2"
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty)
    }

    @Test
    fun userCanDecreaseItemQuantity() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.clickOnPlusButton()
        itemDetailPage.clickOnMinusButton()

        val expectedQty = "1"
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty)
    }

    @Test
    fun userCanSelectItemSize() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.selectItemSize("M")

        val expectedSize = "M"
        Assert.assertEquals(itemDetailPage.getSizeText(), expectedSize)
    }

    @Test
    fun userCanShareItemOnTwitter() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.clickOnTwitterButton()
        val twitterPopupPage = itemDetailPage.switchToTwitterWindow()

        val expectedText = "Log in and Tweet"
        Assert.assertEquals(twitterPopupPage.getTwitterText(), expectedText)
    }

    @Test
    fun userCanNavigateToTShirtsCategory() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        val tShirtsCategoryPage = itemDetailPage.clickOnTShirtsCategory()

        val expectedText = "T-shirts"
        Assert.assertEquals(tShirtsCategoryPage.getTShirtsCategoryText(), expectedText)
    }

    @Test
    fun userCanAddItemToCart() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.clickOnAddToCart()

        val addToCartExpectedMsg = "Product successfully added to your shopping cart"
        val orderedItemsQtyExpectedMsg = "There is 1 item in your cart."
        Assert.assertEquals(itemDetailPage.getAddToCartText(), addToCartExpectedMsg)
        Assert.assertEquals(itemDetailPage.getOrderedItemQtyText(), orderedItemsQtyExpectedMsg)
    }

    @Test
    fun userCanRemoveItemFromCart() {
        val itemDetailPage = ItemDetailPage(driver)
        itemDetailPage.openItemDetailPage()

        itemDetailPage.clickOnAddToCart()
        itemDetailPage.clickOnCloseButton()
        itemDetailPage.removeSelectedItemFromCart()

        val emptyCartString = "(empty)"
        Assert.assertEquals(itemDetailPage.getEmptyCartText(), emptyCartString)
    }
}