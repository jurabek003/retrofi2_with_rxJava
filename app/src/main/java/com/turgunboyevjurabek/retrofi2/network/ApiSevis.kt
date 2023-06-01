package com.turgunboyevjurabek.retrofi2.network

import com.turgunboyevjurabek.retrofi2.madels.Valyuta
import io.reactivex.Single
import retrofit2.http.GET

interface ApiSevis {
    @GET("json/")
    fun getData(): Single<Valyuta>
}