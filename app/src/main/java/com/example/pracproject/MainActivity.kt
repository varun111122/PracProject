package com.example.pracproject

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pracproject.ObservableWebView.OnScrollChangedCallback
import com.google.gson.Gson


class MainActivity : AppCompatActivity(), OnScrollChangedCallback {
    var gson = Gson()
    var txt: ObservableWebView? = null
    val heightWebViewJSScript =
        "(function() {var pageHeight = 0;function findHighestNode(nodesList) { for (var i = nodesList.length - 1; i >= 0; i--) {if (nodesList[i].scrollHeight && nodesList[i].clientHeight) {var elHeight = Math.max(nodesList[i].scrollHeight, nodesList[i].clientHeight);pageHeight = Math.max(elHeight, pageHeight);}if (nodesList[i].childNodes.length) findHighestNode(nodesList[i].childNodes);}}findHighestNode(document.documentElement.childNodes); return pageHeight;})()"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("commit new")
        txt = findViewById(R.id.webview)
        txt?.onScrollChangedCallback = this
        txt?.getSettings()?.setJavaScriptEnabled(true); // enable javascript




        txt?.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(this@MainActivity, description, Toast.LENGTH_SHORT).show()
            }

            @TargetApi(Build.VERSION_CODES.M)
            override fun onReceivedError(
                view: WebView,
                req: WebResourceRequest,
                rerr: WebResourceError
            ) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(
                    view,
                    rerr.errorCode,
                    rerr.description.toString(),
                    req.url.toString()
                )
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val exactContentHeight =
                    Math.floor(
                        (txt?.getContentHeight()?.toDouble()
                            ?.times(txt?.getScale()?.toDouble()!!))?.toDouble()!!
                    )
                Log.d("varun", "onPageFinished height: ${exactContentHeight}")



            }
        }

        txt?.loadUrl("https://www.google.com");


    }

    override fun onScroll(l: Int, t: Int, oldl: Int, oldt: Int) {
//        Toast.makeText(this, "${l} $t ", Toast.LENGTH_SHORT).show()

        Log.d("varun", "onScroll: $l $t $oldl  $oldt")
        Log.d("varun", "Hight: " + txt?.contentHeight)

    }


}

