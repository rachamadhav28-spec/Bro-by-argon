package com.argon.githubagent

import java.io.InputStream
import java.util.zip.ZipInputStream

object ZipExtractorHelper {
    fun listEntries(stream: InputStream): List<String> {
        val out = mutableListOf<String>()
        ZipInputStream(stream).use { zis ->
            var e = zis.nextEntry
            while (e != null) {
                if (!e.isDirectory) out.add(e.name)
                zis.closeEntry()
                e = zis.nextEntry
            }
        }
        return out
    }
}
