package com.example.a1weektaskproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a1weektaskproject.data.InMemoryTaskRepository
import com.example.a1weektaskproject.data.Task
import com.example.a1weektaskproject.data.TaskPriority
import com.example.a1weektaskproject.data.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskListViewModel(
    private val repository: TaskRepository = InMemoryTaskRepository.getInstance()
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaskListUiState())
    val uiState: StateFlow<TaskListUiState> = _uiState.asStateFlow()

    init {
        refreshTasks()
    }

    fun addTask(rawTitle: String, description: String = "", priority: TaskPriority = TaskPriority.MEDIUM) {
        val trimmedTitle = rawTitle.trim()

        if (trimmedTitle.isEmpty()) {
            _uiState.update { currentState ->
                currentState.copy(errorMessage = "Task title cannot be empty")
            }
            return
        }

        repository.addTask(trimmedTitle, description.trim(), priority)
        refreshTasks()
    }

    fun completeTask(id: String) {
        val task = repository.getTaskById(id)
        if (task != null && !task.isCompleted) {
            repository.completeTask(id)
            refreshTasks(newlyCompleted = repository.getTaskById(id))
        }
    }

    fun toggleComplete(id: String) {
        val task = repository.getTaskById(id)
        val wasIncomplete = task != null && !task.isCompleted
        repository.toggleComplete(id)
        val updatedTask = repository.getTaskById(id)
        refreshTasks(newlyCompleted = if (wasIncomplete && updatedTask?.isCompleted == true) updatedTask else null)
    }

    fun clearErrorMessage() {
        if (_uiState.value.errorMessage != null) {
            _uiState.update { currentState ->
                currentState.copy(errorMessage = null)
            }
        }
    }

    fun dismissCompletionDialog() {
        _uiState.update { currentState ->
            currentState.copy(newlyCompletedTask = null)
        }
    }

    fun refreshTasks(newlyCompleted: Task? = null) {
        val currentTasks = repository.getTasks()
        val total = currentTasks.size
        val completed = currentTasks.count { it.isCompleted }
        val pending = total - completed

        _uiState.update { currentState ->
            currentState.copy(
                tasks = currentTasks,
                totalCount = total,
                completedCount = completed,
                pendingCount = pending,
                isEmptyStateVisible = currentTasks.isEmpty(),
                errorMessage = null,
                newlyCompletedTask = newlyCompleted
            )
        }
    }

    class Factory(private val repository: TaskRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TaskListViewModel(repository) as T
        }
    }
}
