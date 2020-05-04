package pages

import base.BasePageObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class HomePage(driver: WebDriver) : BasePageObject(driver)  {

    fun openHomePage() {
       openPage(HOME_PAGE_URL)
    }

    fun clickOnItemCard(): ItemDetailPage {
        clickOnElement(shortSleeveLocator)

        return ItemDetailPage(driver)
    }

    fun clickOnContactUs(): ContactUsPage {
        clickOnElement(contactUs)

        return ContactUsPage(driver)
    }

    fun clickOnSignIn(): SignInPage {
        clickOnElement(signInLocator)

        return SignInPage(driver)
    }

    fun getPhoneNumberText(): String {
       return findElement(phoneNumberLocator).text
    }

    init {
        PageFactory.initElements(driver, this)
    }

    companion object {
        private const val HOME_PAGE_URL = "http://automationpractice.com/index.php"

        private val phoneNumberLocator = By.cssSelector("nav  strong")
        private val shortSleeveLocator = By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']")
        private val contactUs = By.xpath("//*[@title='Contact Us']")
        private val signInLocator = By.xpath("//*[@title='Log in to your customer account']")

    }
}