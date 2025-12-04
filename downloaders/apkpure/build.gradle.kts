plugins {
    alias(libs.plugins.kotlin.parcelize)
}

android {
    val packageName = "app.revanced.manager.plugin.downloader.apkpure"
    namespace = packageName
    defaultConfig {
        applicationId = packageName
    }
}
