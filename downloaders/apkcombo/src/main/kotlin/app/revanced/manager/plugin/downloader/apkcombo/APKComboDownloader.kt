@file:Suppress("Unused")

package app.revanced.manager.plugin.downloader.apkcombo

import android.net.Uri
import app.revanced.manager.plugin.downloader.webview.WebViewDownloader
import kotlin.io.path.ExperimentalPathApi

@OptIn(ExperimentalPathApi::class)
val apkComboDownloader = WebViewDownloader { packageName, version ->
    with(Uri.Builder()) {
        scheme("https")
        authority("apkcombo.com")
        val appName = packageName.substringAfterLast('.')
        if (version == null) {
            path("$appName/$packageName/")
        } else {
            path("$appName/$packageName/download/phone-$version-apk")
        }
        build().toString()
    }
}
