package screens

import LocatorType
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.coordinateCalc
import TestFunctions.coordinateCalcForX
import TestFunctions.coordinateCalcForY
import TestFunctions.findElement
import TestFunctions.platformCheck
import TestFunctions.sendText
import TestFunctions.swipeOnScreen
import TestFunctions.tapByCoordinates
import api_client.pojo.user.UserPojo
import users.TestUser
import java.util.concurrent.TimeUnit

object AddressPage {

    fun clickAddressButton(){
        clickToElement(
            addressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = addressButton.elementName
        )
    }

    fun unionAddress(street: String, flat: String, floor: String,
                     entranse: String, doorphone: String, comment: String){
        fullAddress.androidAccessibilityId = "${street}\n" +
                "кв ${flat}, ${entranse} подъезд, " +
                "${floor} этаж. Домофон: ${doorphone}. " +
                comment
        fullAddress.iosAccessibilityId = "${street}\n" +
                "кв ${flat}, ${entranse} подъезд, " +
                "${floor} этаж. Домофон: ${doorphone}. " +
                comment
    }

    val fullAddress = ScreenConstructor (
        androidAccessibilityId = "1",
        iosAccessibilityId = "1",
        elementName = "Мой полный адрес"

    )
    fun checkAddressInPageAndThenDelete(resBody: UserPojo.UserPojoRes, findElementWithoutCatching: Boolean = false){
        try {

            TimeUnit.SECONDS.sleep(15)
            for (i in 0..resBody.addresses.size - 1) {
                if (resBody.addresses[i].street == "Сапёрный переулок, 20"){
                    unionAddress(
                        resBody.addresses[i].street.toString(),
                        resBody.addresses[i].flat.toString(),
                        resBody.addresses[i].floor.toString(),
                        resBody.addresses[i].entrance.toString(),
                        resBody.addresses[i].doorphone.toString(),
                        resBody.addresses[i].comment.toString()
                    )

                    println("Полученный локатор ${fullAddress.androidAccessibilityId}")
                    println("Необходимый локатор ${checkAddressInPage.androidAccessibilityId}")
                    break
                }
            }

            val (finalLocator: String, finalLocatorType: LocatorType) = platformCheck(
                fullAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
                fullAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID
            )
            val element = findElement(finalLocator, finalLocatorType,findElementWithoutCatching)

            val (cordX, cordY, newCordX) = coordinateCalc(
                element
            )
            println(" полученные координаты $cordX , $cordY, $newCordX")
            swipeOnScreen(startCordX = cordX, startCordY = cordY, moveCordX = newCordX, moveCordY = cordY+5)
            TimeUnit.SECONDS.sleep(2)
            tapByCoordinates(cordX * 2 - 10, cordY)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            println("Адрес не добавлен")
        }
    }

    fun clickAddNewAddress(){
        clickToElement(
            addNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = addNewAddress.elementName
        )
    }

    fun clickPopUpPage(findElementWithoutCatching: Boolean = false){
        clickToElement(
            popUpPage.androidXPath, LocatorType.XPATH,
            popUpPage.iosXPath, LocatorType.XPATH,
            elementName = popUpPage.elementName,
            findElementWithoutCatching = findElementWithoutCatching
        )
    }

    fun clickAddNewAddressSecond(){
        clickToElement(
            addNewAddressSecond.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addNewAddressSecond.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = addNewAddressSecond.elementName
        )
    }

    fun writeAddressInAddressTextBox(){
        clickToElement(
            addressTextBox.androidClassName, LocatorType.CLASS_NAME,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = addressTextBox.elementName
        )
        clearField(
            addressTextBox.androidClassName, LocatorType.CLASS_NAME,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            addressTextBox.elementName
        )
        //Сапёрный переулок, 20
        sendText(
            addressTextBox.androidXPath, LocatorType.XPATH,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.street,
            elementName = addressTextBox.elementName)
        sendText(
            addressTextBox.androidXPath, LocatorType.XPATH,
            addressTextBox.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.homeNumber,
            elementName = addressTextBox.elementName)
        clickToElement("Сапёрный переулок, 20, Санкт-Петербург", LocatorType.ACCESSIBILITY_ID,
            "Сапёрный переулок, 20, Санкт-Петербург", LocatorType.ACCESSIBILITY_ID, elementName = "Всплывающее поле с подсказкой адреса")
    }

    fun writeApartNumber(){
        clickToElement(
            apartNumber.androidXPath, LocatorType.XPATH,
            apartNumber.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = apartNumber.elementName
        )
        sendText(
            apartNumber.androidXPath, LocatorType.XPATH,
            apartNumber.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.apartNumber,
            elementName = apartNumber.elementName
        )
    }

    fun writEntrance(){
        clickToElement(
            entrance.androidXPath, LocatorType.XPATH,
            entrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = entrance.elementName
        )
        sendText(
            entrance.androidXPath, LocatorType.XPATH,
            entrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.entrance,
            elementName = entrance.elementName
        )
    }

    fun writeIntercom(){
        clickToElement(
            intercom.androidXPath, LocatorType.XPATH,
            intercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = intercom.elementName
        )
        sendText(
            intercom.androidXPath, LocatorType.XPATH,
            intercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.intercom,
            elementName = intercom.elementName
        )
    }

    fun writeFloor(){
        clickToElement(
            floor.androidXPath, LocatorType.XPATH,
            floor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = floor.elementName
        )
        sendText(
            floor.androidXPath, LocatorType.XPATH,
            floor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.floor,
            elementName = floor.elementName
        )
    }

    fun writeCommentAddress(){
        clickToElement(
            commentAddress.androidXPath, LocatorType.XPATH,
            commentAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = commentAddress.elementName
        )
        sendText(
            commentAddress.androidXPath, LocatorType.XPATH,
            commentAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            TestUser.testUserForRegistration.commentAddress,
            elementName = commentAddress.elementName
        )
    }

    fun clickSaveAddressButton(){
        clickToElement(
            saveAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            saveAddressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = saveAddressButton.elementName
        )
    }

    fun findCoordinatesForExitMyAddressPage(){
        val (cordXLocation, cordXWidth) = coordinateCalcForX(
            myAddressPage.androidXPath, LocatorType.XPATH,
            myAddressPage.iosXPath, LocatorType.XPATH,
            elementName = "Вычисление координат х для закрытия окна адреса"
        )
        val (cordYLocation, cordYHeight) = coordinateCalcForY(
            myAddressPage.androidXPath, LocatorType.XPATH,
            myAddressPage.iosXPath, LocatorType.XPATH,
            elementName = "Вычисление координат х для закрытия окна адреса",
        )
        val startCordX = cordXLocation + cordXWidth / 2
        val startCordY = cordYLocation + cordYHeight / 15
        val moveCordX = cordXLocation + cordXWidth / 2
        val moveCordY = cordYLocation + cordYHeight / 2
        TimeUnit.SECONDS.sleep(4)
        println("startCordX $startCordX, startCordY $startCordY, moveCordX $moveCordX, moveCordY $moveCordY")
        swipeOnScreen(startCordX = startCordX, startCordY = startCordY, moveCordX = moveCordX, moveCordY = moveCordY)

    }

    private val addressButton = ScreenConstructor(
        androidAccessibilityId = "Мои адреса",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Мои адреса\"]",
        iosAccessibilityId = "Мои адреса",
        iosXPath = "//XCUIElementTypeImage[@name=\"Мои адреса\"]",
        elementName = "Выбрать мои адреса",
    )

    private val addNewAddress = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        iosAccessibilityId = "Добавить новый адрес",
        iosXPath = "//XCUIElementTypeImage[@name=\"Добавить новый адрес\"]",
        elementName = "Добавить новый адрес",
    )

    private val popUpPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]",
        androidId = "com.android.permissioncontroller:id/permission_deny_button",
        iosXPath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]",
        elementName = "Обработка всплывающего окна"
    )

    private val addNewAddressSecond = ScreenConstructor(
        androidAccessibilityId = "Добавить новый адрес",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Добавить новый адрес\"]",
        iosAccessibilityId = "Добавить новый адрес",
        iosClassChain = "**/XCUIElementTypeImage[`label == \"Добавить новый адрес\"`]",
        elementName = "Повторный тап на добавление нового адреса",
    )

    private val addressTextBox = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText",
        iosAccessibilityId = "Адрес",
        iosClassName = "XCUIElementTypeTextField",
        elementName = "Поле ввода нового адреса",
    )

    private val apartNumber = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]",
        iosAccessibilityId = "Квартира",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Квартира\"]",
        elementName = "Запись номера квартиры",
    )

    private val entrance = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
        iosAccessibilityId = "Подъезд",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Подъезд\"]",
        elementName = "Запись номера подьезда"
    )

    private val intercom = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
        iosAccessibilityId = "Домофон",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Домофон\"]",
        elementName = "Запись номера подьезда"
    )

    private val floor = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
        iosAccessibilityId = "Этаж",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Этаж\"]",
        elementName = "Запись номера этажа"
    )

    private val commentAddress = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
        iosAccessibilityId = "Комментарий для курьера",
        iosXPath = "//XCUIElementTypeTextField[@name=\"Комментарий для курьера\"]",
        elementName = "Комментарий к адресу"
    )

    private val saveAddressButton = ScreenConstructor(
        androidAccessibilityId = "Сохранить",
        iosAccessibilityId = "Сохранить",
        elementName = "Сохранить записанные данные"
    )

    private val checkAddressInPage = ScreenConstructor(
        androidAccessibilityId = "Сапёрный переулок, 20\n" +
                "кв 23, 2 подъезд, 6 этаж. Домофон: 4466. Комментарий",
        iosAccessibilityId = "Сапёрный переулок, 20\n" +
                "кв 23, 2 подъезд, 6 этаж. Домофон: 4466. Комментарий",
        elementName = "Проврка добавлен ли установленный адрес",
    )

    private val deleteAddressButton = ScreenConstructor(
        androidAccessibilityId = "Удалить",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Удалить\"]",
        iosAccessibilityId = "Удалить",
        elementName = "Кнопка удаления адреса"
    )

    private val myAddressPage = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
        iosClassName = "XCUIElementTypeScrollView",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView",
        elementName = "Окно мои адреса"
    )
}