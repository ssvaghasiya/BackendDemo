package com.neuroregenesis.neuroregenesisapp.controller

import com.neuroregenesis.neuroregenesisapp.service.VoiceService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/voice")
class VoiceController(private val service: VoiceService) {

    @PostMapping("/generate")
    fun generate(@RequestBody body: Map<String, String>): String {
        service.generate(body["text"]!!)
        return "Voice generation started"
    }
}
