package com.example.mobilecodingexercise.api

import com.example.mobilecodingexercise.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = BuildConfig.API_KEY
        const val PRIVATE_KEY = BuildConfig.PRIVATE_KEY
        private fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md5 = MessageDigest.getInstance("MD5")
            return BigInteger(1,md5.digest(input.toByteArray())).toString(16).padStart(32, '0')

        }
        val hash = hash()
    }
}