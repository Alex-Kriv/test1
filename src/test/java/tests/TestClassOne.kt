package tests

import GlobalVarlables.androidDriver
import LocatorType
import MainActivity
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.coordinateCalc
import TestFunctions.findElement
import TestFunctions.sendText
import TestFunctions.swipeOnScreen
import TestFunctions.tapByCoordinates
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import users.TestUser.testUserForRegistration
import org.testng.annotations.Test
import screens.AddressPage
import screens.AddressPage.addNewAddress
import screens.AddressPage.addNewAddressSecond
import screens.AddressPage.addressButton
import screens.AddressPage.addressTextBox
import screens.AddressPage.apartNumber
import screens.AddressPage.checkAddressInPage
import screens.AddressPage.commentAddress
import screens.AddressPage.deleteAddressButton
import screens.AddressPage.entrance
import screens.AddressPage.floor
import screens.AddressPage.intercom
import screens.AddressPage.myAddressPage
import screens.AddressPage.popUpPage
import screens.AddressPage.saveAddressButton
import screens.MainPage.hotDishButton
import screens.MainPage.mainPageButton
import screens.MainPage.pastaButton
import screens.MainPage.sandwichButton
import screens.MainPage.snacksButton
import screens.MainPage.soupsButton
import screens.MenuPage.menuPageButton
import screens.Profile.enteringNumberBox
import screens.Profile.exitButton
import screens.Profile.logInButton
import screens.Profile.paymentMethod
import screens.Profile.profileButton
import screens.Profile.sendCodeField
import screens.Profile.takeCodeButton
import java.util.concurrent.TimeUnit


class TestClassOne :MainActivity() {

    @Test
    // при создании двух одинаковых тестов почему-то падают остальные с ошибкой (не найден искомый элемент)
    fun testOne() {
        println("Тест задание 1. Открытие блюда и дальнейшее закрытие")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        tapByCoordinates(cordX = 223, cordY = 1919)
        TimeUnit.SECONDS.sleep(2)
        swipeOnScreen(startCordX = 534, startCordY = 153, moveCordX = 534, moveCordY = 1308)
        TimeUnit.SECONDS.sleep(2)
        
        println("Тест 1 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testTwo(){
        println("Тест задание 2. Проверка элементов футера \"Главная страница\", \"Профиль\", \"Меню\".")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(profileButton.androidXPath, LocatorType.XPATH)
        clickToElement(menuPageButton.androidXPath, LocatorType.XPATH)
        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)

        println("Тест 2 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test

    fun testThree(){
        println("Тест задание 3. Проверка боксов \"Закуски\", \"Супы\", \"Паста\", \"Сендвичи\", \"Горячее\".")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(locator = snacksButton.androidAccessibilityId, locatorType = LocatorType.ACCESSIBILITY_ID)
        clickToElement(locator = soupsButton.androidAccessibilityId, locatorType = LocatorType.ACCESSIBILITY_ID)
        clickToElement(pastaButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(sandwichButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(soupsButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(hotDishButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

        println("Тест 3 завершен успешно")

        TimeUnit.SECONDS.sleep(5) // на всякий случай, не уверен что в этом есть необходимость
    }

    @Test
    // тест прохождения авторизации
    fun testFour(){
        println("Тест задание 4. Прохождение авторизации, выход из профиля и возврат к начальному экрану")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(profileButton.androidXPath, LocatorType.XPATH)
        clickToElement(logInButton.androidXPath, LocatorType.XPATH)
        sendText(enteringNumberBox.androidXPath, LocatorType.XPATH, testUserForRegistration.phoneNumber) //text = "9231775570")
        clickToElement(takeCodeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)
        val text = androidDriver.pageSource
        val textOne = text.substringAfter("Введите код из смс&#10;")
        val textTwo = textOne.substringBefore('&')
        println(textTwo)
        // при добавлении сущности смсКод из обьекта тестовыйПользователь код крашится раз через раз
        // так же и при попытка вывести эту функцию в отдельный класс (но в этом нет смысла, алгоритм встречается единажды)
        sendText(sendCodeField.androidClassName, LocatorType.CLASS_NAME, textTwo)
        //clickToElement(exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

        println("Тест 4 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    // тест при зарегестрированном пользователе для проверки
    fun TestFive(){
        println("Тест задание 5. Способ оплаты, выход из профиля и возврат к начальному экрану")

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(profileButton.androidXPath, LocatorType.XPATH)
        clickToElement(paymentMethod.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        tapByCoordinates(cordX = 500, cordY = 500)

        TimeUnit.SECONDS.sleep(10)
        clickToElement(exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

        println("Тест 5 успешно завершен")
        TimeUnit.SECONDS.sleep(5)


    }

    @Test
    fun TestSix(){
        println("Запущен тест 6")

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)
        // веленский пеереулок 6
        clickToElement(profileButton.androidXPath, LocatorType.XPATH) // переход в окно профиля
        clickToElement(addressButton.androidXPath, LocatorType.XPATH) // нажать на кнопку мои адреса

        try {
            findElement(checkAddressInPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            val (cordX, cordY, newCordX) = coordinateCalc(checkAddressInPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            println(" полученные координаты $cordX , $cordY, $newCordX")
            swipeOnScreen(startCordX = cordX, startCordY = cordY, moveCordX = newCordX, moveCordY = cordY+5)
            TimeUnit.SECONDS.sleep(2)
            tapByCoordinates(cordX * 2 - 10, cordY)

        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Адрес не добавлен")
        }

        clickToElement(addNewAddress.androidXPath, LocatorType.XPATH) // нажать на кнопку добавить нвоый адрес

        try {
            clickToElement(popUpPage.androidXPath, LocatorType.XPATH) // проверка всплывающего окна
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Всплывающееее окно не появилось")
            //println(err.cause)
        }

        clickToElement(addNewAddressSecond.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5) // почему-то более или менее стабильно работает с этими паузами
        clickToElement(addressTextBox.androidClassName, LocatorType.CLASS_NAME)
        clearField(addressTextBox.androidClassName, LocatorType.CLASS_NAME)
        //Сапёрный переулок, 20
        sendText(addressTextBox.androidXPath, LocatorType.XPATH, testUserForRegistration.street)
        sendText(addressTextBox.androidXPath, LocatorType.XPATH, testUserForRegistration.homeNumber)
        clickToElement("Сапёрный переулок, 20, Санкт-Петербург", LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(1) // почему-то более или менее стабильно работает с этими паузами, но не всегда

        clickToElement(apartNumber.androidXPath, LocatorType.XPATH)
        sendText(apartNumber.androidXPath, LocatorType.XPATH, testUserForRegistration.apartNumber)

        clickToElement(entrance.androidXPath, LocatorType.XPATH)
        sendText(entrance.androidXPath, LocatorType.XPATH, testUserForRegistration.entrance)

        clickToElement(intercom.androidXPath, LocatorType.XPATH)
        sendText(intercom.androidXPath, LocatorType.XPATH, testUserForRegistration.intercom)

        clickToElement(floor.androidXPath, LocatorType.XPATH)
        sendText(floor.androidXPath, LocatorType.XPATH, testUserForRegistration.floor)

        clickToElement(commentAddress.androidXPath, LocatorType.XPATH)
        sendText(commentAddress.androidXPath, LocatorType.XPATH, testUserForRegistration.commentAddress)

        clickToElement(saveAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(2)

        swipeOnScreen(startCordX = 568, startCordY = 160, moveCordX = 600, moveCordY = 1200)

        TimeUnit.SECONDS.sleep(2)
        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

    }
}
