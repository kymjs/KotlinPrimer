package com.kymjs.springdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringDemoApplication::class.java, *args)
}
