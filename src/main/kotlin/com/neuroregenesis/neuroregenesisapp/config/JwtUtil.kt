package com.neuroregenesis.neuroregenesisapp.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {

    private val key = Keys.hmacShaKeyFor("NEUROREGENESIS_SUPER_SECURE_JWT_SECRET_256_BITS_MIN".toByteArray())

    fun generate(email: String): String =
        Jwts.builder()
            .subject(email)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + 86400000))
            .signWith(key)
            .compact()

    fun validate(token: String): String =
        Jwts.parser().verifyWith(key).build()
            .parseSignedClaims(token).payload.subject
}
