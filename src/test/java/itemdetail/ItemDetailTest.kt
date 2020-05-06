package itemdetail

import base.TestBase
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import pages.ItemDetailPage

class ItemDetailTest : TestBase() {

    private lateinit var itemDetailPage: ItemDetailPage

    @BeforeMethod
    fun setUp() {
        itemDetailPage = ItemDetailPage(driver)

        itemDetailPage.openItemDetailPage()
    }

    @Test
    fun userCanIncreaseItemQuantity() {
        itemDetailPage.clickOnPlusButton()

        val expectedQty = "2"
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty)
    }

    @Test
    fun userCanDecreaseItemQuantity() {
        itemDetailPage.clickOnPlusButton()
        itemDetailPage.clickOnMinusButton()

        val expectedQty = "1"
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty)
    }

    @Test
    fun userCanSelectItemSize() {
        itemDetailPage.selectItemSize("M")

        val expectedSize = "M"
        Assert.assertEquals(itemDetailPage.getSizeText(), expectedSize)
    }

    @Test
    fun userCanShareItemOnTwitter() {
        itemDetailPage.clickOnTwitterButton()
        val twitterPopupPage = itemDetailPage.switchToTwitterWindow()

        val expectedText = "Log in and Tweet"
        Assert.assertEquals(twitterPopupPage.getTwitterText(), expectedText)
    }

    @Test
    fun userCanNavigateToTShirtsCategory() {
        val tShirtsCategoryPage = itemDetailPage.clickOnTShirtsCategory()

        val expectedText = "T-shirts"
        Assert.assertEquals(tShirtsCategoryPage.getTShirtsCategoryText(), expectedText)
    }

    @Test
    fun userCanAddItemToCart() {
        itemDetailPage.clickOnAddToCart()

        val addToCartExpectedMsg = "Product successfully added to your shopping cart"
        val orderedItemsQtyExpectedMsg = "There is 1 item in your cart."
        Assert.assertEquals(itemDetailPage.getAddToCartText(), addToCartExpectedMsg)
        Assert.assertEquals(itemDetailPage.getOrderedItemQtyText(), orderedItemsQtyExpectedMsg)
    }

    @Test
    fun userCanRemoveItemFromCart() {
        itemDetailPage.clickOnAddToCart()
        itemDetailPage.clickOnCloseButton()
        itemDetailPage.removeSelectedItemFromCart()

        val emptyCartString = "(empty)"
        Assert.assertEquals(itemDetailPage.getEmptyCartText(), emptyCartString)
    }
}