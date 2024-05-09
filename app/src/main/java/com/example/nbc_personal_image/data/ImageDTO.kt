package com.example.nbc_personal_image.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ImageDocument(
    val thumbnail_url:String,
    val display_sitename:String,
    val datetime:String
)

data class ImageMeta(
    @SerializedName("total_count")
    val totalCount:Int?,
    @SerializedName("is_end")
    val isEnd:Boolean?
    )
data class ImageResponse(
    @SerializedName("meta")
    val imageMeta: ImageMeta?,
    @SerializedName("documents")
    var documents:MutableList<ImageDocument>?
)