package com.example.pracproject

import com.google.gson.annotations.SerializedName

data class TempModel(
    @SerializedName("name")
    var name: String,
    @SerializedName("age")
    var age: Int,

    @SerializedName("email")
    var email: String
)
