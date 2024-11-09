package com.example.demo.application

import com.example.demo.domain.Person
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import uk.co.jemos.podam.api.PodamFactoryImpl

class PodamTest {

    private val userService = PersonService()
    private val fixture = PodamFactoryImpl()

    @Test
    fun `should filter under aged friends`() {
        //arrange
        val underAgedFriends = (1..3).map {
            fixture.manufacturePojo(Person::class.java).apply {
                age = (0..17).random()
            }
        }
        val aboveAgedFriends = (1..7).map {
            fixture.manufacturePojo(Person::class.java).apply {
                age = (18..100).random()
            }
        }
        val person = fixture.manufacturePojo(Person::class.java).apply {
            friends = underAgedFriends + aboveAgedFriends
        }

        //act
        val result = userService.underAgedFriends(person)

        //assert
        assertThat(result.size).isEqualTo(underAgedFriends.size)
        assertThat(result).isEqualTo(underAgedFriends)
    }

}