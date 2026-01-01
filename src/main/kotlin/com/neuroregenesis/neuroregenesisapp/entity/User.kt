package com.neuroregenesis.neuroregenesisapp.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "users")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0,

    open var email: String = "",
    open var password: String? = "",
    open var role: String = "USER",
    val createdAt: Instant = Instant.now()
)
