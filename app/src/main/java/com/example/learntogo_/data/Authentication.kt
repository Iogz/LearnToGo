package com.example.learntogo_.data

import com.example.learntogo_.data.util.Resource
import com.google.firebase.auth.AuthResult


interface Authentication {
    fun loginUser (email : String, password: String): kotlinx.coroutines.flow.Flow<Resource<AuthResult>>
    fun registerUser (email : String, password: String): kotlinx.coroutines.flow.Flow<Resource<AuthResult>>
}