package org.lotka.xenonx.domain.repository

import com.google.firebase.auth.AuthResult


import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.util.ResultState

import org.lotka.xenonx.util.AuthResult2

interface AuthRepository {

    fun loginUser(emile:String,password:String): Flow<ResultState<AuthResult2>>
    fun registerUser(userName:String,emile:String,password:String): Flow<ResultState<AuthResult2>>


}