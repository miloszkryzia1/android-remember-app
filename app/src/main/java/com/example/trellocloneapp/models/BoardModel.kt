package com.example.trellocloneapp.models

data class BoardModel(
    var name: String,
    var color: Int,
    var tasks: MutableList<TaskModel>,
    var id: Int,
    var labels: MutableList<LabelModel>
)