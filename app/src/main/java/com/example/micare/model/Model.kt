package com.example.micare.model
import com.google.gson.annotations.SerializedName

data class RsvpRequest(
    @SerializedName("ApiKey")
    val apiKey: String,

    @SerializedName("FirstName")
    val firstName: String,

    @SerializedName("LastName")
    val lastName: String,

    @SerializedName("ContactNo")
    val contactNo: String,

    @SerializedName("Email")
    val email: String
)

data class ApiError(
    val type: String?,
    val title: String?,
    val status: Int?,
    val traceId: String?,
    val errors: Map<String, List<String>>?
)

data class RsvpResponse(
    val success: Boolean,
    val message: String
)
