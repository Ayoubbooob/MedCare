package com.bosseurs.medcare.ui.httpRequest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitAPI {
    @POST("register")
    fun register(@Body patient: Patient?): Call<Patient?>?

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("cin") cin: String,
        @Field("password") password: String
    ): Call<Patient?>
}


