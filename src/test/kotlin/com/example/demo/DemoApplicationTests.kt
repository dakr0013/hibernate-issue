package com.example.demo

import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

  @Autowired lateinit var repository: SomeEntityRepository

  @Test
  fun failingTest() {
    repository.save(SomeEntity(0, LocalDate.EPOCH))

    assertDoesNotThrow { repository.failingQuery(LocalDate.EPOCH) }
  }

  @Test
  fun successfulTest() {
    repository.save(SomeEntity(1, LocalDate.EPOCH))

    assertDoesNotThrow { repository.successfulQuery(LocalDate.EPOCH) }
  }
}
