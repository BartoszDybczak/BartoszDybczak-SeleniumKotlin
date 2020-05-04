package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.*

abstract class TestBase {

    lateinit var driver: WebDriver
        private set

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    fun setup(@Optional("chrome") browser: String) {

        if (browser == "chrome") {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver")
            driver = ChromeDriver()
        } else if (browser == "firefox") {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver")
            driver = FirefoxDriver()
        }

        driver?.manage()?.window()?.maximize()

    }

    @AfterMethod(alwaysRun = true)
    fun driverClose() {
        driver?.close();
    }
}