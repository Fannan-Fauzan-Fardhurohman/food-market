package com.fanxan.foodmarket.model.response


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meta(
    @Expose
    @SerializedName("code")
    var code: Int,
    @Expose
    @SerializedName("message")
    var message: String,
    @Expose
    @SerializedName("status")
    var status: String
)