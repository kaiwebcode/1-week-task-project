package com.example.a1weektaskproject.ui

import com.example.a1weektaskproject.data.InMemoryTaskRepository
import com.example.a1weektaskproject.data.TaskPriority
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class TaskListViewModelTest {

    private lateinit var repository: InMemoryTaskRepository
    private lateinit var viewModel: TaskListViewModel

    @Before
    fun setUp() {
        repository = InMemoryTaskRepository()
        viewModel = TaskListViewModel(repository)
    }

    @Test
    fun initialState_showsInitialTasksAndCounts() {
        val state = viewModel.uiState.value
        assertEquals(4, state.tasks.size)
        assertEquals(4, state.totalCount)
        assertEquals(1, state.completedCount)
        assertEquals(3, state.pendingCount)
        assertFalse(state.isEmptyStateVisible)
        assertNull(state.errorMessage)
    }

    @Test
    fun addValidTask_updatesListAndCounts() {
        val initialSize = viewModel.uiState.value.tasks.size
        viewModel.addTask("New Feature Task", "Detailed description", TaskPriority.HIGH)

        val state = viewModel.uiState.value
        assertEquals(initialSize + 1, state.tasks.size)
        val addedTask = state.tasks.last()
        assertEquals("New Feature Task", addedTask.title)
        assertEquals("Detailed description", addedTask.description)
        assertEquals(TaskPriority.HIGH, addedTask.priority)
        assertFalse(addedTask.isCompleted)
        assertNull(state.errorMessage)
    }

    @Test
    fun addBlankTask_showsValidationErrorAndDoesNotAddTask() {
        val initialSize = viewModel.uiState.value.tasks.size
        viewModel.addTask("   ")

        val state = viewModel.uiState.value
        assertEquals(initialSize, state.tasks.size)
        assertEquals("Task title cannot be empty", state.errorMessage)
    }

    @Test
    fun addWhitespaceTask_trimsTitleAndAddsTask() {
        val initialSize = viewModel.uiState.value.tasks.size
        viewModel.addTask("   Cleaned Title   ")

        val state = viewModel.uiState.value
        assertEquals(initialSize + 1, state.tasks.size)
        assertEquals("Cleaned Title", state.tasks.last().title)
        assertNull(state.errorMessage)
    }

    @Test
    fun toggleComplete_updatesTaskCompletionStatusAndTriggersDialog() {
        val pendingTask = viewModel.uiState.value.tasks.first { !it.isCompleted }

        viewModel.toggleComplete(pendingTask.id)

        val state = viewModel.uiState.value
        val updatedTask = state.tasks.first { it.id == pendingTask.id }
        assertTrue(updatedTask.isCompleted)
        assertNotNull(state.newlyCompletedTask)
        assertEquals(pendingTask.id, state.newlyCompletedTask?.id)
    }

    @Test
    fun getTaskById_returnsNewlyCreatedTaskDetails() {
        viewModel.addTask("Custom Task", "Custom description", TaskPriority.HIGH)
        val state = viewModel.uiState.value
        val createdTask = state.tasks.last()

        val foundTask = repository.getTaskById(createdTask.id)
        assertNotNull(foundTask)
        assertEquals("Custom Task", foundTask?.title)
        assertEquals("Custom description", foundTask?.description)
        assertEquals(TaskPriority.HIGH, foundTask?.priority)
    }
}
