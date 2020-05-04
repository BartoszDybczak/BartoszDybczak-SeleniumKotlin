package logintests

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Test
import pages.HomePage

class SuccessfulLogin : TestBase() {

    @Test
    fun userCanLogIn() {

        val homePage = HomePage(driver)
        homePage.openHomePage()

        val signInPage = homePage.clickOnSignIn()
        signInPage.typeUsername("johnKowalski2137@wp.pl")
        signInPage.typePassword("tttttt")

        val myAccountPage = signInPage.clickOnLoginButton()

        Assert.assertTrue(myAccountPage.getAccountInfoText().contains("Welcome to your account."))
        Assert.assertEquals(myAccountPage.getHeaderText(), "My account".toUpperCase())
    }
}