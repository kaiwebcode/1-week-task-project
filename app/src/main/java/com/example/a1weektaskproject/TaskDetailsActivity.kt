package com.example.a1weektaskproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_task_details)

        val taskId = intent.getStringExtra(EXTRA_TASK_ID) ?: "Unknown"

        findViewById<TextView>(R.id.taskIdValue).text =
            "Task ID: $taskId"

        findViewById<TextView>(R.id.taskDescriptionValue).text =
            "Description: Complete Android Bootcamp Day 2 exercise"

        findViewById<TextView>(R.id.taskStatusValue).text =
            "Status: In Progress"

        // Find the Back to Home button
        val backToHomeButton =
            findViewById<Button>(R.id.backToHomeButton)

        // Handle the button click
        backToHomeButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_TASK_ID =
            "com.example.a1weektaskproject.EXTRA_TASK_ID"
    }
}