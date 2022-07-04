package com.syafei.belajarfundamentalaplikasiandroidrecylerview.data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets


class JsonData : AppCompatActivity() {

    var mobileNumbers: ArrayList<String> = ArrayList()
    var personName: ArrayList<String> = ArrayList()
    var emailId: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("users")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                personName.add(userDetail.getString("name"))
                emailId.add(userDetail.getString("email"))
                val contact = userDetail.getJSONObject("contact")
                mobileNumbers.add(contact.getString("mobile"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("githubuser.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

    /*private fun readSampleJSON(): Unit {
        val file_name = "githubuser.json"
        val bufferReader = application.assets.open(file_name).bufferedReader()
        val data = bufferReader.use {
            it.readText()
        }

        val jsonObject = JSONObject(data)

        val name = jsonObject.getString("name")
        val age = jsonObject.getInt("age")
        val height = jsonObject.getDouble("height")

        Log.d("readSampleJSON", "name : $name || age : $age || height: $height")
    }*/


    /*private fun readArrayOfJsonObject(): Unit {

        val bufferReader = application.assets.open("githubuser.json").bufferedReader()
        val json_string = bufferReader.use {
            it.readText()
        }
        val jsonArray = JSONArray(json_string);

        for (i in 0..jsonArray.length() - 1) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)

            val name = jsonObject.getString("name")
            val version = jsonObject.getString("version")

            Log.d("readArrayOfJsonObject", "name: $name || version : $version  \n")
        }
    }*/

}