package me.practice.kotlinspring.controller.dto

data class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var address: String? = null
)
