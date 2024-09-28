<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
  <li>
      <a href="#about--api-health-check-project">About  API Health Check Project</a>
      <ul>
        <li><a href="#Framework-features">Framework features</a></li>
      </ul>
    </li>
    <li>
      <a href="#built-with">Built with</a>
    </li>
    <li>
      <a href="#getting-started">Getting started</a>
      	<ul>
        		<li><a href="#prerequisites">Prerequisites</a></li> 
        		<li><a href="#installation">Installation</a></li>       
        </ul>
    </li>
    <li>
    <a href="#usage">Usage</a>
        <ul>
            <li><a href="#writing-a-test">Writing a test</a></li>
            <li><a href="#testing-environment-information">Testing environment information</a></li>
            <li><a href="#running-tests">Running tests</a></li>
            <li><a href="#test-reports">Test reports</a>
                <ul>
                <li><a href="#extend-reporting">Extend reporting</a>
                </ul>
            </li>
        </ul>
    </li>
    <li><a href="#faq">FAQs</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- About  API Health Check Project -->

## About API Health Check Project

The goal of this project is to use API Automation to test the backend APIs for the App.

### Framework features

- Supports REST APIs
- Predefined test steps
- Predefined assertions
- Generating test reports
- Jenkins pipeline integration
- Environment agnostic

## Built with

- **RESTAssured** - for testing the API services [https://rest-assured.io/](https://rest-assured.io/)
- **TestNG** - for TDD approach [https://testng.org/](https://testng.org/)
- **Maven** - build management tool [https://maven.apache.org/](https://maven.apache.org/guides/)
- **Hamcrest** - for asserting the API responses [http://hamcrest.org/JavaHamcrest/tutorial](http://hamcrest.org/JavaHamcrest/tutorial)
- **Extend Reports** - for reporting the test results [https://extentreports.com/](https://extentreports.com/documentation-2/)

## Getting Started

Follow these instructions to get a microservices Framework up and running and testing on your local machine.

### Prerequisites

- JDK 8+
- Maven 3.0+
- IDE (IntelliJ or Eclipse)

### Installation

- Install Java and set path.
- Install Maven
- Clone the repository using git.
  - git clone <url>

<!-- USAGE EXAMPLES -->

## Usage

This framework is specifically designed to perform backend testing with REST API:

1. Perform backend and functional test and for application.

### Writing a test

- You can start writing test using reference at `src/test/java/api/`.

### Testing environment information

This framework is environment agnostic. You can provide the environment information under as follows:

Currently, default env is set as UAT<br> `mvn test -DsuiteXmlFile=config/TestSuites/testng.xml -Denv=uat `<br> `mvn test -DsuiteXmlFile=config/TestSuites/testng.xml -Denv=test `

### Running tests

There are two ways to run the test from this project

1. Using the testNG.xml File
   1. Locate the File: Navigate to the `config/TestSuites/testng.xml` file within your project directory.
   2. Running Tests:IDE Integration: If you're using an IDE like Eclipse or IntelliJ IDEA, right-click on the testng.xml file and select the **Run As** or **Run Tests** option specific to your IDE.
2. Select Tests:
   1. In your IDE, navigate to the package or individual test class containing the tests you want to run.
   2. Run Tests: Right-click on the package or class and select the **Run As** or **Run Tests** option provided by your IDE.

### Test reports

This Framework supports test reporting using Extend reporting

#### Extend reporting

This Framework also integrates with the Extends reporting framework. You can find the report after the Tests Execution

- directory for Extends report in the current project, **/\_API_Health_Check/reports/<folder_sorted_by_date>/API_Execution_Automation.html** by default

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b branchName`)
3. Commit your Changes (`git commit -m 'Updates'`)
4. Push to the Branch (`git push origin branchName`)
5. Open a Pull Request

## Contact

For any questions or inquiries, please get in touch with the Automation Team:

[Samir Kolhe](mailto:samirkolhe007@gmail.com)
