package com.example.a1weektaskproject.data

enum class TaskPriority {
    LOW,
    MEDIUM,
    HIGH
}

/**
 * Data model for tasks in Employee Task Manager.
 */
data class Task(
    val id: String,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: TaskPriority = TaskPriority.MEDIUM,
    val dueDate: String = "Nov 8, 2025"
)
