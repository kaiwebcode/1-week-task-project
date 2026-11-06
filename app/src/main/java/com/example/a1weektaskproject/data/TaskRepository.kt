package com.example.a1weektaskproject.data

interface TaskRepository {
    fun getTasks(): List<Task>
    fun addTask(title: String, description: String = "", priority: TaskPriority = TaskPriority.MEDIUM): Task
    fun completeTask(id: String): Boolean
    fun toggleComplete(id: String): Boolean
    fun getTaskById(id: String): Task?
}
