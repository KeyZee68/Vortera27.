package com.bayxd.vortera27.data.remote

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class AdBlockInterceptor : Interceptor {

    private val blockedDomains = setOf(
        "googleads.g.doubleclick.net",
        "pagead2.googlesyndication.com",
        "ad.doubleclick.net",
        "adservice.google.com",
        "youtube.com/pagead/",
        "youtube.com/ptracking",
        "pubads.g.doubleclick.net",
        "securepubads.g.doubleclick.net"
    )

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url.toString()

        val isBlocked = blockedDomains.any { domain -> requestUrl.contains(domain, ignoreCase = true) }

        return if (isBlocked) {
            Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(204)
                .message("Blocked by Vortera27 AdShield Engine")
                .body("".toResponseBody("text/plain".toMediaType()))
                .build()
        } else {
            chain.proceed(request)
        }
    }
}
