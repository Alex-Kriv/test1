package tests

import MainActivity
import api_client.environment.Environment
import api_client.environment.Environment.environment
import api_client.pojo.auth.AuthResetCodePojo
import api_client.requests.auth.AuthLogin
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.SessionId
import api_client.requests.categories.Categories
import api_client.requests.meals.Meals
import api_client.requests.user.User
import api_client.specifications.Specifications.installSpecification
import api_client.specifications.Specifications.requestSpec
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class TestClassOne :MainActivity() {


   @Test
   fun testOne(){

       installSpecification(requestSpec(environment.host))

       Categories.get(mutableMapOf())
       //Categories.resBody.get(0).accessibility
       println()
       println("something")
   }

    @Test
    fun testTwo(){
        // получение токена и обращение к auth/login
        installSpecification(requestSpec(environment.host))
        println(environment.authToken)
        val reqBodyForAuth = AuthLogin.authLoginReqBody("79231775570", "3256")
        TimeUnit.SECONDS.sleep(5)
        val token = AuthLogin.post(reqBodyForAuth).toString() // получил токен, но почему-то вконце остается kotlin.unit
        Environment.environment.authToken = token.substringBefore("kotlin.Unit")
        println(environment.authToken)
    }

    @Test
    fun testThree(){

        installSpecification(requestSpec(environment.host))
        SessionId.get(mutableMapOf())
        TimeUnit.SECONDS.sleep(5)

        val phone = AuthResetCode.authResetCodeReqBody("79231775570").phone
        AuthResetCode.post(AuthResetCode.authResetCodeReqBody("79231775570"))

        TimeUnit.SECONDS.sleep(5)
        AuthLogin.post(AuthLogin.authLoginReqBody(phone, "3256"))
        AuthLogin.authLoginReqBody(phone, "3256")
        println(AuthLogin.resBody)

        // присвоение новых хэдеров выполнено в функции хэдер. если нужно будет использовать пустое поле токена
        // то придется сначаал передать пустое значение в enviriments.authToken, костыль лютый
        // но не придумал, как сделать проще
        // можно сразу в функции гет,пост задать значение хэдера по типу headers["authorization"] = resBody

        Meals.get(mutableMapOf())
        User.get(mutableMapOf())

    }

 /*   @Test

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

        userDataPage.enterNewEmailToEmailTextBox(selectUserData)

        userDataPage.enterNewInstagramToInstagramTextBox(selectUserData)

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


  */
}
