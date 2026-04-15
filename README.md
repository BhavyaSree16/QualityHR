#  OrangeHRM Automation Testing Framework

##  Project Overview

This project is a **Selenium Automation Framework** built using **Java, TestNG, and Page Object Model (POM)** to automate and validate key functionalities of the OrangeHRM application.

The framework includes:

* Functional Testing
* Validation Testing
* End-to-End Testing
* Reporting with Screenshots

---

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** Extent Reports
* **Listener:** ITestListener
* **Build Tool:** Maven
* **IDE:** Eclipse

---

##  Project Structure

```bash
project/
├── src/
│   ├── test/java/
│   │   ├── tests/
│   │   │   ├── LoginTest.java
│   │   │   ├── EmployeeTest.java
│   │   │   ├── EmployeeValidationTest.java
│   │   │   ├── LeaveTest.java
│   │   │
│   │   ├── utils/
│   │   │   ├── ConfigReader.java
│   │   │   ├── DriverFactory.java
│   │   │   ├── ExtentManager.java
│   │   │   ├── JsonUtils.java
│   │   │   ├── ScreenshotUtils.java
│   │
│   ├── test/resources/
│   │   ├── config.properties
│   │   ├── loginData.json
│
├── reports/
│   └── ExtentReport.html
│
├── screenshots/
│   └── *.png
│
├── testng.xml
├── pom.xml
```

---

##  Key Features

✔ Page Object Model (POM)
✔ Config-driven framework
✔ JSON data handling
✔ Reusable utilities
✔ Explicit wait handling
✔ End-to-End test flow
✔ Validation test cases
✔ Extent Reports integration
✔ Screenshot capture on test failure

---

## Screenshot Handling 

* Implemented using **ITestListener**
* Screenshots are captured **automatically on test failure**
* Stored in:

  ```
  /screenshots/
  ```
* The same screenshots are attached inside the **Extent Report**

 This ensures easy debugging and clear reporting.

---

##  Reporting

* Extent Reports are generated after execution
* Location:

  ```
  /reports/ExtentReport.html
  ```

### Report Includes:

* Test execution status (Pass / Fail / Skip)
* Error stack traces
* Screenshots for failed tests
* Step logs

---

##  Test Scenarios Covered

###  Login Module

* Valid Login
* Invalid Login Handling

---

###  Employee Module (PIM)

* Add Employee
* Verify Employee in List
* Search Employee
* Open Employee Record

---

###  Employee Validation

* Empty mandatory field validation
* Invalid date format validation
* Dropdown selection validation

---

###  Leave Module

* Navigate to Leave module
* Apply leave
* Verify leave status
* Validate past date errors

---

###  End-to-End Scenario

* Create Employee
  → Create System User
  → Verify User
  → Delete User

---

##  How to Run the Project

1. Clone repository:

```bash
git clone <your-repo-link>
```

2. Open in Eclipse / IntelliJ

3. Update `config.properties` if required

4. Run tests:

```bash
Right Click → Run As → TestNG Test
```

---

##  Important Notes

* Explicit waits are used for dynamic elements
* Loader handling implemented to avoid click issues
* Dropdowns handled with fallback strategies
* Screenshots captured automatically on failure using ITestListener
* Framework is designed to be scalable and maintainable

---

##  Highlights

✔ Real-world automation framework
✔ Handles Selenium challenges (waits, loaders, dropdowns)
✔ Clean modular structure
✔ Integrated reporting with screenshots
✔ End-to-End coverage

---

##  Author

**Bhavya Sree Kasa**

---

##  Conclusion

This project demonstrates a **complete automation testing lifecycle**, including:

* Framework design
* Test execution
* Validation handling
* Reporting with screenshots

It is suitable for:
✔ Academic submission
✔ Interview demonstration
✔ Real-world automation practice


