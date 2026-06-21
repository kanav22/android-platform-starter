# Architecture Decision Records

This folder documents significant architectural choices in **android-platform-starter**. ADRs capture context, the decision, and consequences — the same format used in platform teams at scale.

| ADR | Title | Status |
|-----|-------|--------|
| [001](001-multi-module-boundaries.md) | Multi-module Gradle boundaries | Accepted |
| [002](002-hilt-dependency-injection.md) | Hilt for dependency injection | Accepted |
| [003](003-compose-stateflow-ui.md) | Compose UI state via StateFlow | Accepted |
| [004](004-detekt-ci-gates.md) | Detekt static analysis in CI | Accepted |
| [005](005-macrobenchmark-baseline-profiles.md) | Macrobenchmark and baseline profiles | Accepted |

## Format

Each ADR follows: **Context → Decision → Consequences → Alternatives considered**.

When you fork this starter, add ADRs for your own domain decisions (network layer, auth, analytics) rather than editing these in place — keep upstream ADRs as reference.
