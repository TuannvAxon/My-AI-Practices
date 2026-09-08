# Git Instructions

## Principle

Git release is a human-controlled operation.

Copilot may prepare code for release, but must not release it without explicit approval.

---

# Before Approval

Allowed:

```bash
git status
git diff
git diff --check
git branch --show-current
```

Not allowed:

```bash
git commit
git push
git merge
git rebase
```

---

# Approval

Valid explicit approval:

```text
APPROVE
```

```text
APPROVE AND PUSH
```

```text
RELEASE
```

---

# Before Commit

After approval:

```bash
git status
git diff
git diff --check
git branch --show-current
```

Run relevant tests again.

Verify no secrets.

Verify no unrelated files.

---

# Staging

Prefer:

```bash
git add <specific-file>
```

Do not blindly use:

```bash
git add .
```

unless all working-tree changes are known to be intentional.

---

# Commit Message

Use Conventional Commits.

Format:

```text
<type>(<scope>): <description>
```

Examples:

```text
feat(user): add user creation
fix(waste): fix attachment usage detection
refactor(waste): simplify disposal route traversal
test(waste): add attachment usage tests
```

---

# Branch

Feature work should use:

```text
feature/<ticket>
```

Bug fixes:

```text
bugfix/<ticket>
```

Refactoring:

```text
refactor/<ticket>
```

---

# Push

Push only the current feature branch.

```bash
git push origin <branch>
```

Never force push unless explicitly requested.

Never push directly to main/master by default.

---

# Post Push

Report:

```text
Branch:
Commit:
Commit message:
Tests:
Push:
```

If a PR is created, report its status.

