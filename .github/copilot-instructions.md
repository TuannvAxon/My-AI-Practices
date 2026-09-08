# this is the file contain the common instruction of os

## 1. General Rules
- use the java 21
- Follow the best structor of java patten
- Each function have to unitest 
- Do not use deprecate lib
- function name have to use camel case
- follow the existing implement 
- do not modifile unrelate files
- Do not make assumptions about business requirements. Ask for clarification when requirements are ambiguous.

## 2. Technology Stack
- Java 21
- JUnit 5
- Mockito
Use Java 21 features only when they improve readability and maintainability.

## 3. Java Coding Standards

### Naming

- Class names must use PascalCase.
- Interface names must use PascalCase.
- Method names must use camelCase.
- Variable names must use camelCase.
- Constant names must use UPPER_SNAKE_CASE.
- Package names must use lowercase.
- Boolean variables should use meaningful names such as `isActive`, `hasPermission`, or `canUpdate`.

Examples:

```java
public class UserService {
}

public interface UserRepository {
}

public void createUser() {
}

private String userName;

private static final int MAX_RETRY_COUNT = 3;
```
## Method
- Methods should have a single responsibility.
- Keep methods small and readable.
- Avoid deeply nested conditions.
- Prefer early returns when they improve readability.
- Do not create methods that contain unrelated responsibilities.
- Use meaningful method names.

## Null Handling
- Avoid unnecessary null checks when the domain model guarantees non-null values.
- Use Optional only when it represents an optional return value.
- Do not use Optional for entity fields or method parameters unless the project already follows this pattern.
- Never silently ignore unexpected null values.

## Collections
- Prefer interfaces such as List, Set, and Map for variable declarations.
- Use ArrayList, HashSet, etc. only when creating the implementation.
- Do not create unnecessary intermediate collections.
- Preserve ordering when business logic requires it.

## Streams
- Use Stream API when it improves readability.
- Do not use streams simply to make code shorter.
- Avoid complex stream chains that are difficult to debug.
- Prefer a normal loop when the logic contains multiple business conditions. 

## Exception Handling
- Do not catch Exception unless there is a specific reason.
- Never swallow exceptions.
- Use meaningful exception types.
- Preserve the original exception as the cause when rethrowing.

## Unit Tests

- Every new business logic change should include or update unit tests.

### Use:

- JUnit 5
- Mockito

 #### Tests should cover:
- Normal case
- Boundary cases
- Invalid input
- Exception cases
- Important business rules

## Test Rules

Before considering a task complete:

- Compile the project.
- Run relevant unit tests.
- Fix compilation errors.
- Fix failing tests caused by the implementation.
- Do not modify tests simply to make them pass unless the test itself is incorrect.
- Do not skip tests.
- Do not remove existing tests without explicit approval.

## Refactoring

 When refactoring:

- Preserve existing behavior.
- Keep the change focused.
- Do not mix unrelated refactoring with feature development.
- Run existing tests after refactoring.
- Explain any behavior changes.
## Security
- Never hard-code passwords, API keys, tokens, or credentials.
- Never commit secrets.
- Validate external input.
- Avoid SQL injection.
- Avoid exposing sensitive information in logs or API responses.
## Dependencies
- Do not add a dependency if the existing JDK or project dependency can solve the problem.
- Before adding a dependency, check whether an equivalent dependency already exists.
- Do not upgrade dependency versions unless explicitly requested or required.
## Git
- Keep commits focused.
- Do not modify unrelated files.
- Do not commit generated files unless the project requires them.
- Do not rewrite Git history unless explicitly requested.
## Definition of Done
 A task is considered complete only when:

- The requested functionality is implemented.
- Existing functionality is preserved.
- Code follows project conventions.
- Unit tests are added or updated.
### Tests pass.
- The project compiles successfully.
- No unnecessary files or dependencies are introduced.
- No unrelated code is modified.
## Copilot Behavior

### When implementing a task:

- Understand the requirement.
- Inspect the existing implementation.
- Identify the affected components.
- Plan the smallest appropriate change.
- Implement the change.
- Add or update tests.
- Review the implementation.
- Run tests.
- Report the result.

- Do not immediately start coding before understanding the existing code.

## Important Constraints

 The following rules are mandatory:

- Do not invent business requirements.
- Do not modify unrelated code.
- Do not remove existing functionality without explicit approval.
- Do not disable tests to make the build pass.
- Do not introduce unnecessary dependencies.
- Do not expose secrets or sensitive information.
- Follow the existing project architecture.
- Prefer simple and maintainable solutions.