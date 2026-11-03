# Employee Task Manager (Week 1)

Android Developer Bootcamp — Week 1 (Nov 3–6, 2026)  
One project all week: **Employee Task Manager** (Kotlin Android).

Project folder: `1weektaskproject` (used as the Week 1 training app).

## Day 1 goal

Every required tool is installed and works. Starter APK builds and launches.

## Stack

| Area | Tools |
|------|--------|
| Android | Android Studio (stable), bundled JDK (JBR), Android SDK, Platform Tools (ADB), Emulator |
| App | Kotlin Android starter (`MainActivity`) |
| Dev / AI | Git, Cursor, Node.js LTS + npm, Codex CLI |

## Verified tool versions (Day 1)

Run these in PowerShell:

```powershell
# Add Android Studio JBR to PATH for this session if `java` is missing:
$env:Path = "C:\Program Files\Android\Android Studio\jbr\bin;" + $env:Path + ";" + "$env:APPDATA\npm"

java -version
git --version
node -v
npm -v
adb version
codex --version
```

Recorded on this machine:

| Check | Result |
|-------|--------|
| `java -version` | OpenJDK 25.0.4 (Android Studio JBR at `C:\Program Files\Android\Android Studio\jbr`) — **not on system PATH by default** |
| `git --version` | git version 2.50.0.windows.1 |
| `node -v` | v22.22.0 |
| `npm -v` | 10.9.4 |
| `adb version` | Android Debug Bridge 1.0.41 (37.0.1) |
| `codex --version` | codex-cli 0.166.0 (installed via `npm install -g @openai/codex`) |

## Project entry point

- **Main Activity:** [`MainActivity`](app/src/main/java/com/example/a1weektaskproject/MainActivity.kt) (`com.example.a1weektaskproject.MainActivity`)
- Declared as `MAIN` / `LAUNCHER` in [`AndroidManifest.xml`](app/src/main/AndroidManifest.xml)
- Layout: [`activity_main.xml`](app/src/main/res/layout/activity_main.xml)
- Application ID: `com.example.a1weektaskproject`
- AGP: 9.5.0 · compile/targetSdk 37 · minSdk 24

## Build & run

### From Android Studio

1. Open this folder in Android Studio.
2. Wait for Gradle sync.
3. Start AVD **Pixel_5** (Device Manager) or connect a phone with USB debugging.
4. Run configuration **app** (green play button).

### From terminal

```powershell
.\gradlew.bat app:assembleDebug

# Start emulator (example)
& "$env:LOCALAPPDATA\Android\Sdk\emulator\emulator.exe" -avd Pixel_5

adb install -r .\app\build\outputs\apk\debug\app-debug.apk
adb shell am start -n com.example.a1weektaskproject/.MainActivity
```

Day 1 build check: `app:assembleDebug` **succeeded**.

## Setup issues / notes

1. **`java` not on PATH** — Android Studio’s JBR works; add `C:\Program Files\Android\Android Studio\jbr\bin` to User PATH, or use the session command above.
2. **Codex CLI was missing** — installed with `npm install -g @openai/codex`.
3. **Starter project had no Activity** — added `MainActivity` + layout + launcher intent-filter so the APK can launch.
4. **No device attached initially** — use AVD `Pixel_5` or a physical device for the launch exit gate.
5. **Git** — repository not initialized yet; complete init → first commit → remote push for the Day 1 Git exit gate.

## Day 1 exit gate checklist

- [x] Tools verified (java via JBR, git, node, npm, adb, codex)
- [x] Starter APK compiles (`assembleDebug`)
- [ ] App launches on emulator or phone
- [x] Cursor can identify main Activity (`MainActivity`)
- [ ] Codex asked to identify main Activity (run locally after `codex login` if needed)
- [ ] Git initialized, first commit, pushed to remote
- [x] README documents setup + issues

## Week map (from bootcamp PPT)

| Day | Focus |
|-----|--------|
| Tue 03 | Set up tools, run starter, first commit |
| Wed 04 | Navigate code, trace clicks, debug |
| Thu 05 | Requirements, Cursor plan, Codex review |
| Fri 06 | Implement task list, fix 2 bugs, PR |
| Sat 07 | Revise | Sun 08 | Off |
