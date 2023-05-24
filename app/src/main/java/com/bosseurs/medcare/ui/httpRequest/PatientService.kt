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
        @Field("ppr") ppr: String,
        @Field("password") password: String
    ): Call<Patient?>?
    @POST("request")
    fun request(@Body appointement: AppointmentRequest?): Call<AppointmentRequest?>?
    @POST("imc")
    fun imc(@Body imc: ImcRequest?): Call<ImcRequest?>?
}


