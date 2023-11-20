package screens

import TestFunctions.clickToElement

object MainPage {

    fun clickMainPageButton(){
        clickToElement(
            locatorAndroid = mainPageButton.androidXPath,
            locatorTypeAndroid = LocatorType.XPATH,
            locatorIOS = mainPageButton.iosXPath,
            locatorTypeIOS = LocatorType.XPATH,
            elementName = mainPageButton.elementName
        )
    }

    fun clickSnacksButton(){
        clickToElement(
            snacksButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            snacksButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = snacksButton.elementName
        )
    }

    fun clickSoupsButton(){
        clickToElement(
            soupsButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            soupsButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = soupsButton.elementName
        )
    }

    fun clickPastaButton(){
        clickToElement(
            pastaButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            pastaButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = pastaButton.elementName
        )
    }

    fun clickSandwichButton(){
        clickToElement(
            sandwichButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            sandwichButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = sandwichButton.elementName
        )
    }

    fun clickHotDishButton(){
        clickToElement(
            hotDishButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            hotDishButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID,
            elementName = hotDishButton.elementName
        )
    }

    fun clickKruasanButton(){
        clickToElement(
            kruasanButton.androidXPath, LocatorType.XPATH,
            kruasanButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN,
            elementName = kruasanButton.elementName
        )
    }

    fun setNewSnackButton(newLocator: String){
        snacksButton.androidAccessibilityId = newLocator
        snacksButton.iosAccessibilityId = newLocator
    }

    fun setKruasanButtom(locator: Int) {
        kruasanButton.androidXPath = "//android.widget.ImageView[@content-desc=\"${locator} ₽\"]"
        kruasanButton.iosClassChain = "**/XCUIElementTypeImage[`label == \"${locator} ₽\"`]"
    }


    private val mainPageButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]",
        iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]",
        elementName = "Кнопка возвращения на главный экран"
    )

    val snacksButton = ScreenConstructor(
        androidAccessibilityId = "",
        iosAccessibilityId = "",
        iosPredicateString = "label == \"Закуски\"",
        elementName = "Выбор подраздела \"Закуски\"",
    )

    val kruasanButton = ScreenConstructor(
        androidAccessibilityId = "222 ₽",
        iosAccessibilityId = "222 ₽",
        androidXPath = "",
        iosClassChain = "",
        elementName = "Стоимость круассана"
    )

    private val soupsButton = ScreenConstructor(
        androidAccessibilityId = "Супы",
        iosAccessibilityId = "Супы",
        iosPredicateString = "label == \"Супы\"",
        elementName = "Выбор подраздела \"Супы\"",
    )

    private val pastaButton = ScreenConstructor(
        androidAccessibilityId = "Паста",
        iosAccessibilityId = "Паста",
        iosPredicateString = "label == \"Паста\"",
        elementName = "Выбор подраздела \"Паста\"",
    )

    private val sandwichButton = ScreenConstructor(
        androidAccessibilityId = "Сендвичи",
        iosAccessibilityId = "Сендвичи",
        iosPredicateString = "label == \"Сендвичи\"",
        elementName = "Выбор подраздела \"Сендвичи\"",
    )

    private val hotDishButton = ScreenConstructor(
        androidAccessibilityId = "Горячее",
        iosAccessibilityId = "Горячее",
        iosPredicateString = "label == \"Горячее\"",
        elementName = "Выбор подраздела \"Горячее\"",
    )
}