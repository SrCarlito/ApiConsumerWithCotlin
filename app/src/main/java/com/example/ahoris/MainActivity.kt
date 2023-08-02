package com.example.ahoris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ahoris.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitTraer = RetrofitClient.consumirApi.getTraer()

        retrofitTraer.enqueue(object : Callback<Posts>{
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                var xd = response.body()?.get(9)
                binding.tvMostrar.text = xd?.id.toString()


            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error al consultar Api Rest",Toast.LENGTH_SHORT).show()
            }

        })

    }
}