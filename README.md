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

### Appium Setup
- Install Appium
  ```zsh
  npm install -g appium
- Install uiautomator2
  ```zsh
  appium driver install uiautomator2
  
### Project Structure
```graphql
    Automation_UI_API/
    ├── app/
    │   └── mda-1.0.13-15.apk           # Android demo app
    ├── src/test/java/
    │   ├── api/                        # API tests (TestNG + RestAssured)
    │   │   ├── CompaniesApiTest.java
    │   │   └── CompaniesApiSchemaTest.java
    │   ├── pages/                      # Page Objects for UI tests
    │   ├── steps/                      # Step Definitions for UI tests
    │   └── runners/                    # Cucumber runner for UI
    └── src/test/resources/
        ├── features/                   # Cucumber features (UI)
        │   └── buy_product.feature
        └── schema/                     # JSON schema for API tests
            └── companies-schema.json
```

## Test Running

### UI Automation Testing using Appium
1. **Start Appium Server**
    Open a terminal
    ```zsh
    appium

2. **Check device**
   Open a terminal
    ```zsh
    adb devices

3. **Run UI Automation**
   Open a terminal
    ```zsh
   mvn test -Dcucumber.features="src/test/resources/features/buy_product.feature"

### API Automation Testing using RestAssured
1. **Start Appium Server**
   Open a terminal
    ```zsh
    mvn clean test -Dtest=api.CompaniesApiTest
    mvn clean test -Dtest=api.CompaniesApiSchemaTest
   
### ✅What is Tested?
1. UI Tests
   - Launch demo app 
   - Select product (Sauce Labs Backpack)
   - Select specification for product (color and quantity)
   - Verify order 
   - Proceed to checkout 
   - Login 
   - Verify product and total price in cart for checkout
   - Input data for payment
   - Process payment
   - Confirm payment

2. API Tests 
   - Validate GET /companies endpoint:
     - Returns correct number of items (20, 5, 1)
     - All id values are not null 
     - Response matches JSON Schema