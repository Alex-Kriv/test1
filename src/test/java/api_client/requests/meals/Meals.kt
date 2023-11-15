package api_client.requests.meals

import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.MealsPojo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.restassured.response.Response
import java.lang.reflect.Type


object Meals: Get, Res, MealsPojo() {

    override lateinit var resBody: List<MealsRes>

    override fun getDataFromJSON(response: Response): List<MealsRes> {
        val jsonString = response.asString()
        val modJsonString = "[ $jsonString ]"
        val gson = Gson()
        val type = object : TypeToken<List<MealsRes>>() {}.type
        return gson.fromJson(modJsonString, type)

        /*val itemType  = object : List<MealsRes>
        val i = gson.fromJson(jsonString, MealsRes::class.java) // вместо эни класс который нужно распарсить
        return  */
    }
    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
            queryParams = queryParams,
            endPoint = endPoints.meals,
            responseType = ResponseType.JSON
        )
        resBody = getDataFromJSON(responseJSON)
    }

}