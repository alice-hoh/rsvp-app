package com.example.micare.util

import android.util.Patterns

object ValidationUtil {

    fun validate(
        firstName: String,
        lastName: String,
        contactNo: String,
        email: String
    ): String? {

        if (firstName.isBlank())
            return "First name is required"

        if (firstName.length > 100)
            return "First name must not exceed 100 characters"

        if (lastName.isBlank())
            return "Last name is required"

        if (lastName.length > 100)
            return "Last name must not exceed 100 characters"

        if (!contactNo.matches(Regex("^[0-9]+$")))
            return "Contact number must contain numbers only"

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return "Invalid email format"

        if (email.length > 300)
            return "Email must not exceed 300 characters"

        return null
    }
}
