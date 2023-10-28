package screens

object AddressPage {

    val addressButton = ScreenConstructor(
        androidAccessibilityId = "Мои адреса",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Мои адреса\"]",
        elementName = "Выбрать мои адреса",
    )

    val addNewAddress = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        elementName = "Добавить новый адрес",
    )

    val popUpPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]",
        androidId = "com.android.permissioncontroller:id/permission_deny_button",
        elementName = "Обработка всплывающего окна"
    )
    val addNewAddressSecond = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        elementName = "Повторный тап на добавление нового адреса",
    )
    val addressTextBox = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText",
        elementName = "Поле ввода нового адреса",
    )

    val apartNumber = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]",
        elementName = "Запись номера квартиры",
    )

    val entrance = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
        elementName = "Запись номера подьезда"
    )

    val intercom = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
        elementName = "Запись номера подьезда"
    )

    val floor = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
        elementName = "Запись номера этажа"
    )

    val commentAddress = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
        elementName = "Комментарий к адресу"
    )

    val saveAddressButton = ScreenConstructor(
        androidAccessibilityId = "Сохранить",
        elementName = "Сохранить записанные данные"
    )

    val checkAddressInPage = ScreenConstructor(
        androidAccessibilityId = "Сапёрный переулок, 20\n" +
                "кв 23, 2 подъезд, 6 этаж. Домофон: 4466. Комментарий",
        elementName = "Проврка добавлен ли установленный адрес",
    )

    val deleteAddressButton = ScreenConstructor(
        androidAccessibilityId = "Удалить",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Удалить\"]",
        elementName = "Кнопка удаления адреса"
    )

    val myAddressPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
        elementName = "Окно мои адреса"
    )
}