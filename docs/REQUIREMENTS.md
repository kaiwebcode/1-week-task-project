# Employee Task Manager — Requirements (Day 3)

## Business request
“Employees must view tasks, add tasks, mark complete, and see status.”

## Scope
Plan the first Task List feature for the existing Kotlin Android app. Day 4 implementation is limited to the Task List screen and in-memory task data. Backend integration and durable persistence are out of scope.

## User stories
1. As an employee, I can view available tasks so I know what needs attention.
2. As an employee, I can add a task with a title so new work is captured.
3. As an employee, I can mark a task complete so its status is clear.
4. As an employee, I can see each task's status so I can distinguish open work from completed work.

## Proposed task fields
- Stable in-memory ID.
- Title (required, trimmed).
- Completion status (incomplete or complete).

No due date, priority, assignee, backend, or cross-session persistence is included unless the trainer changes scope.

## Acceptance criteria
- Display tasks and an understandable empty state when there are none.
- Submit a non-empty title and see the new task appear as incomplete.
- Remove surrounding whitespace from submitted titles.
- Reject blank or whitespace-only titles with visible feedback; add no task.
- Each task has a clear action to mark it complete.
- Completing one task updates only that task and visibly changes its status.
- A single submit action does not create duplicates.
- List and status changes appear immediately during the current session.
- ViewModel owns screen state and retains it across supported configuration recreation.
- No survival across process death or app restart is promised.

## Edge cases
- Empty list; blank/whitespace-only title; title with surrounding whitespace.
- Long title remains readable without breaking the row.
- Repeated completion tap leaves the task complete and does not affect others.
- Multiple tasks: completing one leaves the rest unchanged.
- Configuration recreation retains ViewModel state where lifecycle permits.
- Process death/restart resets this initial in-memory list; disclose this limitation.

## Open questions for trainer
- Is completion one-way or toggleable?
- Should completed tasks stay in the list or move to a separate section?
- Is a title-only task acceptable for the first iteration?
- What empty-state and validation wording is expected?
- Confirm in-memory-only state for Day 4.

## Review status
Drafted from the slide request. Trainer approval and answers to open questions are pending.
