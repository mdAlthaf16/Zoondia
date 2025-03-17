package com.task.zoondia.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    companion object {
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val APPLICATION_TYPE = "application/json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val chainRequest: Request = chain.request()
        val builder: Request.Builder = chainRequest.newBuilder()

        builder.header(HEADER_CONTENT_TYPE, APPLICATION_TYPE)

        val request: Request = builder.build()
        return chain.proceed(request)
    }
}