package com.oscar.domain.usescase

import com.oscar.domain.repository.UserRepository
import com.oscar.domain.utilities.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(email: String, password: String) = flow {
        try {
            val result = userRepository.register(email = email, password = password)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }
}
