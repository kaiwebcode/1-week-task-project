# Project guidance for coding agents

## Bootcamp workflow
- Follow the current day's scope in docs/CURRENT_STATUS.md.
- Read docs/REQUIREMENTS.md, docs/DEVELOPMENT_PLAN.md, docs/ARCHITECTURE.md and docs/DECISIONS.md before working on Task List.
- Day 3 is planning only. Do not implement feature code until trainer approval is recorded in docs/DECISIONS.md and docs/CURRENT_STATUS.md.
- On Day 4, use the approved plan and keep scope to Task List screen.

## Project conventions
- Preserve existing Kotlin Android architecture and UI toolkit unless a change is explicitly approved.
- Keep UI rendering, ViewModel state/event handling and repository data operations separated as documented.
- Do not add backend or durable persistence to the first feature without approval.
- Never claim builds, tests or runtime checks passed unless they were run; record results in docs/CURRENT_STATUS.md.
- Keep credentials and secrets out of prompts, source and Git.
