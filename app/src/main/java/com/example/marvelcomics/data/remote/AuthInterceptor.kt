package com.example.marvelcomics.data.remote

import com.example.marvelcomics.utils.Constant
import com.example.marvelcomics.utils.md5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val publicApiKey = Constant.PUBLIC_API_KEY
        val privateApiKey = Constant.PRIVATE_API_KEY
        val hash = "$timestamp$publicApiKey$privateApiKey".md5()

        with(chain.request()) {
            url.newBuilder().apply {
                addQueryParameter(API_KEY_PARAM, publicApiKey)
                addQueryParameter(TIMESTAMP_PARAM, timestamp)
                addQueryParameter(HASH_PARAM, hash)
            }
                .build().also {
                    return chain.proceed(this.newBuilder().url(it).build())
                }
        }
    }

    companion object {
        private const val API_KEY_PARAM = "apikey"
        private const val TIMESTAMP_PARAM = "ts"
        private const val HASH_PARAM = "hash"


    }


}