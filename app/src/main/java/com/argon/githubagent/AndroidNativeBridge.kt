package com.argon.githubagent

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.webkit.JavascriptInterface
import android.widget.Toast

class AndroidNativeBridge(private val context: Context) {
    @JavascriptInterface
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    @JavascriptInterface
    fun copyToClipboard(label: String, text: String) {
        val cb = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cb.setPrimaryClip(ClipData.newPlainText(label, text))
    }
    @JavascriptInterface
    fun getDeviceInfo(): String = "${Build.MANUFACTURER} ${Build.MODEL}"
}
