# ADR 005: Macrobenchmark and baseline profiles

**Status:** Accepted  
**Date:** 2026-06-21

## Context

Startup regressions are common when adopting Jetpack Compose. Teams discover performance issues post-release because measurement is not part of the template.

## Decision

Include a dedicated **`benchmark`** module with:

1. **`StartupBenchmark`** — cold startup timing via Macrobenchmark (physical device)
2. **`BaselineProfileGenerator`** — generates ART baseline profiles for release builds
3. CI job that at minimum **assembles** the benchmark module to prevent configuration drift

Document run commands in README; do not run connected benchmarks on every PR (device cost).

## Consequences

**Positive**
- Teams inherit performance tooling from day one
- Baseline profiles improve cold start for Compose-heavy UIs
- Signals platform maturity to adopters and hiring reviewers

**Negative**
- Connected benchmarks require hardware and are slow
- Baseline profiles add merge/maintenance overhead

## Alternatives considered

| Alternative | Why rejected |
|-------------|--------------|
| Firebase Performance only | Production metrics; no PR-level gate |
| Microbenchmark in unit tests | Does not measure real startup path |
| No performance module | Misses Principal-level platform signal |

See also: [Performance budgets article](../articles/macrobenchmark-performance-budgets.md)
