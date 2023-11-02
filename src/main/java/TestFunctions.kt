import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import io.appium.java_client.AppiumBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import users.TestUser
import users.UserData
import java.time.Duration
import java.util.concurrent.TimeUnit

object TestFunctions {

    fun clickToElement(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ){
        // создаем глобальную функцию клика по элементу
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid,
            locatorTypeAndroid,
            locatorIOS,
            locatorTypeIOS
        )

        TimeUnit.SECONDS.sleep(1)
        val element = findElement(finalLocator, finalLocatorType)
        element.click()
    }

    fun sendText(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        text: String
    ){
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType)
        element.sendKeys(text)
    }

    fun clearField(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
        ){
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType)
        element.clear()
    }

    fun coordinateCalc(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
    ): Triple<Int, Int, Int> {
        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
            val element = findElement(finalLocator, finalLocatorType)
            // посоветоваться, как это можно оптимизировать под большие сценарии, а не только сдвиг влево
            // Пока что считаю лучшим сделать две функции (для х и для у) вовзвращающие длину/ширину и расположение)
            //val elementHeight = androidDriver.manage().window().size.getHeight()
            //val elementWidth = androidDriver.manage().window().size.getWidth()
            val cordX = element.location.x + (element.size.width / 2)
            val cordY = element.location.y + (element.size.height / 2)
            val newCordX = element.location.x + (element.size.width / 4)
            return Triple(cordX, cordY, newCordX)
    }

    fun coordinateCalcForX(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
    ): Pair<Int, Int> {

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )
        val element = findElement(finalLocator, finalLocatorType)
        // посоветоваться, как это можно оптимизировать под большие сценарии, а не только сдвиг влево
        // Пока что считаю лучшим сделать две функции (для х и для у) вовзвращающие длину/ширину и расположение)
        //val elementHeight = androidDriver.manage().window().size.getHeight()
        //val elementWidth = androidDriver.manage().window().size.getWidth()
        val cordXLocation = element.location.x
        val cordXWidth = element.size.width
        return Pair(cordXLocation, cordXWidth)
    }

    fun coordinateCalcForY(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType,
    ): Pair<Int, Int> {

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )

        val element = findElement(finalLocator, finalLocatorType)
        // посоветоваться, как это можно оптимизировать под большие сценарии, а не только сдвиг влево
        // Пока что считаю лучшим сделать две функции (для х и для у) вовзвращающие длину/ширину и расположение)
        //val elementHeight = androidDriver.manage().window().size.getHeight()
        //val elementWidth = androidDriver.manage().window().size.getWidth()
        val cordYLocation = element.location.y
        val cordYHeight = element.size.height
        return Pair(cordYLocation, cordYHeight)
    }

    /*fun takeCheckCode(){
        val text = androidDriver.pageSource
        //(Введите код из смс&#10; начало), (конец &#10;), сдвиг по ключевым символам/словам
        val textOne = text.substringAfter("Введите код из смс&#10;")
        val textTwo = textOne.substringBefore('&')
    }*/

    fun tapByCoordinates(cordX: Int, cordY: Int) {

        val finger = PointerInput(PointerInput.Kind.TOUCH,"finger")
        val actions = Sequence(finger,1) // сиквенция из силениума

        actions.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), cordX, cordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        }
        else {
            iosDriver.perform(listOf(actions))
        }
    }

    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int){

        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger,1)

        actions.addAction((finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startCordX, startCordY)))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(Pause(finger, Duration.ofMillis(600)))
        actions.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), moveCordX, moveCordY))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        }
        else {
            iosDriver.perform(listOf(actions))
        }
    }

    fun checkAvailableElement(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType
    ): Boolean{

        val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        )

        val element = findElement(finalLocator, finalLocatorType)
        return element.isEnabled
    }

    fun checkWhichUserData(element1: String?, element2: String?, element3: String?): UserData {

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

    fun getAttributeText(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ): String? {

        if (platformType == TypeOS.IOS) {
            return findElement(locatorIOS, locatorTypeIOS).getAttribute("value")
        } else {
            return findElement(locatorAndroid, locatorTypeAndroid).getAttribute("text")
        }
    }

    fun platformCheck(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ) : Pair<String, LocatorType> {

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

    fun findElement(locator: String, locatorType: LocatorType) : WebElement {
        TimeUnit.SECONDS.sleep(2)
        lateinit var element: WebElement
        when (locatorType) {
            LocatorType.ID -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.id(locator))
                } else element = iosDriver.findElement(AppiumBy.id(locator))
            }

            LocatorType.XPATH -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.xpath(locator))
                } else element = iosDriver.findElement(AppiumBy.xpath(locator))
            }

            LocatorType.ACCESSIBILITY_ID -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.accessibilityId(locator))
                } else element = iosDriver.findElement(AppiumBy.accessibilityId(locator))
            }

            LocatorType.CLASS_NAME -> {
                if (platformType == TypeOS.ANDROID) {
                    element = androidDriver.findElement(AppiumBy.className(locator))
                } else element = iosDriver.findElement(AppiumBy.className(locator))
            }

            LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
            LocatorType.IOS_PREDICATE_STRING -> element = iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))
            else -> {}
        }
        return element
    }

    }
