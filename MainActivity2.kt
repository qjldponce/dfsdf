package com.example.prelim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    private var pictureData: TextView? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var manage: RecyclerView.LayoutManager
    private lateinit var Adapt: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        manage = LinearLayoutManager(this)
        pictureData = findViewById(R.id.IdView)
        findViewById<View>(R.id.button).setOnClickListener {
            getCurrentData()
        }

    }
    private fun getCurrentData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(EducService::class.java)
        val call = service.getCardData()
        call.enqueue(object : Callback<List<EducAttributes>> {
            override fun onResponse(
                call: Call<List<EducAttributes>>,
                response: retrofit2.Response<List<EducAttributes>>
            ){
                if (response.code() == 200) {
                    val cardAttributes = response.body()!!
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
                        Adapt = EducAdapter(response.body()!!)
                        layoutManager = manage
                        adapter = Adapt
                    }
                    val stringBuilder = "ID: " +
                            cardAttributes[0].media_type +
                            "\n" +
                            "Title: " +
                            cardAttributes[1].title +
                            "\n" +
                            "Description: " +
                            cardAttributes[2].description
                }
            }

            override fun onFailure(call: Call<List<EducAttributes>>, t: Throwable) {
                pictureData!!.text = t.message
            }
        })
    }
    companion object {
        var BaseUrl =  "https://apodapi.herokuapp.com/"
    }
}