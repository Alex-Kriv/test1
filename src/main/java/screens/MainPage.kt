package screens

object MainPage {

    val mainPageButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
        iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]",
        iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]",
        elementName = "Кнопка возвращения на главный экран"
    )

    val hotDishButton = ScreenConstructor(
        androidAccessibilityId = "Горячее",
        iosAccessibilityId = "Горячее",
        iosPredicateString = "label == \"Горячее\"",
        elementName = "Выбор подраздела \"Горячее\"",
    )

     val snacksButton = ScreenConstructor(
         androidAccessibilityId = "Закуски",
         iosAccessibilityId = "Закуски",
         iosPredicateString = "label == \"Закуски\"",
         elementName = "Выбор подраздела \"Закуски\"",
     )

    val soupsButton = ScreenConstructor(
        androidAccessibilityId = "Супы",
        iosAccessibilityId = "Супы",
        iosPredicateString = "label == \"Супы\"",
        elementName = "Выбор подраздела \"Супы\"",
    )

    val pastaButton = ScreenConstructor(
        androidAccessibilityId = "Паста",
        iosAccessibilityId = "Паста",
        iosPredicateString = "label == \"Паста\"",
        elementName = "Выбор подраздела \"Паста\"",
    )

    val sandwichButton = ScreenConstructor(
        androidAccessibilityId = "Сендвичи",
        iosAccessibilityId = "Сендвичи",
        iosPredicateString = "label == \"Сендвичи\"",
        elementName = "Выбор подраздела \"Сендвичи\"",
    )
}