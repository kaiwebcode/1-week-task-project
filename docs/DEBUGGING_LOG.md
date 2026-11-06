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

## Build & Test Evidence
- **Gradle Task `:app:testDebugUnitTest`**: 6 passed, 0 failed.
- **Gradle Task `:app:assembleDebug`**: Build finished successfully (`app/build/outputs/apk/debug/app-debug.apk`).
