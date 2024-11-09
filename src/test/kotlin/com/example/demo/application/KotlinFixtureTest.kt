package com.example.demo.application

import com.example.demo.domain.Person
import com.github.nylle.javafixture.Fixture
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class KotlinFixtureTest {

    private val userService = PersonService()
    private val fixture = Fixture()

    @Test
    fun `should filter under aged friends`() {
        //arrange
        val underAgedFriends = fixture.build(Person::class.java)
            .with { it.age = (0..17).random() }
            .createMany(3)
            .toList()
        val aboveAgedFriends = fixture.build(Person::class.java)
            .with { it.age = (18..100).random() }
            .createMany(7)
            .toList()
        val person = fixture.build(Person::class.java)
            .with { it.friends = underAgedFriends + aboveAgedFriends }
            .create()

        //act
        val result = userService.underAgedFriends(person)

        //assert
        assertThat(result.size).isEqualTo(underAgedFriends.size)
        assertThat(result).isEqualTo(underAgedFriends)
    }

}