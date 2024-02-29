package org.lotka.xenonx.domain.usecase.auth


import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.repository.AuthRepository
import org.lotka.xenonx.domain.util.ResultState
import org.lotka.xenonx.util.AuthResult2
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LoginUserUseCase @Inject constructor(private val repository: AuthRepository) {
     operator fun invoke( email: String, password: String): Flow<ResultState<AuthResult2>> {
        return (repository.loginUser( email, password))
    }


}

