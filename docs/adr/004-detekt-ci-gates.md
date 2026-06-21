# ADR 004: Detekt static analysis in CI

**Status:** Accepted  
**Date:** 2026-06-21

## Context

Code review alone cannot enforce naming, complexity, or style consistency across squads. Platform teams need automated gates that fail PRs before merge.

## Decision

Integrate **Detekt** with:

- Project-wide `detekt.yml` configuration
- `./gradlew detekt` in GitHub Actions on every push/PR
- CI fails on Detekt issues (no `continue-on-error`)

Detekt runs on Kotlin sources across all modules except generated code.

## Consequences

**Positive**
- Consistent style without bike-shedding in review
- Catches complexity smells early
- Cheap to run on every PR

**Negative**
- Initial noise when adopting on brownfield codebases
- Does not replace architectural tests or lint for Android resources

## Alternatives considered

| Alternative | Why rejected |
|-------------|--------------|
| ktlint only | Formatting-only; misses complexity rules |
| Android Lint only | JVM/domain modules need Kotlin-specific rules |
| No static analysis | Inconsistent with Principal platform standards |
