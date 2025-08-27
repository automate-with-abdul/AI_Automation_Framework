# Java Automation Framework

A comprehensive automation framework for Java-based applications, built using Selenium WebDriver and TestNG.

## Features

*   Supports multiple browsers (Chrome, Firefox, Edge)
*   Uses Page Object Model (POM) for efficient test maintenance
*   Includes robust reporting capabilities with ExtentReports
*   Utilizes TestNG for parallel execution and flexible test configuration

## Requirements

*   Java 11 or later
*   Maven 3.6.0 or later
*   Selenium WebDriver 4.16.1 or later
*   TestNG 7.10.2 or later
*   ExtentReports 5.1.1 or later

## Setup

1.  Clone the repository using Git: `git clone https://github.com/your-username/java-automation-framework.git`
2.  Navigate to the project directory: `cd java-automation-framework`
3.  Run the following command to install dependencies: `mvn clean install`

## Running Tests

1.  Update the test configuration file (`testng.xml`) as needed
2.  Run the tests using Maven: `mvn test`

## Reporting

*   ExtentReports reports are generated in the `target/reports` directory
*   Reports can be viewed in the browser by opening the `index.html` file

## Contributing

Contributions to this project are welcome! Please submit a pull request with your changes.

## License

This project is licensed under the MIT License.
