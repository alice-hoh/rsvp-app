package com.example.micare.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.micare.util.ValidationUtil
import androidx.activity.viewModels
import com.example.micare.R
import com.example.micare.viewmodel.MainViewModel
import com.example.micare.util.SuccessDialog

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etContact = findViewById<EditText>(R.id.etContact)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val contactNo = etContact.text.toString().trim()
            val email = etEmail.text.toString().trim()

            val error = ValidationUtil.validate(firstName, lastName, contactNo, email)
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.submitRsvp(
                firstName,
                lastName,
                contactNo,
                email,
                onSuccess = { message ->
                    SuccessDialog.show(this, message)
                },
                onError = { error ->
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                }
            )
        }

    }
}
