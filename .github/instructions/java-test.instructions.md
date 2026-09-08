# Java 21 Unit Test Instructions

## Objective

Create reliable, maintainable unit tests for Java 21 code.

Tests must validate behavior rather than implementation details.

---

# Testing Framework

Use the testing framework already established by the repository.

If the project uses JUnit 5, prefer:

```java
import org.junit.jupiter.api.Test;
```

Use existing Mockito conventions if Mockito is already present.

Do not introduce a new testing framework without explicit approval.

---

# Test Naming

Test names must describe behavior.

Prefer:

```java
shouldReturnTrueWhenAttachmentIsUsedInModeOfTransport()
```

```java
shouldReturnFalseWhenAttachmentIsNotUsed()
```

```java
shouldReturnFalseWhenWasteManagementFolderIsNull()
```

Avoid:

```java
test1()
testMethod()
checkSomething()
```

---

# Given When Then

Structure tests as:

```java
@Test
void shouldReturnTrueWhenAttachmentIsUsed() {
    // Given

    // When

    // Then
}
```

Keep each section clear.

---

# Required Test Categories

For a changed method, consider:

## Happy path

The expected successful behavior.

## Negative path

The expected false/failure behavior.

## Null input

Test null inputs when the production method accepts nullable values.

## Empty collection

Test empty lists when relevant.

## Nested null

Test null nested objects when the production code is expected to handle them.

## Boundary cases

Test relevant limits and edge conditions.

---

# Example: Boolean Search Method

For:

```java
boolean isAttachmentUsedInModeOfTransports(
        WasteManagementFolder wmf,
        WMFAttachment attachment)
```

Tests should consider:

```text
1. wmf == null
2. wmf.getWmfWasteDisposal() == null
3. disposalRoutes == null
4. disposalRoutes is empty
5. feasible mode list is empty
6. attachment links are empty
7. attachment is not found
8. attachment is found
9. attachment == null
10. nested collection is null if allowed by the domain model
```

---

# Test Independence

Each test must be independent.

Do not depend on test execution order.

Avoid shared mutable state.

Reset mocks between tests when required by the framework.

---

# Mockito

Mock only external collaborators.

Do not mock simple domain objects unnecessarily.

Prefer real value/domain objects when they are simple and safe to construct.

Bad:

```java
@Mock
private WMFAttachment attachment;
```

if `WMFAttachment` is a simple domain object and can be instantiated normally.

---

# Assertions

Assertions should clearly express expected behavior.

Prefer:

```java
assertTrue(result);
```

or:

```java
assertFalse(result);
```

For richer assertions, use the project's existing assertion library.

---

# Test Quality

A test should fail if the intended behavior is broken.

Avoid tests that merely verify:

```text
method was called
```

when the actual requirement is a business outcome.

---

# Regression Tests

Every bug fix should have a regression test when practical.

The test should reproduce the original problem and prove that it remains fixed.

---

# Test Execution

Before declaring the task complete:

1. Compile.
2. Run targeted tests.
3. Run relevant module tests.
4. Run the broader test suite when practical.

Report exact commands and results.

---

# Failure Policy

Never hide test failures.

If tests fail:

1. identify the failure
2. determine whether it is caused by the change
3. fix the implementation or test
4. rerun

Do not report PASS when tests did not actually pass.

