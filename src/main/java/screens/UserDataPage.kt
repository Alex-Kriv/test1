package screens

import TestFunctions.checkWhichUserData
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.getAttributeText
import TestFunctions.sendText
import TestFunctions.tapByCoordinates
import users.UserData
import java.util.concurrent.TimeUnit

object UserDataPage {

    fun clickMyDataPage(){
        clickToElement(
            myDataPage.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            myDataPage.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = myDataPage.elementName
        )
    }

    fun whichUserDataNeedToWrite(): UserData {

        val nameAttribute = getAttributeText(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,)

        val emailAttribute = getAttributeText(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
        )

        val instagramAttribute = getAttributeText(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        val selectUserData = checkWhichUserData(nameAttribute, emailAttribute, instagramAttribute)
        println("На текущий момент в профиле указаны имя $nameAttribute, почта $emailAttribute, инстаграм $instagramAttribute")
        println("Будут введены следующие данные: Имя ${selectUserData.name}, почта ${selectUserData.email}, инстаграм ${selectUserData.instagram}")
        return selectUserData
    }

    fun enterNewNameToNameTextBox(selectUserData: UserData) {
        clickToElement(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = nameTextBox.elementName
        )
        clearField(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = nameTextBox.elementName
        )
        sendText(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            selectUserData.name,
            elementName = nameTextBox.elementName
        )
    }

    fun enterNewEmailToEmailTextBox(selectUserData: UserData) {
        clickToElement(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = emailTextBox.elementName
        )
        clearField(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = emailTextBox.elementName
        )
        sendText(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            selectUserData.email,
            elementName = emailTextBox.elementName
        )
    }

    fun enterNewInstagramToInstagramTextBox(selectUserData: UserData) {
        clickToElement(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = instagramTextBox.elementName
        )
        clearField(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = instagramTextBox.elementName
        )
        sendText(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            selectUserData.instagram,
            elementName = instagramTextBox.elementName
        )
    }

    fun checkWhichUserDataWasWritten(selectUserData: UserData){
        if (
            getAttributeText(
            nameTextBox.androidXPath, LocatorType.XPATH,
            nameTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,) == selectUserData.name &&
            getAttributeText(
            emailTextBox.androidXPath, LocatorType.XPATH,
            emailTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID) == selectUserData.email &&
            getAttributeText(
            instagramTextBox.androidXPath, LocatorType.XPATH,
            instagramTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID) == selectUserData.instagram
        ) {println("Новые данные пользователя введены верно")}
        else println("Новые данные пользователя введены неверно")
        TimeUnit.SECONDS.sleep(10)
        tapByCoordinates(100, 100) // понятно что можно найти точку за пределами экрана,
        // но и так будет работать в 100% случаев
    }

    fun clickSaveUserDataButton(){
        clickToElement(
            saveUserDataButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            saveUserDataButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = saveUserDataButton.elementName
        )
    }

    private val myDataPage = ScreenConstructor(
        androidAccessibilityId = "Мои данные",
        iosAccessibilityId = "Мои данные",
        elementName = "Переход в окно ввода данных"
    )

    private val nameTextBox = ScreenConstructor(
        iosAccessibilityId = "Имя",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[1]",
        elementName = "Поле ввода имени"
    )

    private val emailTextBox = ScreenConstructor(
        iosAccessibilityId = "Эл. почта",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[2]",
        elementName = "поле ввода email",
    )

    private val instagramTextBox = ScreenConstructor(
        iosAccessibilityId = "Инстаграм",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView/android.view.View/android.view.View/android.widget.EditText[3]",
        elementName = "поле ввода Инстаграм"
    )

    private val saveUserDataButton = ScreenConstructor(
        iosAccessibilityId = "Сохранить",
        androidAccessibilityId = "Сохранить",
        elementName = "кнопка сохранения измененных данных"
    )

}
