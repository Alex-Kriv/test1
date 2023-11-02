package tests

import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import LocatorType
import MainActivity
import TestFunctions.checkWhichUserData
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.coordinateCalc
import TestFunctions.coordinateCalcForX
import TestFunctions.coordinateCalcForY
import TestFunctions.findElement
import TestFunctions.getAttributeText
import TestFunctions.platformCheck
import TestFunctions.sendText
import TestFunctions.swipeOnScreen
import TestFunctions.tapByCoordinates
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import users.TestUser.testUserForRegistration
import org.testng.annotations.Test
import screens.AddressPage.addNewAddress
import screens.AddressPage.addNewAddressSecond
import screens.AddressPage.addressButton
import screens.AddressPage.addressTextBox
import screens.AddressPage.apartNumber
import screens.AddressPage.checkAddressInPage
import screens.AddressPage.commentAddress
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
import screens.UserDataPage.birthdayTexBox
import screens.UserDataPage.emailTextBox
import screens.UserDataPage.instagramTextBox
import screens.UserDataPage.myDataPage
import screens.UserDataPage.nameTextBox
import screens.UserDataPage.saveUserDataButton
import users.TestUser
import users.TestUser.testUserForRegistrationAnother
import users.UserData
import java.util.concurrent.TimeUnit


class TestClassOne :MainActivity() {

    @Test
    // ну это какой-то пздц если честно... как сократить код пока нет идей
    fun testOne() {
        println("Тест задание 1. Заполнение личных данных")

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(profileButton.androidXPath, LocatorType.XPATH,
            profileButton.iosXPath, LocatorType.XPATH)

        clickToElement(myDataPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            myDataPage.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        val element1 = getAttributeText(nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,)
        val element2 = getAttributeText(emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        val element3 = getAttributeText(instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)


        val element4 = checkWhichUserData(element1, element2, element3)
        println(element4.name)

        clickToElement(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clearField(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        sendText(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            element4.name
        )

        clickToElement(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clearField(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        sendText(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            element4.email
        )

        clickToElement(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clearField(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        sendText(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            element4.instagram
        )

        clickToElement(
            saveUserDataButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            saveAddressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )

        clickToElement(myDataPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            myDataPage.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        if (
            getAttributeText(
                nameTextBox.androidXPath, LocatorType.XPATH,
                nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID) == element4.name &&
            getAttributeText(
                emailTextBox.androidXPath, LocatorType.XPATH,
                emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID) == element4.email &&
            getAttributeText(
                instagramTextBox.androidXPath, LocatorType.XPATH,
                instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID) == element4.instagram
        ) {
            println("все гуд")
        } else println("все не гуд")

        tapByCoordinates(100, 100) // понятно что можно найти точку за пределами экрана,
            // но и так будет работать в 100% случаев

        clickToElement(mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH)

        println("Тест 1 успешно завершен")
        TimeUnit.SECONDS.sleep(10)
    }

    @Test
    fun testTwo(){
        println("Тест задание 2. Проверка элементов футера \"Главная страница\", \"Профиль\", \"Меню\".")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(
            profileButton.androidXPath, LocatorType.XPATH,
            profileButton.iosXPath, LocatorType.XPATH
            )
        clickToElement(
            menuPageButton.androidXPath, LocatorType.XPATH,
            menuPageButton.iosXPath, LocatorType.XPATH
            )
        clickToElement(
            mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH
            )
        TimeUnit.SECONDS.sleep(5)

        println("Тест 2 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test

    fun testThree(){
        println("Тест задание 3. Проверка боксов \"Закуски\", \"Супы\", \"Паста\", \"Сендвичи\", \"Горячее\".")

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(
            snacksButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            snacksButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            soupsButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            soupsButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            pastaButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            pastaButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            sandwichButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            sandwichButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            soupsButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            soupsButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            hotDishButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            hotDishButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH
        )

        println("Тест 3 завершен успешно")

        TimeUnit.SECONDS.sleep(5) // на всякий случай, не уверен что в этом есть необходимость
    }

    @Test
    // тест прохождения авторизации
    fun testFour(){
        println("Тест задание 4. Прохождение авторизации, выход из профиля и возврат к начальному экрану")

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(
            profileButton.androidXPath, LocatorType.XPATH,
            profileButton.iosXPath, LocatorType.XPATH
        )
        clickToElement(
            logInButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            logInButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        for (char in testUserForRegistration.phoneNumber) {
            sendText(
                enteringNumberBox.androidXPath, LocatorType.XPATH,
                enteringNumberBox.iosClassName, LocatorType.CLASS_NAME,
                char + "") //text = "9231775570")
            // костыль, так как котлин не может принять чар формат в стринг
        }
        clickToElement(
            takeCodeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            takeCodeButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        TimeUnit.SECONDS.sleep(5)
        val text = if (platformType == TypeOS.ANDROID) {androidDriver.pageSource} else {iosDriver.pageSource}
        val textOne = text.substringAfter("Введите код из смс&#10;")
        val textTwo = textOne.substringBefore('&')
        //println(textTwo)
        sendText(
            sendCodeField.androidClassName, LocatorType.CLASS_NAME,
            sendCodeField.iosClassName, LocatorType.CLASS_NAME,
            textTwo)
        //clickToElement(exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clickToElement(
            mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH
            )

        println("Тест 4 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    // тест при зарегестрированном пользователе для проверки
    fun testFive(){
        println("Тест задание 5. Способ оплаты, выход из профиля и возврат к начальному экрану")

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        clickToElement(
            profileButton.androidXPath, LocatorType.XPATH,
            profileButton.iosXPath, LocatorType.XPATH
        )
        clickToElement(
            paymentMethod.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            paymentMethod.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        TimeUnit.SECONDS.sleep(5)
        tapByCoordinates(cordX = 300, cordY = 300)

        TimeUnit.SECONDS.sleep(5)
        clickToElement(
            exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            exitButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        clickToElement(
            mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH
        )

        println("Тест 5 успешно завершен")
        TimeUnit.SECONDS.sleep(5)


    }

    @Test
    fun testSix(){
        println("Запущен тест 6. Добавление/удаление адреса")

        val needAuthorizationUser: Boolean = true
        TimeUnit.SECONDS.sleep(4)
        checkAuthorizationUser(needAuthorizationUser)
        // веленский пеереулок 6
        clickToElement(
            profileButton.androidXPath, LocatorType.XPATH,
            profileButton.iosXPath, LocatorType.XPATH
        ) // переход в окно профиля
        clickToElement(
            addressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            ) // нажать на кнопку мои адреса

        try {
            // вставить сюда функцию проверки платформы, вернуть пару локатор/тип локатора и вставить их в файндЭлемент
            val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
                checkAddressInPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
                checkAddressInPage.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
            findElement(finalLocator, finalLocatorType)

            val (cordX, cordY, newCordX) = coordinateCalc(
                checkAddressInPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
                checkAddressInPage.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
            println(" полученные координаты $cordX , $cordY, $newCordX")
            swipeOnScreen(startCordX = cordX, startCordY = cordY, moveCordX = newCordX, moveCordY = cordY+5)
            TimeUnit.SECONDS.sleep(2)
            tapByCoordinates(cordX * 2 - 10, cordY)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Адрес не добавлен")
        }

        clickToElement(
            addNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        ) // нажать на кнопку добавить нвоый адрес

        try {
            clickToElement(
                popUpPage.androidXPath, LocatorType.XPATH,
                popUpPage.iosXPath, LocatorType.XPATH
                ) // проверка всплывающего окна
            TimeUnit.SECONDS.sleep(1)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Всплывающееее окно не появилось")
            //println(err.cause)
        }

        clickToElement(
            addNewAddressSecond.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addNewAddressSecond.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        TimeUnit.SECONDS.sleep(5) // почему-то более или менее стабильно работает с этими паузами
        clickToElement(
            addressTextBox.androidClassName, LocatorType.CLASS_NAME,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        clearField(
            addressTextBox.androidClassName, LocatorType.CLASS_NAME,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        //Сапёрный переулок, 20
        sendText(
            addressTextBox.androidXPath, LocatorType.XPATH,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.street)
        sendText(
            addressTextBox.androidXPath, LocatorType.XPATH,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.homeNumber)
        clickToElement("Сапёрный переулок, 20, Санкт-Петербург", LocatorType.ACCESSIBILITY_ID,
            "Сапёрный переулок, 20, Санкт-Петербург", LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(1) // почему-то более или менее стабильно работает с этими паузами, но не всегда

        clickToElement(
            apartNumber.androidXPath, LocatorType.XPATH,
            apartNumber.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        sendText(
            apartNumber.androidXPath, LocatorType.XPATH,
            apartNumber.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.apartNumber
        )

        clickToElement(
            entrance.androidXPath, LocatorType.XPATH,
            entrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        sendText(
            entrance.androidXPath, LocatorType.XPATH,
            entrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.entrance)

        clickToElement(
            intercom.androidXPath, LocatorType.XPATH,
            intercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        sendText(
            intercom.androidXPath, LocatorType.XPATH,
            intercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.intercom)

        clickToElement(
            floor.androidXPath, LocatorType.XPATH,
            floor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        sendText(
            floor.androidXPath, LocatorType.XPATH,
            floor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.floor)

        clickToElement(
            commentAddress.androidXPath, LocatorType.XPATH,
            commentAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )
        sendText(
            commentAddress.androidXPath, LocatorType.XPATH,
            commentAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            testUserForRegistration.commentAddress)

        clickToElement(
            saveAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            saveAddressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
        TimeUnit.SECONDS.sleep(2)

        //swipeOnScreen(startCordX = 568, startCordY = 160, moveCordX = 600, moveCordY = 1200)
        val (cordXLocation, cordXWidth) = coordinateCalcForX(
            myAddressPage.androidXPath, LocatorType.XPATH,
            myAddressPage.iosXPath, LocatorType.XPATH
        )
        val (cordYLocation, cordYHeight) = coordinateCalcForY(
            myAddressPage.androidXPath, LocatorType.XPATH,
            myAddressPage.iosXPath, LocatorType.XPATH
        )
        val startCordX = cordXLocation + cordXWidth / 2
        val startCordY = cordYLocation + cordYHeight / 15
        val moveCordX = cordXLocation + cordXWidth / 2
        val moveCordY = cordYLocation + cordYHeight / 2
        TimeUnit.SECONDS.sleep(4)
        println("startCordX $startCordX, startCordY $startCordY, moveCordX $moveCordX, moveCordY $moveCordY")
        swipeOnScreen(startCordX = startCordX, startCordY = startCordY, moveCordX = moveCordX, moveCordY = moveCordY)

        TimeUnit.SECONDS.sleep(4)
        clickToElement(
            mainPageButton.androidXPath, LocatorType.XPATH,
            mainPageButton.iosXPath, LocatorType.XPATH
        )
    }


}
