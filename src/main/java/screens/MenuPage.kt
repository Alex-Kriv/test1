package screens

import TestFunctions.clickToElement

object MenuPage {

    fun clickMenuPageButton(){
        clickToElement(
            menuPageButton.androidXPath, LocatorType.XPATH,
            menuPageButton.iosXPath, LocatorType.XPATH,
            elementName = menuPageButton.elementName
        )
    }

    private val menuPageButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[3]",
        elementName = "Кнопка перехода на экран \"Меню\"",
    )
}