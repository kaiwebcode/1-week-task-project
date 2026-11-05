# Task List Architecture Diagram

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

This is a planning diagram. Trainer approval is pending and no feature code has been written.
