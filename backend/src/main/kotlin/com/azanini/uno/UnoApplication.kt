package com.azanini.uno

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class UnoApplication

fun main(args: Array<String>) {
    runApplication<UnoApplication>(*args)
}
