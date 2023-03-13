# Setup Appium Android Java

1. Install Homebrew: Homebrew is a package manager for macOS that makes it easy to install and manage software dependencies. Open the Terminal app and run the following command to install Homebrew:
```sh
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

2.Install Java: You need Java Development Kit (JDK) version 11 or higher installed on your machine to use Appium with Java. You can download the latest version of JDK from the Oracle website or install it using Homebrew. To install JDK using Homebrew, run the following command in Terminal:
```sh
brew install --cask adoptopenjdk/openjdk/adoptopenjdk11
```

3. Install Android Studio: Android Studio is the official IDE for Android app development. It comes with the Android SDK, which Appium uses to interact with Android devices. You can download Android Studio from the official website.

4. Set up Android SDK: After installing Android Studio, open it and click on "Configure" in the Welcome screen. Select "SDK Manager" and then select the "SDK Platforms" tab. Make sure that you have installed the latest Android version (Android 12 at the time of writing). Then select the "SDK Tools" tab and make sure that the following components are installed:

- Android SDK Build-Tools
- Android SDK Platform-Tools
- Android SDK Tools
- Intel x86 Emulator Accelerator (HAXM installer) (optional, but recommended for faster emulation)

5. Set up environment variables: Open the Terminal app and run the following command to open your bash profile file:
```bash
nano ~/.bash_profile
```
Add the following lines to the file:
```sh
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools
```

6. Install Appium: You can install Appium using Homebrew. Run the following command in Terminal:
```sh
brew install node
npm install -g appium
```

7. Connect an Android device or start an emulator: Make sure that your Android device is connected to your computer via USB and that USB debugging is enabled in the developer options. Alternatively, you can start an Android emulator from Android Studio by clicking on "AVD Manager" and then clicking on the "Play" button next to the emulator you want to start.

8. Start Appium server: Open a new Terminal window and run the following command to start the Appium server:
```
appium
```
9. How to run: 
       a. Run with Intellij: choose TymeDemo.xml --> right click --> run
       b. Run with gradle: (not include this version)
10. Report: We have three report type
      a. html report when run with gradle and testng
      b. excel report(not include this version)
      c. real time report with slack (not include this version)
