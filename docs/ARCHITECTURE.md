# Task List Architecture

## Proposed flow
~~~mermaid
flowchart LR
    U[Employee] -->|tap / enter title| S[TaskListScreen]
    S -->|Add task or complete task| V[TaskListViewModel]
    V -->|validate + update screen state| V
    V -->|read / add / complete| R[TaskRepository]
    R -->|task data| M[InMemoryTaskRepository]
    M -->|session-only list| R
    R -->|updated tasks| V
    V -->|immutable TaskListUiState| S
    M -. future implementation .-> P[(Persistent storage)]
~~~

## Components and responsibilities
- TaskListScreen displays list, empty state, add controls and completion status. It renders state and emits intent; it does not own business data.
- TaskListViewModel owns screen state, validates titles, translates user events into repository calls, and publishes updated state.
- TaskRepository abstracts task reads and writes so screen logic does not depend on storage details.
- InMemoryTaskRepository stores tasks only for the current app session. It is not durable storage.
- Task represents identity, title and completion status.
- Persistent storage is a future replacement behind the repository boundary; it is out of scope for Day 4's first feature.

## Connection explanation
1. Employee interacts with TaskListScreen.
2. Screen forwards add or complete intent to TaskListViewModel.
3. ViewModel validates input and asks TaskRepository to perform the operation.
4. Repository delegates to the in-memory implementation.
5. Updated task data returns through the repository to the ViewModel.
6. ViewModel publishes new immutable screen state; the screen renders it.
7. Future storage can replace the in-memory repository without making the screen depend directly on a database.

## State and lifecycle
The ViewModel is the source of truth for screen state. The first version is in-memory only and does not promise survival after process death or app restart. Keep the repository API simple until durable storage is approved.

## Status
Trainer approved this architecture for the Day 4 Task List implementation. The app uses Kotlin, AppCompat Activity, XML layouts, RecyclerView, ViewModel, and an in-memory repository. See `docs/DECISIONS.md` and `docs/CURRENT_STATUS.md` for approval and implementation status.
