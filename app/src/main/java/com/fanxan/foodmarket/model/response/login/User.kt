package com.fanxan.foodmarket.model.response.login


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("address")
    var address: String,
    @Expose
    @SerializedName("city")
    var city: String,
    @Expose
    @SerializedName("created_at")
    var createdAt: Long,
    @Expose
    @SerializedName("current_team_id")
    var currentTeamId: Any,
    @Expose
    @SerializedName("email")
    var email: String,
    @Expose
    @SerializedName("email_verified_at")
    var emailVerifiedAt: Any,
    @Expose
    @SerializedName("houseNumber")
    var houseNumber: String,
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("name")
    var name: String,
    @Expose
    @SerializedName("phoneNumber")
    var phoneNumber: String,
    @Expose
    @SerializedName("profile_photo_path")
    var profilePhotoPath: Any,
    @Expose
    @SerializedName("profile_photo_url")
    var profilePhotoUrl: String,
    @Expose
    @SerializedName("roles")
    var roles: String,
    @Expose
    @SerializedName("updated_at")
    var updatedAt: Long
)