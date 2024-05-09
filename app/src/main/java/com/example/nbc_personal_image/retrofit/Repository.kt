package com.example.nbc_personal_image.retrofit

import com.example.nbc_personal_image.data.ImageResponse
import retrofit2.Response


class Repository : NetWorkInterface{
    override suspend fun searchImage(
        query:String,
        sort:String,
        page:Int,
        size:Int
    ) : Response<ImageResponse> {
        return NetWorkClient.imageNetWork.searchImage(query = query, sort = sort, page = page, size = size)
    }
}