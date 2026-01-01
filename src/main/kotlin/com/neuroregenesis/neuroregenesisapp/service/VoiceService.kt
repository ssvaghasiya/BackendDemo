package com.neuroregenesis.neuroregenesisapp.service

import com.neuroregenesis.neuroregenesisapp.queue.VoiceJob
import org.springframework.stereotype.Service

@Service
class VoiceService(private val job: VoiceJob) {

    fun generate(text: String) {
        job.process(text) // async
    }
}
