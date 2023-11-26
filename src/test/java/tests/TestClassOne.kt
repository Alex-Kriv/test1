package tests

import MainActivity
import TestFunctions.tapByCoordinates
import api_client.environment.Environment
import api_client.environment.Environment.environment
import api_client.requests.auth.AuthLogin
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.SessionId
import api_client.requests.categories.Categories
import api_client.requests.meals.Meals
import api_client.requests.user.User
import api_client.specifications.Specifications.installSpecification
import api_client.specifications.Specifications.requestSpec
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import io.qameta.allure.Description
import org.testng.annotations.Test
import screens.*
import screens.AddressPage.fullAddress
import screens.AddressPage.unionAddress
import screens.MainPage.clickKruasanButton
import screens.MainPage.clickSnacksButton
import screens.MainPage.setKruasanButtom
import screens.MainPage.setNewSnackButton
import java.util.concurrent.TimeUnit


class TestClassOne :MainActivity() {

    @Description("ТПоиск и нажатие на первое блюдо из категории закуски")
    @Test(description = "Работа с API")
    fun testOne(){


        installSpecification(requestSpec(environment.host))
        SessionId.get(mutableMapOf())
        TimeUnit.SECONDS.sleep(5)

        val phone = AuthResetCode.authResetCodeReqBody("79231775570").phone
        AuthResetCode.post(AuthResetCode.authResetCodeReqBody("79231775570"))

        TimeUnit.SECONDS.sleep(5)

        AuthLogin.post(AuthLogin.authLoginReqBody(phone, "3256"))
        AuthLogin.authLoginReqBody(phone, "3256")

        Categories.get(mutableMapOf())
        Meals.get(mutableMapOf())

        val getCodeOfCategory = Categories.resBody[1].code
        setNewSnackButton(Categories.resBody[1].name.toString())
        clickSnacksButton()
        TimeUnit.SECONDS.sleep(5)

        for (i in 0..Meals.resBody.size){
            if (Meals.resBody[i].categories.contains(getCodeOfCategory)) {
                Meals.resBody[i].price?.let { setKruasanButtom(it) } // почему-то с accessibilityId не стало работать
                break
            }
        }
        TimeUnit.SECONDS.sleep(5)
        clickKruasanButton()
        TimeUnit.SECONDS.sleep(5)

    }

    @Description("Добавление и удаление адреса в профиле")
    @Test(description = "Работа с адресом")
    fun testTwo(){

        val profilePage = Profile
        val mainPage = MainPage
        val addressPage = AddressPage

        val needAuthorizationUser: Boolean = true
        TimeUnit.SECONDS.sleep(4)
        checkAuthorizationUser(needAuthorizationUser)

        installSpecification(requestSpec(environment.host))
        SessionId.get(mutableMapOf())
        TimeUnit.SECONDS.sleep(5)

        val phone = AuthResetCode.authResetCodeReqBody("79231775570").phone
        AuthResetCode.post(AuthResetCode.authResetCodeReqBody("79231775570"))

        TimeUnit.SECONDS.sleep(5)

        AuthLogin.post(AuthLogin.authLoginReqBody(phone, "3256"))
        AuthLogin.authLoginReqBody(phone, "3256")

        User.get(mutableMapOf())

        // веленский пеереулок 6
        profilePage.clickProfileButton()

        addressPage.clickAddressButton()

        addressPage.checkAddressInPageAndThenDelete(User.resBody, true)

        addressPage.clickAddNewAddress()

        try {
            addressPage.clickPopUpPage(true)
            TimeUnit.SECONDS.sleep(1)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Всплывающееее окно не появилось")
        }

        addressPage.clickAddNewAddressSecond()

        TimeUnit.SECONDS.sleep(5)

        addressPage.writeAddressInAddressTextBox()
        TimeUnit.SECONDS.sleep(1)

        addressPage.writeApartNumber()

        addressPage.writEntrance()

        addressPage.writeIntercom()

        addressPage.writeFloor()

        addressPage.writeCommentAddress()

        addressPage.clickSaveAddressButton()
        TimeUnit.SECONDS.sleep(2)

        addressPage.findCoordinatesForExitMyAddressPage()

        TimeUnit.SECONDS.sleep(4)
        mainPage.clickMainPageButton()

    }

    @Description("Изменение и проверка корректности личных данных")
    @Test(description = "Работа с окном введения данных")

    fun testThree() {

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

        userDataPage.enterNewEmailToEmailTextBox(selectUserData)

        userDataPage.enterNewInstagramToInstagramTextBox(selectUserData)

        userDataPage.clickSaveUserDataButton()

        userDataPage.clickMyDataPage()

        userDataPage.checkWhichUserDataWasWritten(selectUserData)

        mainPage.clickMainPageButton()

        TimeUnit.SECONDS.sleep(10)
    }

    @Description("Прохождение авторизации, выход из профиля и возврат к начальному экрану")
    @Test(description = "Выполнение авторизации")
    fun testFour(){

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

        TimeUnit.SECONDS.sleep(5)
    }

}
