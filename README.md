# UI and API Automation Project

This project contains 2 types testing:
1. **Mobile UI Automation Testing** -> Using Java + Appium + TestNG + Cucumber
2. **API Automation Testing** -> Using Java + restAssured + TestNG

## Tools and Pre-requisites

### Tools
- [Java SDK 25](https://www.oracle.com/asean/java/technologies/downloads/) -> You can change version based on your needs
- [Maven 3.9+](https://maven.apache.org/) -> You can change version based on your needs
- [Node.js 24.8+](https://nodejs.org/) -> Required for install several packages
- [Android Studio](https://developer.android.com/studio) -> For emulator and Android Platform Tools

### Notes
- Don't forget to set ANDROID_HOME or ANDROID_SDK_ROOT environment variables
- Set the following to your `~/.zshrc` or `~/.bashrc`:

  ```bash
  export ANDROID_HOME=$HOME/Library/Android/sdk
  export ANDROID_SDK_ROOT=$ANDROID_HOME
  export PATH=$PATH:$ANDROID_HOME/platform-tools
  export PATH=$PATH:$ANDROID_HOME/emulator
  export PATH=$PATH:$ANDROID_HOME/tools
  export PATH=$PATH:$ANDROID_HOME/tools/bin

