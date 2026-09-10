# Copilot Project Instructions

## Purpose
This repository uses a controlled workflow:

Code → Unit Test → Local Review → User Approval → Commit/Push → GitHub Copilot Review → Build

## General Rules
- Inspect the existing project before changing code.
- Follow existing Java/package/test conventions.
- Prefer Java 21 where the project uses Java 21.
- Change only files required for the task.
- Never commit secrets, credentials, tokens, local environment files, or generated IDE files unless already intended by the project.
- New business logic must have unit tests.
- Do not weaken or delete existing tests just to make a build pass.
- Do not push without explicit user approval.

## Completion Gates
A task is locally complete only when:
1. Code compiles.
2. Relevant unit tests pass.
3. Local code review passes.
4. Git diff has been inspected.
5. User explicitly approves the push.

After push, GitHub is responsible for the remote Copilot review gate. Build must depend on that review gate.

## Git Safety
Never use force push unless the user explicitly requests it.
Never silently amend/rebase/reset user work.
Never push secrets.
