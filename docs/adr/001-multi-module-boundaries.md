# ADR 001: Multi-module Gradle boundaries

**Status:** Accepted  
**Date:** 2026-06-21

## Context

Greenfield Android apps often start as a single `:app` module. Within months, feature code, networking, and UI primitives interleave. Build times grow, circular dependencies appear, and teams cannot enforce layer rules.

## Decision

Structure the project as:

```text
app → feature:* → core:domain
                 → core:designsystem
core:data → core:domain → core:common
```

- **`app`**: Application shell, navigation wiring, Hilt `@HiltAndroidApp`
- **`feature:*`**: Screen-level UI + ViewModels; depends on domain and designsystem only
- **`core:domain`**: Models, repository interfaces, use cases (pure Kotlin/JVM)
- **`core:data`**: Repository implementations; depends on domain
- **`core:designsystem`**: Theme and reusable Compose components
- **`core:common`**: Shared primitives (`Result`, extensions)

Features must not depend on `core:data` directly — they receive repositories via Hilt bindings in `app`.

## Consequences

**Positive**
- Clear compile-time boundaries; domain logic testable without Android
- Parallel team ownership per feature module
- Faster incremental builds as modules grow

**Negative**
- More Gradle boilerplate upfront
- Requires discipline when adding cross-feature navigation

## Alternatives considered

| Alternative | Why rejected |
|-------------|--------------|
| Single module | Does not scale past ~20 screens |
| Package-by-layer in one module | Boundaries are conventional, not enforced |
| Dynamic feature modules | Overkill for starter; add when Play Feature Delivery is needed |
