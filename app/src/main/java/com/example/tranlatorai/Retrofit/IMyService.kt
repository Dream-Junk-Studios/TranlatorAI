package com.example.tranlatorai.Retrofit
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded

interface IMyService {

    @POST("register")
    @FormUrlEncoded
    fun registerUser(
        @Field("email") email:String,
        @Field("name") name:String,
        @Field("password") password:String): Observable<String>

    @POST("login")
    @FormUrlEncoded
    fun loginUser(
        @Field("email") email:String,
        @Field("password") password:String):Observable<String>

}