package com.example.demo.application

import com.example.demo.domain.Person
import org.springframework.stereotype.Service

@Service
class PersonService {

    fun underAgedFriends(person: Person): List<Person> =
        person.friends.filter { friend -> friend.age < 18 }

    fun neighborFriends(person: Person): List<Person> =
        person.friends.filter { friend -> friend.age < 18 }

}