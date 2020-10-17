package co.app.bitcoinandroidtrackerapplication.networkContracter

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {
    @GET("currentprice.json")
    fun getcurrentprice(): Call<JsonObject>



}
