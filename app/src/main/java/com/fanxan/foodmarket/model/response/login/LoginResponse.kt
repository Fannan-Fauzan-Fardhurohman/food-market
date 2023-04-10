package com.fanxan.foodmarket.model.response.login


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @Expose
    @SerializedName("access_token")
    var accessToken: String,
    @Expose
    @SerializedName("token_type")
    var tokenType: String,
    @Expose
    @SerializedName("user")
    var user: User
)