# Contributing

Thanks for helping improve this platform starter.

## Workflow

1. Fork and branch from `main`
2. Keep changes focused on architecture, DX, or documentation quality
3. Run quality gates locally:

   ```bash
   ./gradlew detekt :core:domain:test :feature:home:testDebugUnitTest assembleDebug
   ```

4. Open a PR with context on **why** the pattern change helps teams at scale

## Guidelines

- Preserve module boundaries (`feature` must not depend on `app`)
- Prefer testable use cases over ViewModel business logic
- Document non-obvious architectural decisions in README or code comments
- Match existing Kotlin and Compose style

## License

Contributions are licensed under the [MIT License](LICENSE).
