# Day 1 setup notes

## Cursor: identify main Activity

**Answer:** The app’s main (launcher) Activity is:

`com.example.a1weektaskproject.MainActivity`

File: `app/src/main/java/com/example/a1weektaskproject/MainActivity.kt`

It is registered in `AndroidManifest.xml` with:

- `android.intent.action.MAIN`
- `android.intent.category.LAUNCHER`

## Codex check (workspace review)

### Codex answer

The main launcher Activity is `com.example.a1weektaskproject.MainActivity`, in `app/src/main/java/com/example/a1weektaskproject/MainActivity.kt`. `app/src/main/AndroidManifest.xml` registers `.MainActivity` with the `MAIN` action and `LAUNCHER` category. Confirmed in this Codex workspace review.

## Remaining workstation check

- Cursor executable is installed and Mermaid Markdown preview is installed. The Cursor window closed during inspection, so its sign-in state remains unverified.

## Emulator launch evidence

- Device: Pixel 5 emulator (`emulator-5554`, online)
- Build: `app:assembleDebug` succeeded with Android Studio JBR set as `JAVA_HOME`.
- Install and launch: `adb install -r app-debug.apk` succeeded; `am start` opened `com.example.a1weektaskproject/.MainActivity`.
- Screenshot: [`docs/screenshots/day1-emulator.png`](screenshots/day1-emulator.png), captured November 3, 2026.
