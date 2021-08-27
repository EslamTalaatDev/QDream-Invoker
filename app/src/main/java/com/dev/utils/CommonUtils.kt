package com.dev.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent

import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.net.Uri
import android.provider.Settings

import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.dev.R
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class CommonUtils internal constructor() {

    companion object {


        fun toast(message: String, context: Context) {
            val toast = Toast(context)
            val view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null)
            val textView = view.findViewById(R.id.toast_message) as TextView
            textView.text = message
            toast.view = view
            toast.setGravity(Gravity.BOTTOM or Gravity.BOTTOM, 0, 0)
            toast.setMargin(0.0F, 0.1f)
            toast.duration = Toast.LENGTH_LONG
            toast.show()
        }

        fun hideKeyboardFrom(context: Context, view: View) {

            val imm: InputMethodManager =
                context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }


        @SuppressLint("all")
        fun getDeviceId(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        val timestamp: String
            get() = SimpleDateFormat("yyyyMMdd_H", Locale.US).format(Date())

        fun isEmailValid(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }


        fun getBitmapFromURL(src: String): Bitmap? {
            try {
                val url = URL(src)
                val connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input = connection.inputStream
                return BitmapFactory.decodeStream(input)
            } catch (e: IOException) {
                // Log exception
                return null
            }

        }


        fun browserIntent(context: Context, url: String) {
            val uri: Uri =
                Uri.parse(url) // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)

        }


        fun phoneIntent(phoneNumber: String, context: Context) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null))
            context.startActivity(intent)
        }

    }


}
