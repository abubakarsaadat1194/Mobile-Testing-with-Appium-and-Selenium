# 📱 Mobile Testing with Appium and Selenium

![Appium](https://img.shields.io/badge/Appium-Mobile%20Automation-green)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-blue)
![Java](https://img.shields.io/badge/Java-Language-orange)
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-blue)
![Android](https://img.shields.io/badge/Android-Emulator-brightgreen)

This repository contains a **mobile test automation project using Appium and Selenium WebDriver**.  
The project demonstrates automated testing of an Android mobile application using **Java, Appium, Selenium, and Android Emulator**.

This project was developed as part of the course:

**Web and Mobile Testing with Selenium**  
University of Minnesota

---

# 📑 Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features Tested](#features-tested)
- [Project Structure](#project-structure)
- [Test Scenarios](#test-scenarios)
- [Setup Instructions](#setup-instructions)
- [Running the Tests](#running-the-tests)
- [Appium Capabilities Configuration](#appium-capabilities-configuration)
- [Tools Used](#tools-used)
- [Screenshots](#screenshots)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

# Project Overview

Mobile test automation enables QA engineers to validate mobile application behavior automatically across different devices and environments.

In this project, automated test cases were implemented for an Android mobile banking application called **EriBank** to simulate real user interactions such as:

- Logging into the application
- Performing a payment
- Handling alerts and dialogs
- Logging out of the application

The tests interact with UI elements, perform user actions, and validate application behavior using **Appium and Selenium WebDriver**.

---

# Technologies Used

- Appium
- Selenium WebDriver
- Java
- Gradle
- Android Emulator
- UiAutomator2
- Appium Inspector

---

# Features Tested

The automated tests cover the following scenarios:

- Login validation
- Failed login handling
- Successful login workflow
- Payment form interactions
- Slider interaction for payment amount
- Country selection
- Payment confirmation dialog handling
- Alert acceptance and dismissal
- Logout functionality

---

# Project Structure

    mobile-testing-appium-selenium
    │
    ├── src
    │   └── test
    │       └── java
    │           └── tests
    │               └── MobileTest.java
    │
    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    └── README.md

Description:

| File / Folder | Description |
|---------------|-------------|
| src/test/java/tests | Contains mobile automation test scripts |
| MobileTest.java | Main Appium automation test |
| build.gradle | Gradle build configuration |
| gradlew | Gradle wrapper script |
| README.md | Project documentation |

---

# Test Scenarios

### Successful Login

Steps:

1. Launch the EriBank application  
2. Enter valid username and password  
3. Click login  
4. Verify successful login  

---

### Failed Login

Steps:

1. Launch the application  
2. Enter invalid credentials  
3. Attempt login  
4. Verify error message appears  

---

### Payment Transaction

Steps:

1. Login successfully  
2. Navigate to payment screen  
3. Enter payment details  
4. Adjust payment slider  
5. Select destination country  
6. Submit payment  
7. Verify confirmation dialog  

---

### Logout Functionality

Steps:

1. Login successfully  
2. Perform actions inside the application  
3. Click logout  
4. Verify user is redirected to login screen  

---

# Setup Instructions

### Install Java

Verify installation:

    java -version

---

### Install Android Studio

Install Android Studio to get:

- Android SDK
- Android Emulator
- AVD Manager

---

### Install Appium

    npm install -g appium

Verify installation:

    appium -v

---

### Install Appium Inspector

Download from:

https://github.com/appium/appium-inspector

---

### Start Android Emulator

Open:

Android Studio → AVD Manager → Start Emulator

---

### Start Appium Server

    appium

---

# Running the Tests

Run the Gradle command:

    ./gradlew test

or on Windows:

    gradlew test

---

# Appium Capabilities Configuration

Example desired capabilities:

    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
    capabilities.setCapability("appActivity", ".LoginActivity");

---

# Tools Used

| Tool | Purpose |
|------|--------|
| Appium | Mobile automation framework |
| Selenium WebDriver | Automation API |
| Gradle | Build and dependency management |
| Android Emulator | Virtual Android device |
| Appium Inspector | UI element inspection tool |

---

# Screenshots

You can include screenshots such as:

- Login screen
- Payment screen
- Confirmation dialog
- Logout confirmation

Example folder:

    screenshots/
    ├── login.png
    ├── payment.png
    ├── confirmation.png
    └── logout.png

---

# Future Improvements

Possible enhancements for this project:

- Implement Page Object Model (POM)
- Integrate TestNG / JUnit
- Add parallel device testing
- Generate automated test reports
- Integrate CI/CD pipeline

---

# Author

Abu Bakar Saadat  
QA Automation Engineer

Skills:

- Selenium WebDriver  
- Playwright Automation  
- Appium Mobile Testing  
- JMeter Performance Testing  
- Python & Java Automation

---

⭐ If you found this project useful, consider giving it a **star**!
