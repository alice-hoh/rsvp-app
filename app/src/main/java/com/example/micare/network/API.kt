package com.example.micare.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RsvpApiService {

//    @Headers("Content-Type: application/json")
//    @POST("interviewapi/AssessmentTestRSVP")
//    suspend fun submitRsvp(
//        @Body request: RsvpRequest
//    ): Response<RsvpResponse>

    @GET("interviewapi/AssessmentTestRSVP")
    suspend fun submitRsvp(
        @Query("ApiKey") apiKey: String,
        @Query("FirstName") firstName: String,
        @Query("LastName") lastName: String,
        @Query("ContactNo") contactNo: String,
        @Query("Email") email: String
    ): Response<ResponseBody>
}



