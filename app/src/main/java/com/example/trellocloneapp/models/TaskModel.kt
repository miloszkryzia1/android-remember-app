package com.example.trellocloneapp.models

import com.example.trellocloneapp.models.LabelModel

data class TaskModel(
    var name: String,
    var description: String,
    var label: LabelModel
)
