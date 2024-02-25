package com.github.wskel.userservice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private const val PATH = "/api/hello"

@RestController
@RequestMapping(PATH)
class HelloController : PublicResource {
    override val path get() = PATH

    @GetMapping
    fun hello() = "Hello"
}