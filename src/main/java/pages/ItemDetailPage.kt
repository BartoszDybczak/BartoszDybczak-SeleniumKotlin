package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select

class ItemDetailPage(driver: WebDriver) : BasePageObject(driver) {

    fun openItemDetailPage() {
        openPage(pageUrl)
    }

    fun clickOnPlusButton() {
        waitForVisibilityOf(plusButtonLocator)
        clickOnElement(plusButtonLocator)
    }

    fun clickOnMinusButton() {
        waitForVisibilityOf(minusButtonLocator)
        clickOnElement(minusButtonLocator)
    }

    fun selectItemSize(itemSize: String) {
        waitFor(ExpectedConditions.presenceOfElementLocated(sizeDropdownLocator), 5)
        val dropdownElement = findElement(sizeDropdownLocator)

        val dropdown = Select(dropdownElement)
        dropdown.selectByVisibleText(itemSize)
    }

    fun clickOnTwitterButton() {
        clickOnElement(twitterButtonLocator)
    }

    fun clickOnTShirtsCategory(): TShirtsCategoryPage {
        clickOnElement(tShirtsCategoryLocator)

        return TShirtsCategoryPage(driver)
    }

    fun switchToTwitterWindow(): TwitterPopupPage {
        switchToWindowWithTitle("Post a Tweet on Twitter")

        return TwitterPopupPage(driver)
    }

    fun clickOnAddToCart() {
        clickOnElement(addToCartButtonLocator)
    }

    fun clickOnCloseButton() {
        waitForVisibilityOf(closeWindowLocator)
        clickOnElement(closeWindowLocator)
    }

    fun removeSelectedItemFromCart() {
        waitForVisibilityOf(shoppingCardPreviewLocator)
        hoverOverElement(findElement(shoppingCardPreviewLocator))

        waitFor(ExpectedConditions.elementToBeClickable(removeFromCartButtonLocator), 5)
        clickOnElement(removeFromCartButtonLocator)
    }

    fun clickOnProceedToCheckout(): OrderSummaryPage {
        waitForVisibilityOf(proceedToCheckoutButton)
        clickOnElement(proceedToCheckoutButton)

        return OrderSummaryPage(driver)
    }

    fun getPriceText(): String {
        waitForVisibilityOf(priceLocator)
        return findElement(priceLocator).text
    }

    fun getQuantityText(): String {
        waitForVisibilityOf(quantityLocator)
        return findElement(quantityLocator).getAttribute("value")
    }

    fun getSizeText(): String {
        val dropdownElement = findElement(sizeDropdownLocator)
        val dropdown = Select(dropdownElement)

        return dropdown.firstSelectedOption.text
    }

    fun getAddToCartText(): String {
        waitForVisibilityOf(addToCartText)
        return findElement(addToCartText).text
    }

    fun getOrderedItemQtyText(): String {
        waitForVisibilityOf(orderedItemQtyText)
        return findElement(orderedItemQtyText).text
    }

    fun getEmptyCartText(): String {
        waitForVisibilityOf(emptyCartText)
        return findElement(emptyCartText).text
    }

    companion object {
        private const val pageUrl = "http://automationpractice.com/index.php?id_product=1&controller=product"

        private val priceLocator = By.id("our_price_display")
        private val plusButtonLocator = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']")
        private val minusButtonLocator = By.xpath("//*[@class='btn btn-default button-minus product_quantity_down']")
        private val quantityLocator = By.xpath("//*[@id='quantity_wanted']")
        private val sizeDropdownLocator = By.id("group_1")
        private val twitterButtonLocator = By.xpath("//*[@class='btn btn-default btn-twitter']")
        private val tShirtsCategoryLocator = By.xpath("//*[@id='columns']/div[1]/a[4]")
        private val addToCartButtonLocator = By.id("add_to_cart")
        private val addToCartText = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")
        private val orderedItemQtyText = By.xpath("//*[@class='ajax_cart_product_txt ']")
        private val closeWindowLocator = By.xpath("//*[@title='Close window']")
        private val removeFromCartButtonLocator = By.xpath("//*[@class='ajax_cart_block_remove_link']")
        private val shoppingCardPreviewLocator = By.xpath("//*[@title='View my shopping cart']")
        private val emptyCartText = By.xpath("//*[@class='ajax_cart_no_product']")
        private val proceedToCheckoutButton = By.xpath("//*[@class='btn btn-default button button-medium']")
    }
}