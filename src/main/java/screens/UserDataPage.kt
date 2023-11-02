package screens

object UserDataPage {
    val myDataPage = ScreenConstructor(
        androidAccessibilityId = "Мои данные",
        iosAccessibilityId = "Мои данные",
        elementName = "Переход в окно ввода данных"
    )

    val nameTextBox = ScreenConstructor(
        iosAccessibilityId = "Имя",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[1]",
        elementName = "Поле ввода имени"
    )

    val birthdayTexBox = ScreenConstructor(
        iosAccessibilityId = "День рождения",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText",
        elementName = "поле ввода дня рождения",
    )

    val emailTextBox = ScreenConstructor(
        iosAccessibilityId = "Эл. почта",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[2]",
        elementName = "поле ввода email",
    )

    val instagramTextBox = ScreenConstructor(
        iosAccessibilityId = "Инстаграм",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[3]",
        elementName = "поле ввода Инстаграм"
    )

    val saveUserDataButton = ScreenConstructor(
        iosAccessibilityId = "Сохранить",
        androidAccessibilityId = "Сохранить",
        elementName = "кнопка сохранения измененных данных"
    )
}