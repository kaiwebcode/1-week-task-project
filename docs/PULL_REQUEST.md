# Pull Request: Day 4 Task List Feature & UI Redesign

## Branch
`feature/task-list` -> `main`

## Description
This pull request implements the Day 4 **Task List Feature** and pixel-perfect UI redesign for the **Employee Task Manager** app, fully aligned with the Android Developer Bootcamp specifications, requirements, and reference design.

## Key Changes
1. **Domain & Data Layer**:
   - Created `Task` data class with `id`, `title`, `description`, `isCompleted`, `priority` (`LOW`, `MEDIUM`, `HIGH`), and `dueDate`.
   - Implemented `TaskRepository` contract and sample-populated `InMemoryTaskRepository`.
2. **Presentation Layer (MVVM)**:
   - Implemented `TaskListUiState` and `TaskListViewModel` with `StateFlow`.
   - Added robust input validation (whitespace trimming, blank title rejection).
3. **UI & Layouts**:
   - Redesigned `activity_main.xml` with a dark purple gradient header, greeting `"Hello, Kaif! 👋"`, notification bell with red badge `2`, and responsive summary stat cards (Total, Completed, Pending).
   - Created `BottomSheetDialog` for adding new tasks with live character counters (`0/100`, `0/250`) and priority selector pills.
   - Created Task Completed celebration dialog popup.
   - Redesigned `TaskDetailsActivity` and `item_task.xml` cards with status pill badges (`Pending` / `Completed`).
4. **Testing**:
   - Added unit test suite `TaskListViewModelTest.kt` verifying all validation, task addition, and completion rules.

## Test Results
- **Unit Tests**: `:app:testDebugUnitTest` $\rightarrow$ **6 passed, 0 failed**.
- **Build**: `:app:assembleDebug` $\rightarrow$ **BUILD SUCCESSFUL**.
- **APK Output**: `app/build/outputs/apk/debug/app-debug.apk`
