package com.example.trellocloneapp

data class BoardModel(
    var name: String,
    var color: Int,
    var tasks: List<TaskModel>
)