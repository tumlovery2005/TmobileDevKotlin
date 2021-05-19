package com.tmobiledev.tmobiledevkotlin.model.user

data class UserStatusModel(
    val data: UserModel,
    val messge: String,
    val status: Boolean
)