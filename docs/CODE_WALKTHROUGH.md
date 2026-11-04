# Day 2 - Android Code Walkthrough

## 1. Project Overview

- Project: Employee Task Manager
- Language: Kotlin
- UI: Native Android XML Views
- Application ID: com.example.a1weektaskproject
- Main Activity: MainActivity

## 2. Application Entry Point

File:
app/src/main/java/com/example/a1weektaskproject/MainActivity.kt

MainActivity is registered as the launcher Activity in AndroidManifest.xml.

The manifest contains:
- android.intent.action.MAIN
- android.intent.category.LAUNCHER
- android:exported="true"

## 3. Application Startup Flow

1. User launches Android Training.
2. Android reads AndroidManifest.xml.
3. Android launches MainActivity.
4. Android invokes onCreate(savedInstanceState).
5. MainActivity calls super.onCreate(savedInstanceState).
6. MainActivity calls setContentView(R.layout.activity_main).
7. Android displays activity_main.xml.

## 4. MainActivity.kt

MainActivity extends AppCompatActivity.

Important concepts:
- class: Declares MainActivity.
- inheritance: MainActivity inherits from AppCompatActivity.
- override: Provides an implementation of an inherited function.
- onCreate(): Activity lifecycle callback.
- Bundle?: Nullable Bundle parameter.
- super.onCreate(): Calls the parent implementation.
- setContentView(): Loads the XML layout.

## 5. XML Layout

File:
app/src/main/res/layout/activity_main.xml

Root component:
LinearLayout

Properties:
- ID: main
- Orientation: vertical
- Gravity: center
- Padding: 24dp
- Width: match_parent
- Height: match_parent

Child components:

1. TextView
   - ID: titleText
   - Text: @string/welcome_title

2. TextView
   - ID: subtitleText
   - Text: @string/welcome_subtitle

## 6. Android Resources

- values/strings.xml: Application name and welcome text.
- values/colors.xml: Reusable application colours.
- values/themes.xml: Default application theme.
- values-night/themes.xml: Night-mode theme.
- drawable/: Drawable resources.
- mipmap-*/: Launcher icons.
- xml/: Additional XML configuration.

## 7. AndroidManifest.xml

The manifest configures:
- Application name and icons.
- Application theme.
- MainActivity registration.
- MAIN action.
- LAUNCHER category.
- Activity exported setting.

## 8. Gradle Configuration

App-level build.gradle.kts:

- Android Gradle Plugin: 9.5.0
- compileSdk: 37
- minSdk: 24
- targetSdk: 37
- Java compatibility: 11
- Application ID: com.example.a1weektaskproject

Dependencies:
- AndroidX AppCompat
- AndroidX Core KTX
- Material Components
- JUnit
- Espresso

Dependency versions are managed in gradle/libs.versions.toml.

## 9. Kotlin Fundamentals Studied

- Variables: val and var.
- Data types: String, Int, Double and Boolean.
- Functions and parameters.
- Return values.
- Classes and objects.
- Constructors.
- Null safety.
- Nullable types.
- Safe call operator (?.).
- Elvis operator (?:).
- Not-null assertion (!!).

## 10. Activity Lifecycle

Lifecycle callbacks studied:

- onCreate()
- onStart()
- onResume()
- onPause()
- onStop()
- onRestart()
- onDestroy()

MainActivity currently overrides onCreate().
The Android framework manages the Activity lifecycle.

## 11. Android Studio Navigation and Inspection

Exercises completed:

- Go to Definition.
- Find Usages.
- Find in Files.
- Call Hierarchy.
- Logcat baseline inspection.
- Breakpoint and variable inspection.
- Android Layout Inspector.

Chrome Inspect Element is not applicable to this native Android XML application. It is intended for inspecting web content.

## 12. Home to Task Details Exercise

The Day 2 assignment requires tracing the Home to Task Details button-click flow.

A project-wide search was performed inside app/src/main.

Files inspected: 13 Kotlin and XML source files.

Search patterns included:

- setOnClickListener
- OnClickListener
- android:onClick
- startActivity
- Intent
- Button
- ImageButton
- NavController
- navigate

Result:

No matching click-handler or navigation patterns were found.

The current starter project contains:
- No Task Details screen.
- No Button in activity_main.xml.
- No click listener.
- No Activity navigation implementation.

Therefore, the requested Home to Task Details execution flow cannot be traced in the current starter project.

This limitation should be clarified with the trainer before implementing additional functionality.

## 13. Conclusion

The current project is a basic native Kotlin Android starter application.

The application launches through MainActivity, executes onCreate(), and loads activity_main.xml.

The Kotlin fundamentals, Activity lifecycle, Android resources, Manifest, Gradle configuration, Android Studio navigation and UI inspection have been studied.

No Task Details feature or additional application functionality was implemented during this walkthrough.

## 14. Completed Home to Task Details Exercise

A working button-click navigation exercise was subsequently implemented.

Home screen:
- MainActivity.kt
- activity_main.xml
- Button ID: viewTaskDetailsButton

Execution flow:
1. MainActivity.onCreate() initializes the Home screen.
2. findViewById() retrieves the button.
3. setOnClickListener() registers the click callback.
4. User taps View Task Details.
5. openTaskDetails("TASK-001") is called.
6. An explicit Intent targets TaskDetailsActivity.
7. putExtra() transfers the task ID.
8. startActivity() launches TaskDetailsActivity.
9. TaskDetailsActivity.onCreate() loads its XML layout.
10. getStringExtra() retrieves TASK-001.
11. Task information is displayed in TextViews.

Back navigation:
- backToHomeButton uses setOnClickListener().
- finish() closes TaskDetailsActivity.
- Android returns to the existing MainActivity.

Both navigation directions were tested successfully.
This is a Day 2 learning exercise using sample in-memory data.
