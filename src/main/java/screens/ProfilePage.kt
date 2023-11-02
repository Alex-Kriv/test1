package screens

object Profile {

    val profileButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]",
        elementName = "Кнопка перехода в окно профиля",
    )

    val logInButton = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Войти\"]",
        androidAccessibilityId = "Войти",
        iosAccessibilityId = "Войти",
        iosXPath = "//XCUIElementTypeStaticText[@name=\"Войти\"]",
        iosPredicateString = "label == \"Войти\"",
        elementName = "Кнопка перехода в окно авторизации",
    )

    val enteringNumberBox = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText",
        iosClassName = "XCUIElementTypeTextField",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
        elementName = "Поле ввода номера телефона",
    )

    val takeCodeButton = ScreenConstructor(
        androidAccessibilityId = "Получить код",
        iosAccessibilityId = "Получить код",
        elementName = "Кнопка получить код",
    )

    val sendCodeField = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        iosClassName = "XCUIElementTypeTextField",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
        elementName = "Поле ввода кода авторизации",
    )

    val exitButton = ScreenConstructor(
        androidAccessibilityId = "Выйти",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Выйти\"]",
        iosAccessibilityId = "Выйти",
        iosXPath = "//XCUIElementTypeImage[@name=\"Выйти\"]",
        elementName = "Кнопка выйти из профиля"
    )

    val paymentMethod = ScreenConstructor(
        androidXPath = "//android.widget.ImageView[@content-desc=\"Способы оплаты\"]",
        androidAccessibilityId = "Способы оплаты",
        iosAccessibilityId = "Способы оплаты",
        elementName = "Выбрать способ оплаты",
    )


}