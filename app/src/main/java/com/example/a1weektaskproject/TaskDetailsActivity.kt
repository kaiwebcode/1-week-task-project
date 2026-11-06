package com.example.a1weektaskproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a1weektaskproject.data.InMemoryTaskRepository
import com.example.a1weektaskproject.data.Task
import com.example.a1weektaskproject.data.TaskRepository
import com.google.android.material.button.MaterialButton

class TaskDetailsActivity : AppCompatActivity() {

    private val repository: TaskRepository = InMemoryTaskRepository()
    private var currentTask: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val taskId = intent.getStringExtra(EXTRA_TASK_ID) ?: ""
        currentTask = repository.getTaskById(taskId)

        val backButton = findViewById<ImageView>(R.id.backButton)
        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        val detailSubtitle = findViewById<TextView>(R.id.detailSubtitle)
        val detailStatusBadge = findViewById<TextView>(R.id.detailStatusBadge)
        val detailDescriptionValue = findViewById<TextView>(R.id.detailDescriptionValue)
        val detailPriorityValue = findViewById<TextView>(R.id.detailPriorityValue)
        val detailDueDateValue = findViewById<TextView>(R.id.detailDueDateValue)
        val markCompleteButton = findViewById<MaterialButton>(R.id.markCompleteButton)

        backButton.setOnClickListener {
            finish()
        }

        currentTask?.let { task ->
            detailTitle.text = task.title
            detailSubtitle.text = if (task.description.isNotEmpty()) task.description else "Task ID: ${task.id}"
            detailDescriptionValue.text = if (task.description.isNotEmpty()) task.description else "No additional description provided."
            detailPriorityValue.text = "● ${task.priority.name.lowercase().replaceFirstChar { it.uppercase() }}"
            detailDueDateValue.text = task.dueDate

            updateStatusUI(task, detailStatusBadge, markCompleteButton)

            markCompleteButton.setOnClickListener {
                repository.completeTask(task.id)
                val updatedTask = repository.getTaskById(task.id)
                if (updatedTask != null) {
                    updateStatusUI(updatedTask, detailStatusBadge, markCompleteButton)
                }
            }
        }
    }

    private fun updateStatusUI(task: Task, badge: TextView, button: MaterialButton) {
        if (task.isCompleted) {
            badge.text = "Completed"
            badge.setBackgroundResource(R.drawable.bg_status_completed)
            badge.setTextColor(android.graphics.Color.parseColor("#00B894"))
            button.isEnabled = false
            button.text = "Completed"
        } else {
            badge.text = "Pending"
            badge.setBackgroundResource(R.drawable.bg_status_pending)
            badge.setTextColor(android.graphics.Color.parseColor("#FF7675"))
            button.isEnabled = true
            button.text = "✓ Mark as Complete"
        }
    }

    companion object {
        const val EXTRA_TASK_ID = "com.example.a1weektaskproject.EXTRA_TASK_ID"
    }
}
