package com.tmobiledev.tmobiledevkotlin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmobiledev.tmobiledevkotlin.model.user.UserModel
import com.tmobiledev.tmobiledevkotlin.repository.UserMeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class FirstViewModel(private val userMeRepository: UserMeRepository) : ViewModel() {
    val userModel = MutableLiveData<UserModel>()
    val errorMessage = MutableLiveData<String>()

    fun getUserMe(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    var userStatus = userMeRepository.repoGetUserMe()
                    userModel.postValue(userStatus.data)
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            errorMessage.postValue("Network Error")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }
    }
}