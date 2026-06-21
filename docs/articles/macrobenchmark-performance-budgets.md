# Performance Budgets with Macrobenchmark and Baseline Profiles

**Kanav Wadhawan** · Principal Android Engineer  
*Companion to [android-platform-starter](https://github.com/kanav22/android-platform-starter)*

---

## The problem

Teams ship Compose features quickly, then discover cold start regressed by 400ms — after release. Performance work becomes reactive firefighting instead of a platform standard.

Principal engineers treat startup and frame time like API contracts: measurable, gated, and owned.

## Decision 1: Macrobenchmark in the template, not as a side project

The `benchmark` module in android-platform-starter ships with:

- **Cold startup measurement** via `StartupBenchmark`
- **Baseline profile generation** via `BaselineProfileGenerator`

This encodes the expectation that every new app cloned from the starter can answer: *"What is our cold start on a physical device?"*

```kotlin
benchmarkRule.measureRepeated(
    packageName = "dev.kanav.platform.starter",
    metrics = listOf(StartupTimingMetric()),
    startupMode = StartupMode.COLD,
    iterations = 5,
) {
    startActivityAndWait()
}
```

Run on hardware — emulators lie about I/O and JIT:

```bash
./gradlew :benchmark:connectedBenchmarkReleaseAndroidTest
```

## Decision 2: Baseline profiles as a compile-time investment

Baseline profiles tell ART which methods to AOT-compile before first launch. For Compose-heavy apps, the win is often hundreds of milliseconds on cold start.

Generate profiles in CI or locally, commit to `src/main/baseline-prof.txt`, and treat profile drift like a failing test.

## Decision 3: Performance budgets in CI (the Principal move)

A budget is an SLO with teeth:

| Metric | Example budget |
|--------|----------------|
| Cold start (p50) | < 800ms on reference device |
| Cold start regression | No PR may increase p50 by > 5% |
| Baseline profile | Must compile; no empty profile on release |

At org scale, Macrobenchmark runs on a dedicated device farm. At starter scale, the module exists so teams adopt the habit before they need the farm.

## Decision 4: Separate benchmark variant from debug

Debug builds include debugging overhead. Benchmark and baseline profile work targets **release-like** builds with minification enabled — otherwise you optimize the wrong binary.

## What I'd add at scale

| Starter template | Production platform |
|------------------|---------------------|
| Manual device runs | Firebase Test Lab / internal device pool |
| Startup only | Scroll jank + memory benchmarks |
| Local profile gen | CI-generated profiles per release train |
| Documented budgets | Automated PR comments with delta |

## Summary

Performance is architecture. Shipping Macrobenchmark and baseline profiles in a platform starter raises the floor: every squad inherits the tooling to measure before users complain.

Code: [github.com/kanav22/android-platform-starter](https://github.com/kanav22/android-platform-starter/tree/main/benchmark)

---

*Questions? Open a PR or reach out on [LinkedIn](https://www.linkedin.com/in/kanav-wadhawan/).*
