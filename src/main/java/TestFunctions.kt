import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import io.appium.java_client.AppiumBy
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebElement
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import org.testng.Assert
import users.TestUser
import users.UserData
import java.time.Duration
import java.util.*
import java.util.concurrent.TimeUnit


object TestFunctions {

    @Step("Нажатие на {elementName}")
    fun clickToElement(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType,
        elementName: String,
        findElementWithoutCatching: Boolean = false
    ) {
        // создаем глобальную функцию клика по элементу
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid,
            locatorTypeAndroid,
            locatorIOS,
            locatorTypeIOS
        )

        TimeUnit.SECONDS.sleep(1)
        val element = findElement(finalLocator, finalLocatorType, findElementWithoutCatching)
        element.click()
    }

    @Step("Ввод текста {text} в поле {elementName}")
    fun sendText(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        text: String,
        elementName: String,
    ) {
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType)
        element.sendKeys(text)
    }

    @Step("Очистка поля {elementName}")
    fun clearField(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        elementName: String
    ) {
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType)
        element.clear()
    }

    @Step("Вычисление координат {elementName}")
    fun coordinateCalc(
        element: WebElement
    ): Triple<Int, Int, Int> {
        val cordX = element.location.x + (element.size.width / 2)
        val cordY = element.location.y + (element.size.height / 2)
        val newCordX = element.location.x + (element.size.width / 4)
        return Triple(cordX, cordY, newCordX)
    }

    @Step("Вычисление координат Х для {elementName}")
    fun coordinateCalcForX(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        elementName: String,
        findElementWithoutCatching: Boolean = false
    ): Pair<Int, Int> {

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType, findElementWithoutCatching)
        val cordXLocation = element.location.x
        val cordXWidth = element.size.width
        return Pair(cordXLocation, cordXWidth)
    }

    @Step("Вычисление координат Y для {elementName}")
    fun coordinateCalcForY(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        elementName: String,
        findElementWithoutCatching: Boolean = false
    ): Pair<Int, Int> {

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )

        val element = findElement(finalLocator, finalLocatorType, findElementWithoutCatching)
        val cordYLocation = element.location.y
        val cordYHeight = element.size.height
        return Pair(cordYLocation, cordYHeight)
    }

   @Step("Нажатие по координатам х {cordX} у {cordX}")
    fun tapByCoordinates(cordX: Int, cordY: Int) {

        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)

        actions.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), cordX, cordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        } else {
            iosDriver.perform(listOf(actions))
        }
    }

    @Step("Свайп по экрану от х {startCordX} у {startCordX}, до {moveCordX} у {moveCordY}")
    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int) {

        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)

        actions.addAction(
            (finger.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                startCordX,
                startCordY
            ))
        )
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(Pause(finger, Duration.ofMillis(600)))
        actions.addAction(
            finger.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                moveCordX,
                moveCordY
            )
        )
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        } else {
            iosDriver.perform(listOf(actions))
        }
    }

    @Step("Проверка наличия элемента {elementName}")
    fun checkAvailableElement(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        elementName: String,
        findElementWithoutCatching: Boolean = false
    ): Boolean {

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )

        val element = findElement(finalLocator, finalLocatorType, findElementWithoutCatching)
        return element.isEnabled
    }

    @Step("Выбор ввода необходимого набора данных пользователя")
    fun checkWhichUserData(
        element1: String?, element2: String?, element3: String?
    ): UserData {
        // по хорошему нужно пернести данную функцию в addressPage
        if (
            element1 == TestUser.testUserForRegistration.name &&
            element2 == TestUser.testUserForRegistration.email &&
            element3 == TestUser.testUserForRegistration.instagram
        ) {
            return TestUser.testUserForRegistrationAnother
        } else {
            return TestUser.testUserForRegistration
        }
    }

    @Step("Поиск артрибута текста")
    fun getAttributeText(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        findElementWithoutCatching: Boolean = false
    ): String? {

        if (platformType == TypeOS.IOS) {
            return findElement(locatorIOS, locatorTypeIOS, findElementWithoutCatching).getAttribute("value")
        } else {
            return findElement(locatorAndroid, locatorTypeAndroid, findElementWithoutCatching).getAttribute("text")
        }
    }

    fun platformCheck(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ): Pair<String, LocatorType> {

        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }
        return Pair(finalLocator, finalLocatorType)
    }

    fun findElement(
        locator: String,
        locatorType: LocatorType,
        findElementWithoutCatching: Boolean = false
    ): WebElement {
        lateinit var element: WebElement

        if (findElementWithoutCatching) {
            when (locatorType) {
                LocatorType.ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.id(locator))
                    } else iosDriver.findElement(AppiumBy.id(locator))
                }

                LocatorType.XPATH -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.xpath(locator))
                    } else iosDriver.findElement(AppiumBy.xpath(locator))
                }

                LocatorType.ACCESSIBILITY_ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.accessibilityId(locator))
                    } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                }

                LocatorType.CLASS_NAME -> {
                    if (platformType == TypeOS.ANDROID) {
                        element = androidDriver.findElement(AppiumBy.className(locator))
                    } else element = iosDriver.findElement(AppiumBy.className(locator))
                }

                LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                LocatorType.IOS_PREDICATE_STRING -> element =
                    iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                else -> {}
            }
        } else {
            runCatching {
                when (locatorType) {
                    LocatorType.ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.id(locator))
                        } else iosDriver.findElement(AppiumBy.id(locator))
                    }

                    LocatorType.XPATH -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.xpath(locator))
                        } else iosDriver.findElement(AppiumBy.xpath(locator))
                    }

                    LocatorType.ACCESSIBILITY_ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.accessibilityId(locator))
                        } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                    }

                    LocatorType.CLASS_NAME -> {
                        if (platformType == TypeOS.ANDROID) {
                            element = androidDriver.findElement(AppiumBy.className(locator))
                        } else element = iosDriver.findElement(AppiumBy.className(locator))
                    }

                    LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                    LocatorType.IOS_PREDICATE_STRING -> element =
                        iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                    else -> {}
                }
            }.onSuccess {

            }.onFailure {
                makeScreenshotOfScreen(Date().toString())
                Assert.fail("Элемент не был найден по локатору - $locator")
            }
        }

        return element
    }

    @Attachment(value = "Screenshot - {dateOnSystem}", type = "image/png")
    fun makeScreenshotOfScreen(dateOnSystem: String?): ByteArray {
        return if (platformType == TypeOS.IOS) {
            (iosDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)
        } else (androidDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)

        // использование - makeScreenshotOfScreen(String.valueOf(new Date()))
    }
}
