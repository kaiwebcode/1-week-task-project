package com.example.a1weektaskproject.ui

import com.example.a1weektaskproject.data.Task

data class TaskListUiState(
    val tasks: List<Task> = emptyList(),
    val totalCount: Int = 0,
    val completedCount: Int = 0,
    val pendingCount: Int = 0,
    val isEmptyStateVisible: Boolean = false,
    val errorMessage: String? = null,
    val newlyCompletedTask: Task? = null
)
