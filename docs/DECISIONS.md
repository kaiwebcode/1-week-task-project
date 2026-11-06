# Decisions and Assumptions

## Approved decisions (Trainer approved for Day 4)

| Topic | Decision | Status | Rationale / Date |
|---|---|---|---|
| First feature scope | Task List screen only | Approved | Focus scope on single screen per Day 4 plan (Nov 2026) |
| Task fields | In-memory ID (String), required title (String), completion status (Boolean) | Approved | Simple data model matching requirements |
| Title validation | Trim title; reject blank or whitespace-only input with visible error message | Approved | Prevents invalid task creation with clear UI feedback |
| Completion | One-way completion (incomplete -> complete) | Approved | Simple completion lifecycle for first iteration |
| Storage | In-memory repository; no persistence/backend | Approved | Keep storage in-memory for Day 4 scope |
| State ownership | ViewModel owns UI state (`TaskListUiState`) and handles UI events | Approved | Follows MVVM architecture with unidirectional data flow |
| UI toolkit | XML Views + RecyclerView + ViewModel (Native AppCompat baseline) | Approved | Preserves existing app architecture without unapproved UI framework migration |
| Completed tasks | Keep visible in main list with completed badge/strikethrough | Approved | Simple unified list UI showing full context |

## Session notes
- Day 1, 2, and 3 work complete and verified.
- Trainer approval received for Day 4 implementation plan.
- Architecture baseline: Kotlin, AppCompat Activity, XML layouts, RecyclerView, ViewModel, and InMemoryTaskRepository.

