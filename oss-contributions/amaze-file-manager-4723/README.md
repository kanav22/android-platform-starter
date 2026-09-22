# Amaze File Manager — edge-to-edge fix (#4723)

Upstream issue: https://github.com/TeamAmaze/AmazeFileManager/issues/4723

## Change

Updates `ThemedActivity` so Android 15+ (API 35+) edge-to-edge enforcement applies system bar insets to the activity content root:

- `WindowCompat.setDecorFitsSystemWindows(window, false)` in `onCreate`
- Window inset listener on the content root (not the bare `content` frame)
- `requestApplyInsets()` so padding is applied on first layout

## Open the PR (your GitHub account)

```bash
git clone https://github.com/TeamAmaze/AmazeFileManager.git
cd AmazeFileManager
git remote add fork git@github.com:YOUR_USER/AmazeFileManager.git
git checkout -b fix/4723-edge-to-edge-insets
git am /path/to/0001-fix-ui-apply-window-insets-on-API-35-edge-to-edge-sc.patch
# or copy ThemedActivity.java into app/src/main/java/.../ThemedActivity.java
git push -u fork fix/4723-edge-to-edge-insets
gh pr create -R TeamAmaze/AmazeFileManager --head YOUR_USER:fix/4723-edge-to-edge-insets --title "fix(ui): edge-to-edge insets for Settings and text editor (fixes #4723)" --body "Fixes #4723"
```

Comment on the issue before opening the PR so maintainers know you are working on it.
