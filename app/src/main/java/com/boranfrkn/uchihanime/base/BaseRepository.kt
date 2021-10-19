package com.boranfrkn.uchihanime.base

import com.boranfrkn.uchihanime.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> T): Flow<Result<T>> {
        return flow {
            try {
                this.emit(Result.Loading(true))
                val response = call.invoke()

                //this.emit(Result.Success(response))
                when(response != null){
                    true ->{
                        this.emit(Result.Success(response))
                    }
                }
                this.emit(Result.Loading(false))
            } catch (e: Exception) {
                this.emit(
                    Result.Error(e)
                )
            }
        }
    }
}