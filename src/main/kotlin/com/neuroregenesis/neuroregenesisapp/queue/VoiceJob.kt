package com.neuroregenesis.neuroregenesisapp.queue

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class VoiceJob {

    @Async
    fun process(text: String) {
        println("Generating voice for: $text")
        Thread.sleep(5000) // simulate delay
        println("Voice generated")
    }
}
