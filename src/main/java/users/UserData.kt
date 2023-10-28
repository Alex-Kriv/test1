package users

data class UserData (
    // дата класс с описанием пользователя
    val name : String = "",
    val surname : String = "",
    val phoneNumber : String = "",
    var smsCode : String = "",
    val email : String = "",
    val city : String = "",
    val street : String = "",
    val homeNumber : String = "",
    val apartNumber : String = "",
    val entrance : String = "",
    val intercom : String = "",
    val floor : String = "",
    val commentAddress : String = "",
    var userWasAuthorized : Boolean = false

)
