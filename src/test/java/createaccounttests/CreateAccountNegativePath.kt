package createaccounttests

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test
import pages.SignInPage

class CreateAccountNegativePath : TestBase() {

    @Parameters("email", "expectedMessage")
    @Test
    fun createAccountIncorrectPath(email: String, expectedMessage: String) {
        val signInPage = SignInPage(driver)

        signInPage.openSignInPage()
        signInPage.createAccountEmail(email)
        signInPage.clickOnCreateAccount()

        Assert.assertTrue(signInPage.getErrorText().contains(expectedMessage))
    }
}