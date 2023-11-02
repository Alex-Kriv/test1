package general_cases_for_tests

import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
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
import screens.Profile.sendCodeField
import screens.Profile.takeCodeButton
import users.TestUser
import java.util.concurrent.TimeUnit

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        var userIsAuthorization: Boolean
        try {

            clickToElement(
                profileButton.androidXPath, LocatorType.XPATH,
                profileButton.iosXPath, LocatorType.XPATH
            ) // переход в окно профиля из начального экрана
            userIsAuthorization = checkAvailableElement(
                exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
                exitButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {

            needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь авторизован, тест может быть выполнен")

                clickToElement(
                    mainPageButton.androidXPath, LocatorType.XPATH,
                    mainPageButton.iosXPath, LocatorType.XPATH
                )
                TimeUnit.SECONDS.sleep(5)
            }

            needAuthorizationUser && !userIsAuthorization -> {
                println("Пользователь должен быть авторизован для прохождения данного теста")
                clickToElement(
                    profileButton.androidXPath, LocatorType.XPATH,
                    profileButton.iosXPath, LocatorType.XPATH
                    )
                clickToElement(
                    logInButton.androidXPath, LocatorType.XPATH,
                    logInButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
                    )
                for (char in TestUser.testUserForRegistration.phoneNumber) {
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
                TimeUnit.SECONDS.sleep(3)
                //val text = androidDriver.pageSource // надо подумать
                //val textIOS = iosDriver.pageSource
                val text = if (platformType == TypeOS.ANDROID) {androidDriver.pageSource} else {iosDriver.pageSource}
                val textOne = text.substringAfter("Введите код из смс&#10;")
                val textTwo = textOne.substringBefore('&')
                //println(textTwo)
                sendText(
                    sendCodeField.androidClassName, LocatorType.CLASS_NAME,
                    sendCodeField.iosClassName, LocatorType.CLASS_NAME,
                    textTwo)
                clickToElement(
                    mainPageButton.androidXPath, LocatorType.XPATH,
                    mainPageButton.iosXPath, LocatorType.XPATH
                    )

                TimeUnit.SECONDS.sleep(5)
            }

            !needAuthorizationUser && userIsAuthorization -> {
                println("Пользователь должен быть не авторизован для прохождения данного теста")

                clickToElement(
                    exitButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
                    exitButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
                    )
                clickToElement(
                    mainPageButton.androidXPath, LocatorType.XPATH,
                    mainPageButton.iosXPath, LocatorType.XPATH
                    )

                TimeUnit.SECONDS.sleep(5)
            }

            needAuthorizationUser == false && userIsAuthorization == false -> {
                println("Пользователь не авторизован, тест может быть выполнен")
                clickToElement(
                    mainPageButton.androidXPath, LocatorType.XPATH,
                    mainPageButton.iosXPath, LocatorType.XPATH
                    )
                TimeUnit.SECONDS.sleep(5)
            }
        }

    }
}