package screens

object Onboarding {

    val selectRusButton = ScreenConstructor(
        androidAccessibilityId = "Русский",
        iosAccessibilityId = "Русский",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Русский\"`]",
        iosPredicateString = "label == \"Русский\"",
        elementName = "Вывод русскоко языка на экране онбординга"
    )

    val iosEnableNotificationWindow = ScreenConstructor(
        iosAccessibilityId = "Далее",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Далее\"`]",
        iosPredicateString = "label == \"Далее\"",
        iosXPath = "///XCUIElementTypeStaticText[@name=\"Далее\"]",
        elementName = "Пропустить окно уведомлений"
    )

    val iosTrackYourActivityWindow = ScreenConstructor(
        iosAccessibilityId = "Ask App Not to Track",
        iosClassChain = "**/XCUIElementTypeButton[`label == \"Ask App Not to Track\"`]`]",
        iosPredicateString = "label == \"Ask App Not to Track\"",
        iosXPath = "//XCUIElementTypeButton[@name=\"Ask App Not to Track\"]",
        elementName = "Окно разрешения на отправку данных"
    )

    val nextButton = ScreenConstructor(
        androidAccessibilityId = "Далее",
        iosAccessibilityId = "Далее",
        elementName = " кнопка далее "
    )

    val pickupButton = ScreenConstructor(
        androidAccessibilityId = "Самовывоз",
        iosAccessibilityId = "Самовывоз",
        elementName = "Выбор режима \"Самовывоз\""
    )

    val errorCheckButton = ScreenConstructor(
        androidAccessibilityId = "Ключ ошибки",
        iosAccessibilityId = "Ключ ошибки",
        elementName = "Данный элемент не найден"
    )

}