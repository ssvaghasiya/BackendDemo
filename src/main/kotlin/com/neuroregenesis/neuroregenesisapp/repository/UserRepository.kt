package com.neuroregenesis.neuroregenesisapp.repository

import com.neuroregenesis.neuroregenesisapp.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
}
