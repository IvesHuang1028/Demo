package com.cathaywork.demo.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.cathaywork.demo.data.model.AttractionData
import java.lang.reflect.Field

object AppContact {
    var language: String = ""
    var API_CODE_ATTRCTIONS : Int = 0
    lateinit var attdata : AttractionData
    /**
     * get SharePreferences type data function
     * @input : Context
     * @result : SharePreferences type data
     */
    fun getAllProperty(context:Context) {
        val settings = context.getSharedPreferences ("Cathay.demoProperty", Context.MODE_MULTI_PROCESS)
        language = settings.getString("language", "zh-tw").toString()   //預設繁中
    }
    /**
     * get SharePreferences type data function
     * @input : Context,Key string
     * @result : save key string data
     */
    fun setProperty(context: Context, key: String) {
        try {
            val f: Field = AppContact::class.java.getField(key)
            val t = f.type
            val settings =
                context.getSharedPreferences("Cathay.demoProperty", Context.MODE_MULTI_PROCESS)
            var editor = settings.edit()
            if (t == String::class.java) editor.putString(
                key,
                f[null] as String
            ) else if (t == Boolean::class.javaPrimitiveType) editor.putBoolean(
                key,
                f.getBoolean(null)
            ) else if (t == Double::class.javaPrimitiveType) editor = putDouble(
                editor,
                key,
                f.getDouble(null)
            ) else if (t == Float::class.javaPrimitiveType) editor.putFloat(
                key,
                f.getFloat(null)
            ) else if (t == Int::class.javaPrimitiveType) editor.putInt(
                key,
                f.getInt(null)
            ) else if (t == Long::class.javaPrimitiveType) editor.putLong(
                key,
                f.getLong(null)
            ) else throw Exception("no such type of setProperty overloading")
            editor.apply()
        } catch (e: Exception) {
            Log.e("Property", e.message.toString())
            Toast.makeText(context, "setProperty fatal error", Toast.LENGTH_SHORT)
        }
    }

    private fun putDouble(
        edit: SharedPreferences.Editor,
        key: String,
        value: Double
    ): SharedPreferences.Editor {
        return edit.putLong(key, java.lang.Double.doubleToRawLongBits(value))
    }
}