package Base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Optional
import org.testng.annotations.Parameters

open class TestBase(var driver: WebDriver) {


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    fun testSetUp(@Optional("chrome") browser: String) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver")
        driver = ChromeDriver()


    }

    @AfterMethod(alwaysRun = true)
    fun tearDown() {
        driver.quit()
    }
}