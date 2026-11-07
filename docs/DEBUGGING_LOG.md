# Debugging Log — Day 4 Debug and Deliver

## Bug Challenge A: Button Tap Does Nothing
- **Symptom**: Tapping action buttons in the UI produced no reaction or task creation.
- **Workflow**: `Reproduce` → `Breakpoint` → `Root Cause` → `Fix` → `Retest`.
- **Root Cause**: Unwired click listeners or unhandled validation errors in input modals.
- **Fix**: Wired `addTaskButton`, `submitTaskButton`, and `emptyStateAddButton` to dispatch intent to `TaskListViewModel`, and properly displayed error feedback.
- **Retest Result**: Button taps successfully trigger validation or task creation.

## Bug Challenge B: Task List Fails to Display or Update Correctly
- **Symptom**: RecyclerView list and stat counters did not refresh when tasks were added or completed.
- **Workflow**: `Inspect UI/State` → `Root Cause` → `Fix` → `Retest`.
- **Root Cause**: Missing lifecycle-aware coroutine collection of `StateFlow` and lack of efficient `ListAdapter` diffing.
- **Fix**: Implemented `repeatOnLifecycle(Lifecycle.State.STARTED)` collection in `MainActivity` and `ListAdapter` with `TaskDiffCallback` in `TaskAdapter`.
- **Retest Result**: UI updates instantaneously on state change.

## Review Fix — Completion Is One-Way
- **Finding**: The task row called `toggleComplete`, allowing a completed task to return to pending, contrary to the trainer-approved one-way completion decision.
- **Fix**: The row action now calls `TaskListViewModel.completeTask`; repeated taps leave the task completed.
- **Verification**: `:app:testDebugUnitTest` passed (6 passed, 0 skipped, 0 failed); `:app:assembleDebug` completed successfully; `git diff --check` passed.
- **Static analysis**: No errors; existing Android lint/style warnings remain in `MainActivity.kt`.
