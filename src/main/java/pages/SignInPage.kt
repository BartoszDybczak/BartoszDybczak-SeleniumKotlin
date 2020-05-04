package pages

import base.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SignInPage(driver: WebDriver) : BasePageObject(driver) {

    fun openSignInPage() {
        openPage(pageUrl)
    }

    fun createAccountEmail(username: String) {
        waitForVisibilityOf(createEmailLocator)

        typeText(username, createEmailLocator)
    }

    fun clickOnCreateAccount(): RegisterFormPage {
        clickOnElement(createAccountButton)

        return RegisterFormPage(driver)
    }

    fun typeUsername(username: String) {
        waitForVisibilityOf(logInEmail)

        typeText(username, logInEmail)
    }

    fun typePassword(password: String) {
        typeText(password, logInPassword)
    }

    fun clickOnLoginButton(): MyAccountPage {
        clickOnElement(loginButton)
        return MyAccountPage(driver)
    }

    fun getErrorText(): String {
        waitForVisibilityOf(accountErrorMessage)
        return findElement(accountErrorMessage).text
    }

    companion object {
        private const val pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account"

        private val createEmailLocator = By.id("email_create")
        private val createAccountButton = By.id("SubmitCreate")
        private val logInEmail = By.id("email")
        private val logInPassword = By.id("passwd")
        private val loginButton = By.id("SubmitLogin")
        private val accountErrorMessage = By.xpath("//ol/li")
    }
}