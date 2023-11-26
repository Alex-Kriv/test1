package general_cases_for_tests

import screens.MainPage
import screens.Profile
import java.util.concurrent.TimeUnit

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        val profilePage = Profile
        val mainPage = MainPage
        var userIsAuthorization: Boolean
        try {

            profilePage.clickProfileButton() // переход в окно профиля из начального экрана
            userIsAuthorization = profilePage.checkAvailableExitButton(true) // проверка наличия кнопки "выход"

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {

            needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь авторизован, тест может быть выполнен")

                mainPage.clickMainPageButton()
                TimeUnit.SECONDS.sleep(5)
            }

            needAuthorizationUser && !userIsAuthorization -> {
                println("Пользователь должен быть авторизован для прохождения данного теста")

                profilePage.clickProfileButton()
                profilePage.clickLogInButton()
                profilePage.sendTextEnteringNumberBox()
                /*for (char in TestUser.testUserForRegistration.phoneNumber) {
                    sendText(
                        enteringNumberBox.androidXPath, LocatorType.XPATH,
                        enteringNumberBox.iosClassName, LocatorType.CLASS_NAME,
                        char + "") //text = "9231775570")
                    // костыль, так как котлин не может принять чар формат в стринг
                } */
                profilePage.clickTakeCodeButton()

                TimeUnit.SECONDS.sleep(3)
                profilePage.sendTextSendCodeField()// запись полученного с экрана кода
                mainPage.clickMainPageButton()

                TimeUnit.SECONDS.sleep(5)
            }

            !needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь должен быть не авторизован для прохождения данного теста")

                profilePage.clickExitButton()
                mainPage.clickMainPageButton()

                TimeUnit.SECONDS.sleep(5)
            }

            needAuthorizationUser == false && userIsAuthorization == false -> {
                println("Пользователь не авторизован, тест может быть выполнен")
                mainPage.clickMainPageButton()

                TimeUnit.SECONDS.sleep(5)
            }
        }

    }
}