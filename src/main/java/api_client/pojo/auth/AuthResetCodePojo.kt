package api_client.pojo.auth

open class AuthResetCodePojo {
    //reqBody так а что тут добавлять, если мы получаем html с номером
    data class AuthResetCodeReqBody(
        val phone: String
    )
}