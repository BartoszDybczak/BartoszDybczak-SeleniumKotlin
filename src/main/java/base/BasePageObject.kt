package base

import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePageObject(val driver: WebDriver) {

    fun openPage(pageUrl: String) {
        driver.get(pageUrl)
    }

    fun findElement(elementLocator: By): WebElement {
        return driver.findElement(elementLocator)
    }

    fun findAllElements(elementLocator: By): List<WebElement> {
        return driver.findElements(elementLocator)
    }

    fun clickOnElement(elementLocator: By) {
        findElement(elementLocator).click()
    }

    fun typeText(input: String, locator: By) {
        findElement(locator).sendKeys(input)
    }

    fun getCurrentUrl(): String {
        return driver.currentUrl
    }

    fun getCurrentPageTitle(): String {
        return driver.title
    }

    fun getCurrentPageSource(): String {
        return driver.pageSource
    }

    fun waitFor(condition: ExpectedCondition<WebElement>, timeOutInSeconds: Int?) {
        var timeOutInSeconds = timeOutInSeconds
        timeOutInSeconds = timeOutInSeconds ?: 5
        val wait = WebDriverWait(driver, timeOutInSeconds.toLong())

        wait.until(condition)
    }

    fun waitForVisibilityOf(elementLocator: By, vararg timeOutInSeconds: Int) {
        var attempts = 0
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(elementLocator),
                        if (timeOutInSeconds.isNotEmpty()) timeOutInSeconds[0] else null)
                break
            } catch (e: StaleElementReferenceException) {
            }
            attempts++
        }
    }

    fun switchToAlert(): Alert {
        val wait = WebDriverWait(driver, 5)
        wait.until(ExpectedConditions.alertIsPresent())
        return driver.switchTo().alert()
    }

    fun switchToWindowWithTitle(expectedTitle: String) {
        val firstWindow = driver.windowHandle

        val allWindows = driver.windowHandles
        val windowsIterator = allWindows.iterator()

        while (windowsIterator.hasNext()) {
            val windowHandle = windowsIterator.next().toString()
            if (windowHandle != firstWindow) {
                driver.switchTo().window(windowHandle)
                if (getCurrentPageTitle() == expectedTitle) {
                    break
                }
            }
        }
    }


    fun highLightElementUsingJavaScript(locator: By) {
        val element = findElement(locator)

        val javascriptExecutor = driver as JavascriptExecutor

        javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')",
                element)

        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {

            println(e.message)
        }

        javascriptExecutor.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element)
    }

    fun hoverOverElement(element: WebElement) {
        val action = Actions(driver)
        action.moveToElement(element).build().perform()
    }

    protected fun switchToFrame(frameLocator: By) {
        driver.switchTo().frame(findElement(frameLocator))
    }

    fun pressKey(locator: By, key: Keys) {
        findElement(locator).sendKeys(key)
    }

    fun pressKeyWithActions(key: Keys) {
        val action = Actions(driver)
        action.sendKeys(key).build().perform()
    }

    fun scrollToBottom() {
        val jsExecutor = driver as JavascriptExecutor
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)")
    }

    protected fun performDragAndDrop(from: By, to: By) {
        // Actions action = new Actions(driver);
        // action.dragAndDrop(find(from), find(to)).build().perform();

        val jsExecutor = driver as JavascriptExecutor
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                findElement(from), findElement(to))
    }

    fun setCookie(cookie: Cookie) {
        driver.manage().addCookie(cookie)
    }

    fun getCookie(name: String): String {
        return driver.manage().getCookieNamed(name).value
    }
}