package io.github.kabirnayeem99.islamqakmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform