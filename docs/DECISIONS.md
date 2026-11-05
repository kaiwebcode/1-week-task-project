# Decisions and Assumptions

## Proposed decisions (awaiting trainer approval)

| Topic | Proposal | Status |
|---|---|---|
| First feature scope | Task List screen only | Pending |
| Task fields | In-memory ID, required title, completion status | Pending |
| Title validation | Trim title; reject blank input visibly | Pending |
| Completion | Mark complete; toggle behavior needs trainer decision | Open |
| Storage | In-memory repository; no persistence/backend | Pending |
| State ownership | ViewModel owns UI state and handles events | Pending |
| UI toolkit | Follow existing conventions; no migration without approval | Pending |
| Completed tasks | Keep visible with completed status unless trainer directs otherwise | Pending |

## Session notes
- Day 1 and Day 2 work is complete per user.
- Existing app uses Kotlin, AppCompat Activity and XML layout. Proposed architecture must fit this baseline unless an approved change is made.
- Day 3 is planning only. Do not add feature source code before trainer approval.
- Update this file when trainer makes a decision; record rationale and date.
