# ADR 002: Hilt for dependency injection

**Status:** Accepted  
**Date:** 2026-06-21

## Context

Manual service locators and static singletons make testing and module boundaries fragile. The starter needs a DI approach that works across `app`, `feature`, and `core` modules with compile-time validation.

## Decision

Use **Dagger Hilt** with:

- `@HiltAndroidApp` on the Application class
- `@HiltViewModel` for feature ViewModels
- `@Module` / `@InstallIn` per layer (`SingletonComponent`, `ViewModelComponent`)
- Repository binding: `@Binds` interface in `core:data`, consumed in features via constructor injection

## Consequences

**Positive**
- Compile-time graph validation
- First-class ViewModel injection
- Standard Android/Google recommendation; familiar to hiring pipeline

**Negative**
- KSP/KAPT build cost
- Not multiplatform — KMP projects should use Koin or manual DI in shared code

## Alternatives considered

| Alternative | Why rejected |
|-------------|--------------|
| Koin | Runtime DI; weaker compile-time guarantees for large teams |
| Manual constructor injection | Works for tiny apps; does not scale binding complexity |
| Dagger without Hilt | More boilerplate for Android lifecycle scopes |
