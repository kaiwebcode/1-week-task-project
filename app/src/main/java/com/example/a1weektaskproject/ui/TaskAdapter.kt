package com.example.a1weektaskproject.ui

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a1weektaskproject.R
import com.example.a1weektaskproject.data.Task

/**
 * Adapter for rendering Task items matching the UI design specifications.
 */
class TaskAdapter(
    private val onToggleComplete: (Task) -> Unit,
    private val onItemClick: (Task) -> Unit
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view, onToggleComplete, onItemClick)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TaskViewHolder(
        itemView: View,
        private val onToggleComplete: (Task) -> Unit,
        private val onItemClick: (Task) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val checkCircleImageView: ImageView = itemView.findViewById(R.id.checkCircleImageView)
        private val taskTitleTextView: TextView = itemView.findViewById(R.id.taskTitleTextView)
        private val taskDescriptionTextView: TextView = itemView.findViewById(R.id.taskDescriptionTextView)
        private val taskStatusBadge: TextView = itemView.findViewById(R.id.taskStatusBadge)

        fun bind(task: Task) {
            taskTitleTextView.text = task.title

            if (task.description.isNotEmpty()) {
                taskDescriptionTextView.text = task.description
                taskDescriptionTextView.visibility = View.VISIBLE
            } else {
                taskDescriptionTextView.visibility = View.GONE
            }

            if (task.isCompleted) {
                checkCircleImageView.setImageResource(R.drawable.ic_check_circle)
                taskTitleTextView.paintFlags = taskTitleTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                taskTitleTextView.setTextColor(Color.parseColor("#B2BEC3"))
                taskStatusBadge.text = "Completed"
                taskStatusBadge.setBackgroundResource(R.drawable.bg_status_completed)
                taskStatusBadge.setTextColor(Color.parseColor("#00B894"))
            } else {
                checkCircleImageView.setImageResource(R.drawable.ic_circle_outline)
                taskTitleTextView.paintFlags = taskTitleTextView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                taskTitleTextView.setTextColor(Color.parseColor("#2D3436"))
                taskStatusBadge.text = "Pending"
                taskStatusBadge.setBackgroundResource(R.drawable.bg_status_pending)
                taskStatusBadge.setTextColor(Color.parseColor("#FF7675"))
            }

            checkCircleImageView.setOnClickListener {
                onToggleComplete(task)
            }

            itemView.setOnClickListener {
                onItemClick(task)
            }
        }
    }

    private class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
}
