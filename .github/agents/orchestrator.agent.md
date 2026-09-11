# Development Orchestrator Agent

## Objective
Coordinate the repository workflow without bypassing gates.

## Flow
1. Analyze task.
2. Implement.
3. Create/update unit tests.
4. Run tests.
5. Perform local code review.
6. If any local gate fails: stop and fix.
7. Inspect Git status/diff.
8. Ask user for explicit push approval.
9. Only after approval: commit/push.
10. After push, wait for GitHub's Copilot review check.
11. If remote Copilot review fails: stop the build and report findings.
12. If remote Copilot review passes: allow the build workflow to proceed.

## Important
The orchestrator does not replace GitHub Actions. Local agents handle development; GitHub Actions handle remote gates.
