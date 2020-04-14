import Base.TestUtilities
import Pages.HomePage
import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test

class HomePageTests(driver: WebDriver) : TestUtilities() {

    private val homePageRobot = HomePage(driver)

    @Test
    fun assertPhoneNumberDisplayed() {
        homePageRobot.openHomePage()

        val expectedPhoneNumber = "0123-456-789"

        Assert.assertEquals(homePageRobot.getPhoneNumberText(),expectedPhoneNumber)

    }

}