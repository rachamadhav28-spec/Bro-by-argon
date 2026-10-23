package com.argon.githubagent

object CodeAnalyzerEngine {
    fun countLines(code: String): Int = if (code.isEmpty()) 1 else code.lines().size
}
