package api_client.environment

object Environment {

    var environment = Evn()
    val endPoints = EndPoints()
    fun getNewHeaders(token: String, id: String): MutableMap<String, String>{
        var headers: MutableMap<String, String> = mutableMapOf(
            "authority" to "api.starterapp.ru",
            "authorization" to token,
            "sessionid" to id,
            "content-type" to "application/json",
            "accept" to "application/json",
            "lang" to "ru",
            "user-agent" to "IOS-device",
            "origin" to "https://school.starterapp.ru",
            "x-real-ip" to "91.197.192.54",
            "timezone" to "Europe/Moscow"
        )
        return headers
    }
    /*var headers: MutableMap<String, String> = mutableMapOf(
        "authority" to "api.starterapp.ru",
        "authorization" to environment.authToken,
        "sessionid" to environment.sessionId,
        "content-type" to "application/json",
        "accept" to "application/json",
        "lang" to "ru",
        "user-agent" to "IOS-device",
        "origin" to "https://school.starterapp.ru",
        "x-real-ip" to "91.197.192.54",
        "timezone" to "Europe/Moscow"
    )*/

    data class Evn(
        var authToken: String = "",
        var sessionId: String = "1f9a128f-0c98-4d5b-8f99-1ff2eb8f4938",
        val host: String = "https://api.starterapp.ru/school/",
        val shopId: String = "8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd"
    )

    data class EndPoints(
        val categories: String = "categories/8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd/v2",
        val resetCode: String = "auth/resetCode",
        val authLogin: String = "auth/login",
        val sessionId: String = "user/sessionId",
        val meals: String = "meals/8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd/v2",
        val user: String = "user/v2"
    )
}