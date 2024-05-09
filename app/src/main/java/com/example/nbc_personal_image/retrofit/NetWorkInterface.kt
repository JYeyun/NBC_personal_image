package com.example.nbc_personal_image.retrofit

import com.example.nbc_personal_image.data.ImageResponse import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetWorkInterface {
    @Headers("Authorization: KakaoAK ${Constants.AUTH_HEADER}")
    @GET("https://dapi.kakao.com/v2/search/image")

    suspend fun searchImage(
        @Query("query") query: String,
        @Query("sort") sort:String,
        @Query("page") page:Int,
        @Query("size") size:Int = 80
    ): Response<ImageResponse>
}