LeetCode Solutions in Java
This repository contains my solutions to LeetCode problems, implemented in Java. The project is set up using Gradle for build automation and is organized for easy navigation and contribution.

Project Structure
src/: Contains Java source files with LeetCode solutions, organized by problem category or number.
build.gradle.kts: Gradle build script (using Kotlin DSL) for managing dependencies and build tasks.
gradlew & gradlew.bat: Gradle wrapper scripts for consistent builds across environments.
Prerequisites
Java Development Kit (JDK): Version 8 or higher (Java 8+ is recommended for compatibility).
Gradle: Use the included Gradle wrapper (gradlew) to avoid version mismatches.
Setup Instructions
Clone the Repository:
text

Copy
git clone https://github.com/<your-username>/LeetCodeSolutions.git
cd LeetCodeSolutions
Build the Project: Use the Gradle wrapper to build the project:
text

Copy
./gradlew build
On Windows, use:
text

Copy
gradlew.bat build
Run a Solution:
Navigate to the src/ directory.
Solutions are organized in Java files (e.g., TwoSum.java).
You can run a specific solution by adding a main method with test cases or using a test framework like JUnit (add dependency in build.gradle.kts if needed).
