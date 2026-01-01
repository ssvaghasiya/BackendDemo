package com.neuroregenesis.neuroregenesisapp.controller

import com.neuroregenesis.neuroregenesisapp.config.JwtUtil
import com.neuroregenesis.neuroregenesisapp.dto.LoginRequest
import com.neuroregenesis.neuroregenesisapp.dto.LoginResponse
import com.neuroregenesis.neuroregenesisapp.entity.User
import com.neuroregenesis.neuroregenesisapp.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val repo: UserRepository,
    private val jwt: JwtUtil,
    private val encoder: BCryptPasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): LoginResponse {
        val user = repo.findByEmail(req.email)
            ?: throw RuntimeException("Invalid user")

        if (!encoder.matches(req.password, user.password))
            throw RuntimeException("Invalid password")

        return LoginResponse(jwt.generate(user.email))
    }

    @PostMapping("/register")
    fun register(@RequestBody req: LoginRequest): String {
        val user = User(
            email = req.email,
            password = encoder.encode(req.password)
        )
        repo.save(user)
        return "User registered"
    }

}