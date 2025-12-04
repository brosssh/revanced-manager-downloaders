@file:Suppress("Unused")

package app.revanced.manager.plugin.downloader.apkmirror

import android.net.Uri
import app.revanced.manager.plugin.downloader.webview.WebViewDownloader
import kotlin.io.path.ExperimentalPathApi

@OptIn(ExperimentalPathApi::class)
val ApkMirrorDownloader = WebViewDownloader { packageName, version ->
    with(Uri.Builder()) {
        scheme("https")
        authority("www.apkmirror.com")
        mapOf(
            "post_type" to "app_release",
            "searchtype" to "apk",
            "s" to (version?.let { "$packageName $it" } ?: packageName),
            "bundles%5B%5D" to "apk_files"
        ).forEach { (key, value) ->
            appendQueryParameter(key, value)
        }

        build().toString()
    }
}
