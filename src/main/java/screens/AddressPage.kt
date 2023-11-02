package screens

object AddressPage {

    val addressButton = ScreenConstructor(
        androidAccessibilityId = "Мои адреса",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Мои адреса\"]",
        iosAccessibilityId = "Мои адреса",
        iosXPath = "//XCUIElementTypeImage[@name=\"Мои адреса\"]",
        elementName = "Выбрать мои адреса",
    )

    val addNewAddress = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        iosAccessibilityId = "Добавить новый адрес",
        iosXPath = "//XCUIElementTypeImage[@name=\"Добавить новый адрес\"]",
        elementName = "Добавить новый адрес",
    )

    val popUpPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]",
        androidId = "com.android.permissioncontroller:id/permission_deny_button",
        iosXPath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]",
        elementName = "Обработка всплывающего окна"
    )
    val addNewAddressSecond = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        iosAccessibilityId = "Добавить новый адрес",
        iosClassChain = "**/XCUIElementTypeImage[`label == \"Добавить новый адрес\"`]",
        elementName = "Повторный тап на добавление нового адреса",
    )
    val addressTextBox = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText",
        iosAccessibilityId = "Адрес",
        iosClassName = "XCUIElementTypeTextField",
        elementName = "Поле ввода нового адреса",
    )

    val apartNumber = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]",
        iosAccessibilityId = "Квартира",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Квартира\"]",
        elementName = "Запись номера квартиры",
    )

    val entrance = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
        iosAccessibilityId = "Подъезд",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Подъезд\"]",
        elementName = "Запись номера подьезда"
    )

    val intercom = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
        iosAccessibilityId = "Домофон",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Домофон\"]",
        elementName = "Запись номера подьезда"
    )

    val floor = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
        iosAccessibilityId = "Этаж",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Этаж\"]",
        elementName = "Запись номера этажа"
    )

    val commentAddress = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
        iosAccessibilityId = "Комментарий для курьера",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Комментарий для курьера\"]",
        elementName = "Комментарий к адресу"
    )

    val saveAddressButton = ScreenConstructor(
        androidAccessibilityId = "Сохранить",
        iosAccessibilityId = "Сохранить",
        elementName = "Сохранить записанные данные"
    )

    val checkAddressInPage = ScreenConstructor(
        androidAccessibilityId = "Сапёрный переулок, 20\n" +
                "кв 23, 2 подъезд, 6 этаж. Домофон: 4466. Комментарий",
        iosAccessibilityId = "Сапёрный переулок, 20\n" +
                "кв 23, 2 подъезд, 6 этаж. Домофон: 4466. Комментарий",
        elementName = "Проврка добавлен ли установленный адрес",
    )

    val deleteAddressButton = ScreenConstructor(
        androidAccessibilityId = "Удалить",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Удалить\"]",
        iosAccessibilityId = "Удалить",
        elementName = "Кнопка удаления адреса"
    )

    val myAddressPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
        iosClassName = "XCUIElementTypeScrollView",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView",
        elementName = "Окно мои адреса"
    )
}