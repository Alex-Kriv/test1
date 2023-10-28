package general_cases_for_tests

import GlobalVarlables.androidDriver
import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.sendText
import screens.MainPage.mainPageButton
import screens.Profile
import screens.Profile.enteringNumberBox
import screens.Profile.exitButton
import screens.Profile.logInButton
import screens.Profile.profileButton
import screens.Profile.takeCodeButton
import users.TestUser
import java.util.concurrent.TimeUnit

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        var userIsAuthorization: Boolean
        try {

            clickToElement(profileButton.androidXPath, LocatorType.XPATH) // переход в окно профиля из начального экрана
            userIsAuthorization = checkAvailableElement(exitButton.androidXPath, LocatorType.XPATH)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь авторизован, тест может быть выполнен")

                clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)
                TimeUnit.SECONDS.sleep(10)
            }
            needAuthorizationUser && !userIsAuthorization -> {
                println("Пользователь должен быть авторизован для прохождения данного теста")

                clickToElement(profileButton.androidXPath, LocatorType.XPATH)
                clickToElement(logInButton.androidXPath, LocatorType.XPATH)
                sendText(enteringNumberBox.androidXPath, LocatorType.XPATH, TestUser.testUserForRegistration.phoneNumber) //text = "9231775570")
                clickToElement(takeCodeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
                TimeUnit.SECONDS.sleep(3)
                val text = androidDriver.pageSource
                val textOne = text.substringAfter("Введите код из смс&#10;")
                val textTwo = textOne.substringBefore('&')
                //println(textTwo)
                sendText(Profile.sendCodeField.androidClassName, LocatorType.CLASS_NAME, textTwo)
                clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

                TimeUnit.SECONDS.sleep(10)
            }
            !needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь должен быть не авторизован для прохождения данного теста")

                clickToElement(exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
                clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)

                TimeUnit.SECONDS.sleep(10)
            }
            needAuthorizationUser == false && userIsAuthorization == false -> {
                println("Пользователь не авторизован, тест может быть выполнен")
                clickToElement(mainPageButton.androidXPath, LocatorType.XPATH)
                TimeUnit.SECONDS.sleep(10)
            }
        }

    }
}