package api_client.requests.auth

import api_client.Post
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.environment.Environment.environment
import api_client.pojo.auth.AuthLoginPojo
import api_client.pojo.auth.AuthResetCodePojo
import io.restassured.response.Response

object AuthLogin : Post, Res, AuthLoginPojo() {

    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {
        return response.body.asString()
    }

    // Создание body POST запроса
    fun authLoginReqBody(phone: String, code: String): AuthLoginReqBody {
        return AuthLoginReqBody(phone = phone, code = code)
    }

    // отправка запроса POST auth/anonymous
    override fun post(reqBody: Any) {
        val responseJSON = postReq(
            endPoint = endPoints.authLogin,
            reqBody = reqBody,
            responseType = ResponseType.HTML
        )
        // перенос ответа по классам для дальнейшей обработки
        resBody = getDataFromJSON(responseJSON)
        val token = resBody.substringAfter("<html>\n" +
                "  <body>")
        val token1 = token.substringBefore("</html>")
        environment.authToken = token1
        println(environment.authToken)
    }


}