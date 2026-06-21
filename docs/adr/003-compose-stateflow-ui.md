# ADR 003: Compose UI state via StateFlow

**Status:** Accepted  
**Date:** 2026-06-21

## Context

Compose recomposes when state changes. Ad-hoc `mutableStateOf` in ViewModels or scattered `remember` blocks make UI state hard to test and reason about at scale.

## Decision

Feature ViewModels expose **`StateFlow<UiState>`** as the single source of truth for screen rendering:

- UI collects with `collectAsStateWithLifecycle()`
- One immutable `data class UiState` per screen
- Side effects (snackbars, navigation) via `SharedFlow` or one-shot channels — not embedded in `UiState`

Presentation layer does not hold business logic; ViewModels delegate to use cases in `core:domain`.

## Consequences

**Positive**
- ViewModel unit tests assert state transitions without Compose
- Predictable recomposition — single state object per screen
- Aligns with Google's recommended UDF pattern

**Negative**
- Verbose for trivial screens (acceptable tradeoff in a platform template)

## Alternatives considered

| Alternative | Why rejected |
|-------------|--------------|
| MVI with sealed events | Valid at scale; starter uses lighter StateFlow UDF first |
| `LiveData` | Legacy; Compose prefers Flow |
| Decompose / Circuit | Powerful but adds learning curve for a generic starter |
