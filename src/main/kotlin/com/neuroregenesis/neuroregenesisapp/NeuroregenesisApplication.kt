package com.neuroregenesis.neuroregenesisapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class NeuroregenesisApplication

fun main(args: Array<String>) {
	runApplication<NeuroregenesisApplication>(*args)
}
