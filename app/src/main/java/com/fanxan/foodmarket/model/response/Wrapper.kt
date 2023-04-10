package com.fanxan.foodmarket.model.response


import com.fanxan.foodmarket.model.response.login.LoginResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wrapper<T>(
    @Expose
    @SerializedName("data")
    var data: T? = null,
    @Expose
    @SerializedName("meta")
    var meta: Meta? = null
)