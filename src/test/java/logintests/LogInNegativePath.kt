package logintests

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test
import pages.HomePage

class LogInNegativePath : TestBase() {

    @Parameters("email", "password", "expectedMessage")
    @Test
    fun logInNegative(email: String, password: String, expectedMessage: String) {

        val homePage = HomePage(driver)

        homePage.openHomePage()

        val signInPage = homePage.clickOnSignIn()
        signInPage.typeUsername(email)
        signInPage.typePassword(password)
        signInPage.clickOnLoginButton()

        Assert.assertTrue(signInPage.getErrorText().contains(expectedMessage))
    }
}