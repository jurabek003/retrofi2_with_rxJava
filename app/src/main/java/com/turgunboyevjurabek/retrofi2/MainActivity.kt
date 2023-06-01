package com.turgunboyevjurabek.retrofi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.turgunboyevjurabek.retrofi2.databinding.ActivityMainBinding
import com.turgunboyevjurabek.retrofi2.madels.Valyuta
import com.turgunboyevjurabek.retrofi2.network.ApiClient
import com.turgunboyevjurabek.retrofi2.network.ApiSevis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var adabterRv: AdabterRv
    lateinit var apiSevis: ApiSevis
    lateinit var list: ArrayList<Valyuta>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        apiSevis.getData().enqueue(object : Callback<List<Valyuta>> {
//            override fun onResponse(call: Call<List<Valyuta>>, response: Response<List<Valyuta>>) {
//                if (response.isSuccessful && response.body()!=null){
//                    val list=response.body()
//                    binding.tht.text=list.toString()
//                }
//
//            }
//
//            override fun onFailure(call: Call<List<Valyuta>>, t: Throwable) {
//                Log.d("@getData", "onFailure: ${t.message}")
//            }
//        })

        // rxJava bilan

        apiSevis=ApiClient.getRetrofitServis(this)

        apiSevis.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result->
                    list=ArrayList()
                    list.addAll((listOf(result)))
                    adabterRv=AdabterRv(list)
                    adabterRv.notifyDataSetChanged()
                    binding.myProgress.visibility=View.GONE
                    binding.rvvv.adapter=adabterRv

                },
                {
                    error->
                    Log.d("@getData", "onCreate: $error")
                }
            )


    }
}
