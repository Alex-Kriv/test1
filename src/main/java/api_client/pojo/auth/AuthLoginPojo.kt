package api_client.pojo.auth

open class AuthLoginPojo {
    // что здесь писать если приходит html с токеном
    data class AuthLoginReqBody(
        val code: String,
        val phone: String
    )
}