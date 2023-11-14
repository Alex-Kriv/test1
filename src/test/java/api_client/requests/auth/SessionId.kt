package api_client.requests.auth

import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import io.restassured.response.Response

object SessionId : Get, Res  {

    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {
        return response.body.asString()
    }


    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
            queryParams = queryParams,
            endPoint = endPoints.sessionId,
            responseType = ResponseType.HTML

        )
        resBody = getDataFromJSON(responseJSON)
        println(1111111111111)
        println(resBody)
    }

}