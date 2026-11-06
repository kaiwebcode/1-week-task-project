package com.example.a1weektaskproject.data

import java.util.Locale
import java.util.concurrent.atomic.AtomicInteger

class InMemoryTaskRepository : TaskRepository {

    private val tasksList = mutableListOf<Task>()
    private val idCounter = AtomicInteger(1)

    init {
        // Pre-populate initial sample tasks matching the UI design specs
        addTask("Prepare weekly report", "Review employee performance", TaskPriority.MEDIUM)
        addTask("Update project documentation", "Check latest changes", TaskPriority.LOW)
        val teamMeeting = addTask("Team meeting notes", "Share summary with team", TaskPriority.MEDIUM)
        completeTask(teamMeeting.id)
        addTask("Fix login issue", "Resolve authentication bug", TaskPriority.HIGH)
    }

    override fun getTasks(): List<Task> {
        return tasksList.toList()
    }

    override fun addTask(title: String, description: String, priority: TaskPriority): Task {
        val nextId = String.format(Locale.US, "TASK-%03d", idCounter.getAndIncrement())
        val newTask = Task(
            id = nextId,
            title = title,
            description = description,
            isCompleted = false,
            priority = priority
        )
        tasksList.add(newTask)
        return newTask
    }

    override fun completeTask(id: String): Boolean {
        val index = tasksList.indexOfFirst { it.id == id }
        if (index != -1) {
            val existing = tasksList[index]
            if (!existing.isCompleted) {
                tasksList[index] = existing.copy(isCompleted = true)
                return true
            }
        }
        return false
    }

    override fun toggleComplete(id: String): Boolean {
        val index = tasksList.indexOfFirst { it.id == id }
        if (index != -1) {
            val existing = tasksList[index]
            tasksList[index] = existing.copy(isCompleted = !existing.isCompleted)
            return true
        }
        return false
    }

    override fun getTaskById(id: String): Task? {
        return tasksList.find { it.id == id }
    }
}
