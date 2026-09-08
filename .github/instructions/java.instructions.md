# Java 21 Instructions

## Java Version

Use Java 21.

Follow the project's configured compiler and build configuration.

---

# General Rules

Write code that is:

- readable
- predictable
- testable
- maintainable
- consistent with existing code

Prefer explicit and understandable code over clever code.

---

# Methods

A method should have one clear responsibility.

Avoid methods that:

- perform unrelated operations
- mix persistence and presentation concerns
- contain deeply nested conditional logic

Use early returns where appropriate.

---

# Boolean Methods

For methods returning boolean:

Prefer:

```java
if (condition) {
    return true;
}

return false;
```

over:

```java
boolean result = false;

if (condition) {
    result = true;
}

return result;
```

For collection searches, consider:

```java
return collection.stream()
        .anyMatch(...);
```

only if the stream remains readable.

---

# Null Safety

Guard invalid input early:

```java
if (object == null) {
    return false;
}
```

Avoid unnecessary nested blocks:

```java
if (object != null) {
    if (object.getSomething() != null) {
        ...
    }
}
```

Prefer:

```java
if (object == null || object.getSomething() == null) {
    return false;
}
```

when appropriate.

---

# Collections

Before iterating nested collections, determine whether the project guarantees non-null collections.

If null is possible:

```java
if (items == null) {
    return;
}
```

or use an appropriate repository utility.

Do not introduce defensive code that contradicts established project contracts.

---

# Streams

Use Stream API when:

- the operation is naturally a map/filter/anyMatch operation
- the result remains readable
- it reduces accidental mutable state

Do not use Stream API when nested lambdas make debugging or understanding harder.

Bad:

```java
return routes.stream()
    .flatMap(...)
    .filter(...)
    .map(...)
    .filter(...)
    .flatMap(...)
    .filter(...)
    .anyMatch(...);
```

if the equivalent loop is significantly clearer.

---

# Naming

Use descriptive names.

Prefer:

```java
wmfDisposalRoute
attachmentLink
feasibleModeOfTransport
```

when domain terminology requires them.

Do not rename domain objects merely for style.

---

# Refactoring

Before refactoring:

1. Understand current behavior.
2. Identify callers.
3. Identify tests.
4. Preserve behavior.
5. Make one logical refactoring at a time.
6. Run tests.

Do not mix:

```text
business change
+
large refactoring
+
formatting
+
unrelated cleanup
```

in one change.

---

# Performance

For nested collection traversal:

- stop as soon as the result is known
- avoid unnecessary traversal
- avoid repeated database access
- avoid loading large lazy collections unnecessarily

For boolean searches, prefer short-circuit behavior.

Example:

```java
return items.stream()
        .anyMatch(item -> item.equals(target));
```

or:

```java
for (Item item : items) {
    if (item.equals(target)) {
        return true;
    }
}

return false;
```

---

# JPA / Hibernate

Do not use entity fields casually.

Consider:

```text
equals()
hashCode()
lazy loading
proxy objects
transaction boundaries
```

When comparing entities, preserve the project's established equality strategy.

Do not introduce `==` for entity comparison unless identity semantics are explicitly intended.

---

# Code Quality Gate

Before declaring implementation complete:

- no compiler errors
- no obvious null problems
- no dead code
- no unnecessary mutable state
- no unrelated changes
- tests added/updated
- tests pass

