package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

@SpringBootApplication class DemoApplication

fun main(args: Array<String>) {
  runApplication<DemoApplication>(*args)
}

@Entity
class SomeEntity(
    @Id val id: Int,
    val date: LocalDate,
)

interface SomeEntityRepository : JpaRepository<SomeEntity, Long> {

  @Query("select DATEDIFF(e.date, :date) from SomeEntity e where :date < e.date")
  fun failingQuery(date: LocalDate): List<Int>

  @Query("select DATEDIFF(e.date, :date) from SomeEntity e")
  fun successfulQuery(date: LocalDate): List<Int>
}
