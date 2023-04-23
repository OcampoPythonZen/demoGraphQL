package com.example.demo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

fun Any?.toJsonString(): String {
    return jacksonObjectMapper().writeValueAsString(this)
}
