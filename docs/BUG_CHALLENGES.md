# Day 4 — Debug and Deliver (Bug Challenges A & B)

## Overview
As specified in the Day 4 Bootcamp brief ("Fix two controlled bugs and prove each fix"), two key debugging challenges were analyzed, debugged, fixed, and verified.

---

## Bug Challenge A: Button Tap Does Nothing

### 1. Symptom / Observation
- Tapping the "+ Add Task" or "+ Add New Task" button resulted in no visual feedback, no task creation, and no error message.

### 2. Debugging Workflow (`Reproduce → breakpoint → root cause → fix → retest`)
- **Reproduce**: Tapped the Add button in the bottom sheet without entering text or with a valid title; the UI remained static.
- **Breakpoint**: Placed a breakpoint inside `addTaskButton.setOnClickListener` in `MainActivity.kt` and `BottomSheetDialog` submit listener.
- **Root Cause**: 
  1. The click listener was either missing click dispatch logic or validation errors were silently dropped without updating the error banner (`errorTextView`).
  2. In the bottom sheet implementation, tapping submit when title was empty didn't communicate the error clearly back to the user.
- **Fix**: 
  - Explicitly wired `addTaskButton` and `submitTaskButton` click listeners to invoke `viewModel.addTask(...)`.
  - Added proper handling to show validation errors or dismiss the bottom sheet only when input is valid.
- **Retest**: Tapping submit with valid input successfully adds the task and closes the bottom sheet; tapping with empty input shows the validation error.

---

## Bug Challenge B: Task List Fails to Display or Update Correctly

### 1. Symptom / Observation
- After adding a new task or toggling task completion, the RecyclerView task list or header summary counters (Total, Completed, Pending) failed to refresh or update immediately on screen.

### 2. Debugging Workflow (`Inspect UI/state → root cause → fix → retest`)
- **Inspect UI/State**: Inspected `TaskListViewModel` StateFlow emission and `MainActivity` observer lifecycle.
- **Root Cause**: 
  1. State updates in the ViewModel were not being collected within a lifecycle-aware coroutine scope (`repeatOnLifecycle(Lifecycle.State.STARTED)`), causing lifecycle detachment or missing UI re-renders.
  2. `TaskAdapter` was not using `ListAdapter` with a proper `DiffUtil.ItemCallback`, so RecyclerView item updates were not triggered when list items mutated.
- **Fix**: 
  - Configured `lifecycleScope.launch { repeatOnLifecycle(Lifecycle.State.STARTED) { viewModel.uiState.collect { state -> ... } } }` in `MainActivity.kt`.
  - Implemented `ListAdapter` with `TaskDiffCallback` in `TaskAdapter.kt`.
- **Retest**: Adding, completing, or toggling tasks updates the RecyclerView list and summary stat counters instantly.

---

## Submission Checklist
- [x] APK built: `app/build/outputs/apk/debug/app-debug.apk`
- [x] Feature branch: `feature/task-list`
- [x] PR description: `docs/PULL_REQUEST.md`
- [x] Codex review: `docs/CODEX_REVIEW.md`
- [x] Debugging log: `docs/DEBUGGING_LOG.md`
- [x] Current status: `docs/CURRENT_STATUS.md`
