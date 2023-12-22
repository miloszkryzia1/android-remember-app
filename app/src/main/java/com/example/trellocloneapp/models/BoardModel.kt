package com.example.trellocloneapp.models

data class BoardModel(
    var name: String,
    var color: Int,
    var tasks: List<TaskModel>
)