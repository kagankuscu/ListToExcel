package com.example.listtoexcel.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class MyDialog : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(activity)
            .setTitle("Information")
            .setMessage("Date")
            .setMessage("Daily Job")
            .setPositiveButton("Ok", DialogInterface.OnClickListener { _, _ ->

            }).create()

        return alertDialog
    }
}