package com.example.prelim

import com.google.gson.annotations.SerializedName

class EducAttributes {

    @SerializedName("apod_site")
    var apod_site: String? = null

    @SerializedName("copyright")
    var copyright: String? = null

    @SerializedName("date")
    var date: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("hdurl")
    var hdurl: String? = null

    @SerializedName("media_type")
    var media_type: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("url")
    var url: String ? = null

}