package com.yazan.librarykmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform