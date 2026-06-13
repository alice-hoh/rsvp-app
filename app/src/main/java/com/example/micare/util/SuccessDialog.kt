package com.example.micare.util

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.example.micare.R

object SuccessDialog {

    fun show(context: Context, message: String) {
        if (context !is android.app.Activity || context.isFinishing) return

        val dialogView = LayoutInflater.from(context)
            .inflate(R.layout.dialog, null)

        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        val tvMessage = dialogView.findViewById<TextView>(R.id.tvMessage)
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)

        tvMessage.text = message

        btnOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setCancelable(false)

        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}