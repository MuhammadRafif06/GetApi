package com.rafif.latihangetapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafif.latihangetapi.data.UserResponseItem
import com.rafif.latihangetapi.databinding.ActivityMainBinding
import com.rafif.latihangetapi.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getDataApi
        getApi()
    }

    fun setDatas(datas: ArrayList<UserResponseItem>){
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userAdapter
            userAdapter.setUser(datas)
        }
    }

    private fun getApi() {
        ApiConfig.getApiService().getUser().enqueue(object : Callback<ArrayList<UserResponseItem>> {
            override fun onResponse(
                call: Call<ArrayList<UserResponseItem>>,
                response: Response<ArrayList<UserResponseItem>>
            ) {
                response.body()?.let {
                    setDatas(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}