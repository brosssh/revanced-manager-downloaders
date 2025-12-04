@file:Suppress("Unused")

package app.revanced.manager.plugin.downloader.apkpure

import android.net.Uri
import app.revanced.manager.plugin.downloader.webview.WebViewDownloader
import kotlin.io.path.ExperimentalPathApi

@OptIn(ExperimentalPathApi::class)
val apkPureDownloader = WebViewDownloader { packageName, version ->
    with(Uri.Builder()) {
        scheme("https")
        authority("apkpure.net")
        if (version == null) {
            path("$packageName/$packageName")
        } else {
            path("$packageName/$packageName/download/$version")
        }
        build().toString()
    }
}
