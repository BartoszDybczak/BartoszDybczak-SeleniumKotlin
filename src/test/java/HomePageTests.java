
import Base.TestUtilities;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


class HomePageTests extends TestUtilities {

    @Test
    public void assertContactNumberDisplayed() {
        HomePage homePage = new HomePage(driver, log);
        homePage.openHomePage();

        String expectedPhoneNumber = "0123-456-789";

        Assert.assertEquals(homePage.getPhoneNumberText(), expectedPhoneNumber);
    }

}



