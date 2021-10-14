package com.boranfrkn.uchihanime.base

import com.boranfrkn.uchihanime.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> T): Flow<Result<T>> {
        return flow {
            try {
                val response = call.invoke()

                this.emit(Result.Success(response))


            } catch (e: Exception) {
                this.emit(
                    Result.Error(e)
                )
            }
        }
    }
}