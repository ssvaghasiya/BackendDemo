package com.neuroregenesis.neuroregenesisapp.controller

import com.neuroregenesis.neuroregenesisapp.dto.CreateUserRequest
import com.neuroregenesis.neuroregenesisapp.dto.UserResponse
import com.neuroregenesis.neuroregenesisapp.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateUserRequest): UserResponse {
        return userService.createUser(request)
    }

    @GetMapping
    fun list(): List<UserResponse> {
        return userService.getAll()
    }
}
