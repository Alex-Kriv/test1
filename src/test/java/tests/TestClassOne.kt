package tests

import MainActivity
import TestFunctions.tapByCoordinates
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.*
import java.util.concurrent.TimeUnit


class TestClassOne :MainActivity() {


    @Test
    // ну это какой-то пздц если честно... как сократить код пока нет идей
    fun testOne() {
        println("Тест задание 1. Изменение и проверка корректности личных данных")

        val profile = Profile
        val userDataPage = UserDataPage
        val mainPage = MainPage

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        profile.clickProfileButton()
        userDataPage.clickMyDataPage()

        val selectUserData = userDataPage.whichUserDataNeedToWrite()

        TimeUnit.SECONDS.sleep(2)

        userDataPage.enterNewNameToNameTextBox(selectUserData)

        TimeUnit.SECONDS.sleep(2)

        userDataPage.enterNewEmailToNameTextBox(selectUserData)

        userDataPage.enterNewInstagramToNameTextBox(selectUserData)

        userDataPage.clickSaveUserDataButton()

        userDataPage.clickMyDataPage()

        userDataPage.checkWhichUserDataWasWritten(selectUserData)

        mainPage.clickMainPageButton()

        println("Тест 1 успешно завершен")
        TimeUnit.SECONDS.sleep(10)
    }

    @Test
    fun testTwo(){
        println("Тест задание 2. Проверка элементов футера \"Главная страница\", \"Профиль\", \"Меню\".")

        val profilePage = Profile
        val menuPage = MenuPage
        val mainPage = MainPage

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        profilePage.clickProfileButton()

        menuPage.clickMenuPageButton()

        mainPage.clickMainPageButton()

        TimeUnit.SECONDS.sleep(5)
        println("Тест 2 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test

    fun testThree(){
        println("Тест задание 3. Проверка боксов \"Закуски\", \"Супы\", \"Паста\", \"Сендвичи\", \"Горячее\".")

        val mainPage = MainPage

        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        mainPage.clickSnacksButton()

        mainPage.clickSoupsButton()

        mainPage.clickPastaButton()

        mainPage.clickSandwichButton()

        mainPage.clickSoupsButton()

        mainPage.clickHotDishButton()

        mainPage.clickMainPageButton()

        println("Тест 3 завершен успешно")

        TimeUnit.SECONDS.sleep(5) // на всякий случай, не уверен что в этом есть необходимость
    }

    @Test
    // тест прохождения авторизации
    fun testFour(){
        println("Тест задание 4. Прохождение авторизации, выход из профиля и возврат к начальному экрану")

        val profilePage = Profile
        val mainPage = MainPage

        val needAuthorizationUser: Boolean = false
        checkAuthorizationUser(needAuthorizationUser)

        profilePage.clickProfileButton()

        profilePage.clickLogInButton()

        profilePage.sendTextEnteringNumberBox()

        profilePage.clickTakeCodeButton()

        TimeUnit.SECONDS.sleep(5)

        profilePage.sendTextSendCodeField()

        mainPage.clickMainPageButton()

        println("Тест 4 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    // тест при зарегестрированном пользователе для проверки
    fun testFive(){
        println("Тест задание 5. Способ оплаты, выход из профиля и возврат к начальному экрану")

        val profilePage = Profile
        val mainPage = MainPage
        val needAuthorizationUser: Boolean = true
        checkAuthorizationUser(needAuthorizationUser)

        profilePage.clickProfileButton()

        profilePage.clickPaymentMethod()

        TimeUnit.SECONDS.sleep(5)
        tapByCoordinates(cordX = 300, cordY = 300)
        TimeUnit.SECONDS.sleep(5)

        profilePage.clickExitButton()

        mainPage.clickMainPageButton()

        println("Тест 5 успешно завершен")
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testSix(){
        println("Запущен тест 6. Добавление/удаление адреса")

        val profilePage = Profile
        val mainPage = MainPage
        val addressPage = AddressPage

        val needAuthorizationUser: Boolean = true
        TimeUnit.SECONDS.sleep(4)
        checkAuthorizationUser(needAuthorizationUser)

        // веленский пеереулок 6
        profilePage.clickProfileButton() // переход в окно профиля

        addressPage.clickAddressButton() // нажать на кнопку мои адреса

        addressPage.checkAddressInPageAndThenDelete()

        addressPage.clickAddNewAddress() // нажать на кнопку добавить нвоый адрес

        try {
            addressPage.clickPopUpPage() // проверка всплывающего окна
            TimeUnit.SECONDS.sleep(1)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Всплывающееее окно не появилось")
            //println(err.cause)
        }

        addressPage.clickAddNewAddressSecond()

        TimeUnit.SECONDS.sleep(5) // почему-то более или менее стабильно работает с этими паузами

        addressPage.writeAddressInAddressTextBox()
        TimeUnit.SECONDS.sleep(1) // почему-то более или менее стабильно работает с этими паузами, но не всегда

        addressPage.writeApartNumber()

        addressPage.writEntrance()

        addressPage.writeIntercom()

        addressPage.writeFloor()

        addressPage.writeCommentAddress()

        addressPage.clickSaveAddressButton()
        TimeUnit.SECONDS.sleep(2)

        //swipeOnScreen(startCordX = 568, startCordY = 160, moveCordX = 600, moveCordY = 1200)
        addressPage.findCoordinatesForExitMyAddressPage()

        TimeUnit.SECONDS.sleep(4)
        mainPage.clickMainPageButton()
    }

}
