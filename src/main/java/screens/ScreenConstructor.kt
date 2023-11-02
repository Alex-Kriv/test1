package screens

data class ScreenConstructor (
    // здесь будут храниться сами локаторы (папки, пути)
    val androidId: String = "",
    val androidAccessibilityId: String = "",
    val androidXPath: String = "",
    val androidClassName: String = "",
    val elementName: String = "",
    val iosAccessibilityId: String = "",
    val iosId: String = "",
    val iosXPath: String = "",
    val iosClassChain: String = "",
    val iosPredicateString: String = "",
    val iosClassName: String = "",
)
