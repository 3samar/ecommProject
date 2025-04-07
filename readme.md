ecommProject

**ecommProject** is a Java-based automation framework designed for end-to-end testing of e-commerce applications. It leverages Selenium WebDriver for browser automation and Cucumber for behavior-driven development (BDD), facilitating readable and maintainable test scenarios.

## Table of Contents

- [Project Structure](#project-structure)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

The repository is organized as follows:

- `src/main/java`: Contains the main application code.
- `src/test/java`: Houses test-related code, including step definitions and hooks.
- `src/test/resources`: Contains feature files written in Gherkin syntax and other test resources.
- `pom.xml`: Maven configuration file managing project dependencies and build configurations.
- `.gitignore`: Specifies files and directories to be ignored by Git.

## Features

- **Behavior-Driven Development (BDD)**: Utilizes Cucumber to write test scenarios in a human-readable format.
- **Page Object Model (POM)**: Implements POM design pattern for better maintainability and readability of test scripts.
- **Cross-Browser Testing**: Supports testing across multiple browsers using Selenium WebDriver.
- **Data-Driven Testing**: Facilitates testing with multiple data sets using external files like Excel or JSON.
- **Reporting**: Integrates with Extent Reports for comprehensive test execution reports.

## Prerequisites

Ensure the following are installed:

- [Java Development Kit (JDK) 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome/) (for ChromeDriver)

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/3samar/ecommProject.git
Navigate to the Project Directory:

bash
Copy
Edit
cd ecommProject
Install Dependencies:

Use Maven to install required dependencies:

bash
Copy
Edit
mvn clean install
Usage
Run Tests:

Execute the test suite using Maven:

bash
Copy
Edit
mvn test
This command will initiate test execution based on the scenarios defined in the feature files.

View Test Reports:

After test execution, reports are generated in the target directory. Open the index.html file located in target/extent-reports/ to view the detailed test report.