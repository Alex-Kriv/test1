package screens

data class ScreenConstructor (
    // здесь будут храниться сами локаторы (папки, пути)
    val androidId: String = "",
    var androidAccessibilityId: String = "",
    var androidXPath: String = "",
    val androidClassName: String = "",
    val elementName: String = "",
    var iosAccessibilityId: String = "",
    val iosId: String = "",
    val iosXPath: String = "",
    var iosClassChain: String = "",
    val iosPredicateString: String = "",
    val iosClassName: String = "",
)
