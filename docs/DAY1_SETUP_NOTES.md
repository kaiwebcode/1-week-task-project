# Day 1 setup notes

## Cursor: identify main Activity

**Answer:** The app’s main (launcher) Activity is:

`com.example.a1weektaskproject.MainActivity`

File: `app/src/main/java/com/example/a1weektaskproject/MainActivity.kt`

It is registered in `AndroidManifest.xml` with:

- `android.intent.action.MAIN`
- `android.intent.category.LAUNCHER`

## Codex check (run yourself)

After `codex --version` works:

```powershell
codex "What is the main launcher Activity in this Android project? Cite the file path."
```

Paste the reply under **Codex answer** below for evidence.

### Codex answer

_(paste here)_

## Emulator launch evidence

- AVD name: `Pixel_5`
- When online, run: `adb devices` and paste output here.
- Screenshot: emulator showing welcome screen → save under `docs/screenshots/` (create folder when ready).
