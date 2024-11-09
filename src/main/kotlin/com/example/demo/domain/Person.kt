package com.example.demo.domain

data class Person(
    val id: Long,
    val name: String,
    var age: Int,
    val email: String,
    val address: Address,
    var friends: List<Person> = listOf()
)