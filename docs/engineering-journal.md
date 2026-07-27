# Ping Engineering Journal

## Day 1 | 2026-07-25

### Goal
Initialize the Ping project and establish the engineering workflow.

### Completed
- Initialized Android project
- Connected GitHub
- Created first commit
- Created and closed Issue #1

### Engineering Learnings
- `git push -u origin main` sets the upstream branch.
- Local and remote branches are independent until linked.
- Debugging starts with inspecting the current state (`git status`, `git branch`, `git log`).

### Challenges
- `error: src refspec main does not match any`
- Cause: Local branch was `master`.
- Fix: Renamed branch to `main`.

### Next Session
- README
- LICENSE
- ROADMAP

# Day 2 — 27-07-2026

## Objective

Complete Issue #2 by building Ping's first complete user journey, introducing Navigation Compose, connecting the Splash Screen to the Home Screen, and validating the experience on a physical Android device.

---

# Tasks Completed

## Splash Experience

- Improved the Splash Screen implementation.
- Refined spacing and visual hierarchy.
- Added a subtle fade and scale animation.
- Verified the animation felt smooth on a physical device.

---

## Home Screen

- Created the initial `HomeScreen` composable.
- Built a simple placeholder UI to act as the first destination after the splash screen.

---

## Navigation

- Added Navigation Compose dependency.
- Created `Routes.kt` to centralize navigation destinations.
- Created `AppNavigation.kt`.
- Introduced `NavHost`.
- Introduced `NavController`.
- Connected `MainActivity` to the navigation graph.
- Implemented automatic navigation from Splash Screen to Home Screen using `LaunchedEffect`.
- Removed Splash Screen from the back stack using `popUpTo()`.

---

## Physical Device Testing

- Learned how to generate Debug APKs.
- Generated multiple APK builds.
- Installed Ping manually on my Android phone.
- Verified the complete navigation flow on a physical device.

---

# Challenges

## USB Debugging

My OPPO F25 Pro was no longer detected by Windows through USB.

After testing different USB cables, another Android phone, ADB, Android Studio, and Windows USB detection, I concluded that the issue is most likely with the phone's USB data connection rather than the development environment.

### Solution

Instead of blocking development, I switched to generating Debug APKs and manually installing them on the phone for testing.

---

## Emulator Launch Behaviour

Android Studio occasionally installed the application without bringing it to the foreground.

The application was already running in the background and could be opened manually.

Since the APK behaved correctly on the physical device, I decided to continue development instead of spending more time debugging the emulator.

---

# Concepts Learned

## Android

- Navigation Compose
- NavHost
- NavController
- Routes
- LaunchedEffect
- delay()
- popUpTo()
- Animatable
- graphicsLayer

---

## Development Workflow

- APK Generation
- Manual APK Installation
- Physical Device Testing
- Navigation Architecture
- Incremental Git Commits
- Feature-based Development

---

# Reflection

Today was the first day Ping started feeling like a real Android application instead of a learning project.

The biggest lesson wasn't learning Navigation Compose—it was understanding that software engineering extends far beyond writing code.

Planning work with GitHub Issues, implementing features in small milestones, committing meaningful changes, generating APKs, testing on real hardware, documenting progress, and reflecting on what I learned all contributed to building a better product.

Seeing Ping launch on my own phone and smoothly transition from the Splash Screen to the Home Screen was a rewarding moment. It reinforced the importance of building features incrementally and validating them on actual devices.

---

# Progress

## Completed

- Splash Screen
- Home Screen
- Navigation Architecture
- Splash Animation
- APK Generation
- Physical Device Testing

---

## Next

Issue #3 — Build the Home Screen foundation.

---

# Time Invested

Approximately one full engineering session focused on architecture, navigation, testing, and deployment.

---

# End of Day Summary

Today I didn't just build another screen.

I built Ping's first complete user experience.