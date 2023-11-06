package screens

import TestFunctions.clickToElement

object Onboarding {

    fun clickSelectRusButton() {
        clickToElement(
            locatorAndroid = locatorMap[OnboardingElements.SELECT_RUS_BUTTON_ANDROID].toString(),
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = locatorMap[OnboardingElements.SELECT_RUS_BUTTON_IOS].toString(),
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = locatorMap[OnboardingElements.SELECT_RUS_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    fun clickIosEnableNotificationWindow() {
        clickToElement(
            locatorAndroid = locatorMap[OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_ANDROID].toString(),
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = locatorMap[OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_IOS].toString(),
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = locatorMap[OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_ELEMENT_NAME].toString(),
        )
    }

    fun clickIosTrackYourActivityWindow() {
        clickToElement(
            locatorAndroid = locatorMap[OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_ANDROID].toString(),
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = locatorMap[OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_IOS].toString(),
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = locatorMap[OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_ELEMENT_NAME].toString(),
        )
    }

    fun clickNextButton(){
        clickToElement(
            locatorAndroid = locatorMap[OnboardingElements.NEXT_BUTTON_ANDROID].toString(),
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = locatorMap[OnboardingElements.NEXT_BUTTON_IOS].toString(),
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = locatorMap[OnboardingElements.NEXT_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    fun clickPickupButton(){
        clickToElement(
            locatorAndroid = locatorMap[OnboardingElements.PICK_UP_BUTTON_ANDROID].toString(),
            locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
            locatorIOS = locatorMap[OnboardingElements.PICK_UP_BUTTON_IOS].toString(),
            locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
            elementName = locatorMap[OnboardingElements.PICK_UP_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    private val selectRusButton = ScreenConstructor(
        androidAccessibilityId = "Русский",
        iosAccessibilityId = "Русский",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Русский\"`]",
        iosPredicateString = "label == \"Русский\"",
        elementName = "Вывод русскоко языка на экране онбординга"
    )

    private val iosEnableNotificationWindow = ScreenConstructor(
        iosAccessibilityId = "Далее",
        iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Далее\"`]",
        iosPredicateString = "label == \"Далее\"",
        iosXPath = "///XCUIElementTypeStaticText[@name=\"Далее\"]",
        elementName = "Пропустить окно уведомлений"
    )

    private val iosTrackYourActivityWindow = ScreenConstructor(
        iosAccessibilityId = "Ask App Not to Track",
        iosClassChain = "**/XCUIElementTypeButton[`label == \"Ask App Not to Track\"`]`]",
        iosPredicateString = "label == \"Ask App Not to Track\"",
        iosXPath = "//XCUIElementTypeButton[@name=\"Ask App Not to Track\"]",
        elementName = "Окно разрешения на отправку данных"
    )

    private val nextButton = ScreenConstructor(
        androidAccessibilityId = "Далее",
        iosAccessibilityId = "Далее",
        elementName = " кнопка далее "
    )

    private val pickupButton = ScreenConstructor(
        androidAccessibilityId = "Самовывоз",
        iosAccessibilityId = "Самовывоз",
        elementName = "Выбор режима \"Самовывоз\""
    )
    private enum class OnboardingElements {
        SELECT_RUS_BUTTON_ANDROID,
        SELECT_RUS_BUTTON_IOS,
        SELECT_RUS_BUTTON_ELEMENT_NAME,

        IOS_ENABLE_NOTIFICATION_WINDOW_ANDROID,
        IOS_ENABLE_NOTIFICATION_WINDOW_IOS,
        IOS_ENABLE_NOTIFICATION_WINDOW_ELEMENT_NAME,

        IOS_TRACK_YOUR_ACTIVITY_WINDOW_ANDROID,
        IOS_TRACK_YOUR_ACTIVITY_WINDOW_IOS,
        IOS_TRACK_YOUR_ACTIVITY_WINDOW_ELEMENT_NAME,

        NEXT_BUTTON_ANDROID,
        NEXT_BUTTON_IOS,
        NEXT_BUTTON_ELEMENT_NAME,

        PICK_UP_BUTTON_ANDROID,
        PICK_UP_BUTTON_IOS,
        PICK_UP_BUTTON_ELEMENT_NAME,
    }

    private val locatorMap: LinkedHashMap<OnboardingElements, String> = linkedMapOf(
        OnboardingElements.SELECT_RUS_BUTTON_ANDROID to "Русский",
        OnboardingElements.SELECT_RUS_BUTTON_IOS to "Русский",
        OnboardingElements.SELECT_RUS_BUTTON_ELEMENT_NAME to "Вывод русскоко языка на экране онбординга",

        OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_ANDROID to "1",
        OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_IOS to "Далее",
        OnboardingElements.IOS_ENABLE_NOTIFICATION_WINDOW_ELEMENT_NAME to "Пропустить окно уведомлений",

        OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_ANDROID to "1",
        OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_IOS to "Ask App Not to Track",
        OnboardingElements.IOS_TRACK_YOUR_ACTIVITY_WINDOW_ELEMENT_NAME to "Окно разрешения на отправку данных",

        OnboardingElements.NEXT_BUTTON_ANDROID to "Далее",
        OnboardingElements.NEXT_BUTTON_IOS to "Далее",
        OnboardingElements.NEXT_BUTTON_ELEMENT_NAME to " кнопка далее ",

        OnboardingElements.PICK_UP_BUTTON_ANDROID to "Самовывоз",
        OnboardingElements.PICK_UP_BUTTON_IOS to "Самовывоз",
        OnboardingElements.PICK_UP_BUTTON_ELEMENT_NAME to "Выбор режима \"Самовывоз\"",
    )

}