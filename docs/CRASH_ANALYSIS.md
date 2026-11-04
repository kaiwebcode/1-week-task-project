# Day 2 - Crash Analysis

## 1. Crash Summary

Exception: NullPointerException
Component: MainActivity
Failing line: MainActivity.kt:17

## 2. Reproduction

A temporary nullable variable was initialized to null.
The Kotlin not-null assertion operator (!!) was used to access its length.
The application crashed during Activity startup.

## 3. Observation

Tool: Android Studio Logcat
Exception: java.lang.NullPointerException
Process: com.example.a1weektaskproject
Location: MainActivity.kt:17
Full filtered evidence: CRASH_LOGCAT.txt

## 4. Root Cause

The debugTaskDescription variable contained null.
The !! operator attempted to force a non-null value.
This caused a NullPointerException at runtime.

## 5. Fix

The temporary crash-testing statements were removed.
The normal application initialization and navigation code were restored.
Safer nullable handling uses ?. or ?: where appropriate.

## 6. Verification

The application was rebuilt successfully.
The final application must be launched and both navigation directions retested.

## 7. Evidence

- docs/CRASH_LOGCAT.txt
- docs/screenshots/day2-logcat-crash.png
