package api_client.requests.auth

import ResponseType
import api_client.Post
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.environment.Environment.environment
//import api_client.environment.Environment.headers
import api_client.pojo.auth.AuthResetCodePojo
import io.restassured.response.Response
import java.util.concurrent.TimeUnit

object AuthResetCode : Post, Res, AuthResetCodePojo() {

    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {
        return response.body.asString()
    }

    // Создание body POST запроса
    fun authResetCodeReqBody(phone: String): AuthResetCodeReqBody {
        return AuthResetCodeReqBody(phone = phone)
    }

    // отправка запроса POST auth/anonymous
    override fun post(reqBody: Any) {
        val responseJSON = postReq(
            endPoint = endPoints.resetCode,
            reqBody = reqBody,
            responseType = ResponseType.HTML
        )
        println(environment.sessionId)
        //println(headers.get("sessionid"))
        // перенос ответа по классам для дальнейшей обработки
        resBody = getDataFromJSON(responseJSON)
    }
}