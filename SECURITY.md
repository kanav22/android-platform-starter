# Security Policy

## Supported versions

| Version | Supported |
| ------- | --------- |
| 1.0.x   | Yes       |

## Reporting a vulnerability

If you discover a security issue in this template or its dependencies:

1. **Do not** open a public GitHub issue for sensitive reports.
2. Email **kanav.wadhawan@gmail.com** with:
   - Description of the vulnerability
   - Steps to reproduce
   - Impact assessment (if known)
3. Expect an initial response within **5 business days**.

## Scope

This policy covers the `android-platform-starter` repository. Downstream forks and production apps built from this template are the responsibility of their maintainers.

## Secure defaults

- No secrets in source control — use `local.properties` or CI secrets
- Dependencies are pinned via Gradle version catalogs
- CI runs on every pull request before merge
