package com.example.micare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.micare.network.ApiClient
import com.example.micare.model.ApiError
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun submitRsvp(
        firstName: String,
        lastName: String,
        contactNo: String,
        email: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {

        viewModelScope.launch {

            try {

                val response = ApiClient.api.submitRsvp(
                    apiKey = "123456",
                    firstName = firstName,
                    lastName = lastName,
                    contactNo = contactNo,
                    email = email
                )

                if (response.isSuccessful) {

                    val message =
                        response.body()?.string()
                            ?: "Submission successful."

                    onSuccess(message)

                } else {

                    val errorBody = response.errorBody()?.string()

                    val apiError = try {
                        Gson().fromJson(errorBody, ApiError::class.java)
                    } catch (e: Exception) {
                        null
                    }

                    onError(apiError?.title ?: "Submission failed.")
                }

            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}