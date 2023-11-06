package screens

import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.sendText
import users.TestUser

object Profile {

    fun clickProfileButton(){
        clickToElement(
            locatorAndroid = profileButton.androidXPath,
            locatorTypeAndroid = LocatorType.XPATH,
            locatorIOS = profileButton.iosXPath,
            locatorTypeIOS = LocatorType.XPATH,
            elementName = profileButton.elementName
        )
    }

    fun clickLogInButton(){
        clickToElement(
            locatorAndroid = logInButton.androidAccessibilityId,
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = logInButton.iosAccessibilityId,
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = logInButton.elementName
        )
    }

    fun sendTextEnteringNumberBox(){
        for (char in TestUser.testUserForRegistration.phoneNumber) {
            sendText(
                locatorAndroid = enteringNumberBox.androidXPath,
                locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS = enteringNumberBox.iosClassName,
                locatorTypeIOS = LocatorType.CLASS_NAME,
                text = char + "",
                elementName = enteringNumberBox.elementName) //text = "9231775570")
            // костыль, так как котлин не может принять чар формат в стринг
        }

    }

    fun clickTakeCodeButton(){
        clickToElement(
            takeCodeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            takeCodeButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = takeCodeButton.elementName
        )
    }

    fun sendTextSendCodeField(){

        val text = if (platformType == TypeOS.ANDROID) {androidDriver.pageSource} else {iosDriver.pageSource}
        val textOne = text.substringAfter("Введите код из смс&#10;")
        val textTwo = textOne.substringBefore('&')
        //println(textTwo)
        sendText(
            locatorAndroid = sendCodeField.androidClassName,
            locatorTypeAndroid = LocatorType.CLASS_NAME,
            locatorIOS = sendCodeField.iosClassName,
            locatorTypeIOS = LocatorType.CLASS_NAME,
            text = textTwo,
            elementName = sendCodeField.elementName)
    }

    fun checkAvailableExitButton(): Boolean {
        return checkAvailableElement(
            locatorAndroid = exitButton.androidAccessibilityId,
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = exitButton.iosAccessibilityId,
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = exitButton.elementName
        )
    }

    fun clickExitButton(){
        clickToElement(
            locatorAndroid = exitButton.androidAccessibilityId,
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = exitButton.iosAccessibilityId,
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = exitButton.elementName
        )
    }

    fun clickPaymentMethod(){
        clickToElement(
            paymentMethod.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            paymentMethod.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = paymentMethod.elementName
        )
    }

    private val paymentMethod = ScreenConstructor(
        androidXPath = "//android.widget.ImageView[@content-desc=\"Способы оплаты\"]",
        androidAccessibilityId = "Способы оплаты",
        iosAccessibilityId = "Способы оплаты",
        elementName = "Выбрать способ оплаты",
    )

    private val profileButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]",
        elementName = "Кнопка перехода в окно профиля",
    )

    private val logInButton = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Войти\"]",
        androidAccessibilityId = "Войти",
        iosAccessibilityId = "Войти",
        iosXPath = "//XCUIElementTypeStaticText[@name=\"Войти\"]",
        iosPredicateString = "label == \"Войти\"",
        elementName = "Кнопка перехода в окно авторизации",
    )

    private val enteringNumberBox = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText",
        iosClassName = "XCUIElementTypeTextField",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
        elementName = "Поле ввода номера телефона",
    )

    private val takeCodeButton = ScreenConstructor(
        androidAccessibilityId = "Получить код",
        iosAccessibilityId = "Получить код",
        elementName = "Кнопка получить код",
    )

    private val sendCodeField = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        iosClassName = "XCUIElementTypeTextField",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
        elementName = "Поле ввода кода авторизации",
    )

    private val exitButton = ScreenConstructor(
        androidAccessibilityId = "Выйти",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Выйти\"]",
        iosAccessibilityId = "Выйти",
        iosXPath = "//XCUIElementTypeImage[@name=\"Выйти\"]",
        elementName = "Кнопка выйти из профиля"
    )

}