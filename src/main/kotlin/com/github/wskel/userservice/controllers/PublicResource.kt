package com.github.wskel.userservice.controllers

interface PublicResource {
    val path: String
}

val Array<out PublicResource>.paths: Array<String>
    get() = Array(size) { index -> this[index].path }