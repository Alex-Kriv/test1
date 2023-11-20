package api_client.requests.user

import api_client.Get
import api_client.Res
import api_client.environment.Environment
import api_client.pojo.user.UserPojo
import api_client.requests.categories.Categories
import com.google.gson.Gson
import io.restassured.response.Response

object User : Get, Res, UserPojo() {

    override lateinit var resBody: UserPojoRes
    override fun getDataFromJSON(response: Response): UserPojoRes {
        val jsonString = response.asString()
        val gson = Gson()
        return gson.fromJson(jsonString, UserPojoRes::class.java) // вместо эни класс который нужно распарсить
    }


    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
            queryParams = queryParams,
            endPoint = Environment.endPoints.user,
            responseType = ResponseType.JSON
        )
        resBody = getDataFromJSON(responseJSON)
    }

}