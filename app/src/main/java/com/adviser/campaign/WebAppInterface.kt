package com.adviser.campaign

import android.webkit.JavascriptInterface
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Kairos on 2017. 5. 25..
 */

class WebAppInterface {

    val req: String?
    var urls: Array<String>? = null
    var cur = -1

    constructor(req: String?) {
        this.req = req
        reqParser()
    }

    fun reqParser() {
        val urls: Array<String>?

        val images: JSONArray = JSONObject(req).getJSONArray("images")
        urls = Array(images.length(), { _ -> "" })

        for (i in 0..images.length() - 1) {
            urls[i] = (images[i] as JSONObject).getString("url")
        }

        this.urls = urls
        cur = 0
    }

    @JavascriptInterface
    fun getImageUrl(): String? {
        print(urls!![cur])
        // TODO add Exception process
        return urls!![cur++]
    }

    @JavascriptInterface
    fun noMoreToSee() {
        //TODO
    }
}