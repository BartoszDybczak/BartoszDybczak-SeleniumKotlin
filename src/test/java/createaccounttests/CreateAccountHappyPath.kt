package createaccounttests

import base.TestBase
import org.testng.Assert
import org.testng.annotations.Test
import pages.SignInPage

class CreateAccountHappyPath : TestBase() {

    @Test
    fun userCanRegister() {
        val signInPage = SignInPage(driver)

        signInPage.openSignInPage()
        signInPage.createAccountEmail("johnKowalski21376@wp.pl")

        val registerFormPage = signInPage.clickOnCreateAccount()
        registerFormPage.chooseGender()

        Assert.assertTrue(registerFormPage.isGenderSelected())

        registerFormPage.typeName("John")
        registerFormPage.typeLastName("Kowalski")

        Assert.assertEquals(registerFormPage.getEmailFromRegisterText(), "johnKowalski21376@wp.pl")

        registerFormPage.typePassword("tttttt")
        Assert.assertEquals(registerFormPage.getPasswordText(), "tttttt")

        registerFormPage.selectBirthDay("2")
        Assert.assertEquals(registerFormPage.getBirthDatText(), "2  ")

        registerFormPage.selectBirthMonth("4")
        Assert.assertEquals(registerFormPage.getMonthText(), "April ")

        registerFormPage.selectBirthYear("2005")
        Assert.assertEquals(registerFormPage.getYearText(), "2005  ")

        registerFormPage.clickOnNewsletterCheckbox()
        registerFormPage.clickOnSpecialOfferCheckbox()

        Assert.assertEquals(registerFormPage.getFirstNameText(), "John")
        Assert.assertEquals(registerFormPage.getLastNameText(), "Kowalski")

        registerFormPage.typeAddress("Cherry Avn. 2")
        Assert.assertEquals(registerFormPage.getAddressText(), "Cherry Avn. 2")

        registerFormPage.typeCity("Las Vegas")
        Assert.assertEquals(registerFormPage.getCityText(), "Las Vegas")

        registerFormPage.selectCountry("21")
        Assert.assertEquals(registerFormPage.getCountrySelectedText(), "United States")

        registerFormPage.selectState("37")
        Assert.assertEquals(registerFormPage.getStateSelectedText(), "Oregon")

        registerFormPage.typePostalCode("02137")
        Assert.assertEquals(registerFormPage.getPostCodeText(), "02137")

        registerFormPage.typeMobilePhone("8822335566")
        Assert.assertEquals(registerFormPage.getMobilePhoneText(), "8822335566")

        Assert.assertEquals(registerFormPage.getAliasText(), "My address")

        val myAccountPage = registerFormPage.clickOnSubmitButton()

        Assert.assertTrue(myAccountPage.getAccountInfoText().contains("Welcome to your account."))
        Assert.assertEquals(myAccountPage.getHeaderText(), "My account".toUpperCase())
    }
}