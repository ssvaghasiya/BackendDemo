package com.neuroregenesis.neuroregenesisapp.service

import com.neuroregenesis.neuroregenesisapp.dto.CreateUserRequest
import com.neuroregenesis.neuroregenesisapp.dto.UserResponse
import com.neuroregenesis.neuroregenesisapp.entity.User
import com.neuroregenesis.neuroregenesisapp.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUser(request: CreateUserRequest): UserResponse {
        val existing = userRepository.findByEmail(request.email)
        if (existing != null) {
            throw IllegalStateException("User already exists")
        }

        val saved = userRepository.save(
            User(email = request.email, password = request.password)
        )

        return UserResponse(
            id = saved.id,
            email = saved.email,
            role = saved.role
        )
    }

    fun getAll(): List<UserResponse> =
        userRepository.findAll().map {
            UserResponse(it.id, it.email, it.role)
        }
}
