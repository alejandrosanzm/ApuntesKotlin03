package com.example.apunteskotlin03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v?.id == button.id) {
                getResponse()
            }
        }
    }

    fun getResponse() {
        if (txtId.text != null) {
            var id = txtId.text.toString().toInt()
            val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://192.168.0.23/kotlin/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val service = retrofit.create<ApiService>(ApiService::class.java)

            service.getResponseWithParam(id).enqueue(object : Callback<List<Pojo>> {

                override fun onResponse(call: Call<List<Pojo>>?, response: Response<List<Pojo>>?) {
                    val pojo = response?.body()
                    txtHello.text = Gson().toJson(pojo).toString()
                    // Log.i(TAG_LOGS, Gson().toJson(pojo))
                }

                override fun onFailure(call: Call<List<Pojo>>?, t: Throwable?) {
                    t?.printStackTrace()
                }
            })
        }
    }
}
