package manuelklyukvin.in_good_hands.core.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    const val API_URL = "http://100.65.6.242:8080/api/"

    private val gson = GsonBuilder().serializeNulls().create()

    val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}