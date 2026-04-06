# Personal Notify Assistant

Android notification logger for personal assistant workflows.

## Features
- Captures incoming notifications with `NotificationListenerService`
- Stores notifications in Room/SQLite
- Lists latest notifications in the app UI
- Exports saved notifications as JSON or CSV
- Builds APK in GitHub Actions without local Android Studio installation

## What is included
- Android app source code
- GitHub Actions workflow for APK build

## GitHub usage
1. Create an empty GitHub repository.
2. Upload all files from this project.
3. Push to `main`.
4. Open the `Actions` tab.
5. Run `Build Android APK` or wait for push trigger.
6. Download the APK from workflow artifacts.

## First run on phone
1. Install APK.
2. Open app.
3. Tap `Erişim Ayarları`.
4. Enable notification access for the app.
5. Return to app and check captured notifications.

## Notes
- This first version stores notifications locally only.
- LLM analysis is intentionally left for the second phase to keep costs controlled.
- Export files are saved under the app's external documents directory.
