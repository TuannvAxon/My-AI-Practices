# Copilot Java Development Workflow

This template implements:

```text
Code
  ↓
Unit Test
  ↓
Local Review
  ↓
Ask User
  ↓
Commit / Push
  ↓
GitHub Copilot Review
  ↓
PASS → Build
FAIL → Stop
```

## Important GitHub configuration

The `.md` files are instructions for Copilot/agents. They do not execute by themselves.

The remote gate must be backed by an actual GitHub Copilot review/check. Configure GitHub Copilot code review for pull requests in the repository, then configure the resulting check as a required status check in branch protection/rulesets.

The included `copilot-review.yml` intentionally does not pretend that a generic `copilot review` CLI command exists.

## Local example

```bash
./mvnw -B test
```

Then perform local review and ask the user before:

```bash
git push
```

## Build gate

`build.yml` runs only after the `Copilot Review Gate` workflow reports success.

For a real repository, the recommended production setup is:

1. Create a feature branch.
2. Push the branch after user approval.
3. Open/update a pull request.
4. Let GitHub Copilot review the PR.
5. Require the real Copilot review check in branch protection.
6. Run build/merge only after the required review check passes.

## Adaptation for an existing project

Copy `.github/` into the existing repository and merge its rules with existing project instructions.

Adjust:
- Java version
- Maven/Gradle command
- package names
- test framework
- actual Copilot review check name
- branch protection/ruleset
