package com.example.a1weektaskproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Home screen for the Day 2 button-click tracing exercise.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Find the button from the XML layout
        val viewTaskDetailsButton =
            findViewById<Button>(R.id.viewTaskDetailsButton)

        // Handle the button click
        viewTaskDetailsButton.setOnClickListener {
            openTaskDetails("TASK-001")
        }
    }

    // Navigate to the Task Details screen
    private fun openTaskDetails(taskId: String) {
        val intent = Intent(this, TaskDetailsActivity::class.java)

        intent.putExtra(TaskDetailsActivity.EXTRA_TASK_ID, taskId)

        startActivity(intent)
    }
}