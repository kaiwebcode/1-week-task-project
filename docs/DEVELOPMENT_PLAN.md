# Development Plan (Day 3 — No Code)

## Goal
Implement the approved first Task List feature in the existing Kotlin Android project. Follow this plan only after trainer approval.

## Proposed architecture
- TaskListScreen renders immutable task-list state and forwards user actions.
- TaskListViewModel owns screen state, validates submitted titles, and handles add/complete events.
- TaskRepository provides task read/write operations and is the boundary for future persistence.
- InMemoryTaskRepository supplies session-only storage for the first iteration.
- Task is a small model: ID, title, completion status.

Use the project's existing UI toolkit and conventions. Inspect current XML/AppCompat implementation before deciding whether to evolve it in place or introduce Compose. Any meaningful stack change needs trainer approval.

## Proposed file map
Exact names/locations are provisional until project structure and trainer preference are confirmed.
- Existing launcher Activity and layout: connect to or host Task List screen.
- Task model.
- TaskRepository contract and InMemoryTaskRepository implementation.
- TaskListViewModel for state and events, including title validation.
- Task list UI with list, empty state, add input/action, completion affordance.
- UI resources for strings and styles/layout as needed.
- Unit tests for ViewModel validation and event behavior.
- UI test/manual verification for list, add, complete, empty and invalid input.

Do not create or edit these source files as part of Day 3 planning.

## Implementation sequence (Day 4, after approval)
1. Confirm clean working tree and create/use feature/task-list.
2. Recheck approved requirements, architecture and unresolved trainer decisions.
3. Inspect existing Activity/layout and choose the smallest consistent UI change.
4. Add task model and repository boundary with in-memory implementation.
5. Add ViewModel state, add-task validation, and completion handling.
6. Build Task List UI and connect events/state.
7. Verify empty state, valid add, invalid add, one-of-many completion, and repeated actions.
8. Capture build/runtime evidence, review diff, update DEBUGGING_LOG.md and CURRENT_STATUS.md.
9. Keep scope to Task List screen; do not add durable persistence or backend integration.

## Verification plan
- Build using the project's configured Gradle task.
- Run on emulator/device and inspect rendered state.
- Exercise each acceptance criterion in REQUIREMENTS.md.
- Add focused ViewModel tests if existing test setup supports them; decide dependencies only after inspecting setup.
- Record actual results/environment; never claim a check passed unless run.

## Risks and mitigations
- Existing project is XML/AppCompat-based: inspect before choosing a UI migration.
- In-memory state is temporary: state session-only behavior; do not imply persistence.
- Completion semantics are ambiguous: get trainer decision before implementation.
- Defer due dates, priority, assignment, sorting/filtering, persistence and backend.
- Trainer approval is required before Day 4 feature code.

## Approval and outcome
Trainer approval for the Day 4 plan is recorded in `docs/DECISIONS.md`. The Task List feature has been implemented. Current implementation and verification status are tracked in `docs/CURRENT_STATUS.md`.
