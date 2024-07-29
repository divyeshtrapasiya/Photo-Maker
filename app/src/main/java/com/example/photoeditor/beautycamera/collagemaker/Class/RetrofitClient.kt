//package com.example.photoeditor.beautycamera.collagemaker.Class
//
//import com.example.photoeditor.beautycamera.collagemaker.Interface.ApiService
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//    private const val BASE_URL = "https://s3.eu-north-1.amazonaws.com/photoeditorbeautycamera.com/collagemaker/"
//
//    val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiService: ApiService = retrofit.create(ApiService::class.java)
//}
