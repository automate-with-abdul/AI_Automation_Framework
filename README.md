# Automation Framework

## Overview
This is a **Maven-based Java automation framework developed with the help of Aider AI tool** supporting **Web UI, Mobile, and API testing**.  
It includes **self-healing locators**, **logging**, **reporting**, and reusable **utilities** for faster and maintainable automation.

---

## Features
- Web UI Automation (Selenium WebDriver)  
- Mobile Automation (Appium – Android & iOS)  
- API Automation (REST Assured)  
- Self-Healing Locators (Healenium)  
- ExtentReports / Allure Reporting  
- Log4j2 Logging  
- Parallel Execution with TestNG  
- Utilities: Excel, CSV, JSON, DB, File, Waits, Page Actions  
- Email Notifications after Execution  

---

## Project Structure

| Folder | Purpose |
|--------|---------|
| `src/main/java/apiutils` | API helpers and request/response utilities |
| `src/main/java/drivermanager` | DriverFactory for Web & Mobile drivers |
| `src/main/java/frameworkengine` | CommonUtils, PageActionUtils, WaitUtils, Constants, SendMail |
| `src/main/java/listeners` | TestNG Listeners, Retry Analyzer |
| `src/main/java/logging` | Log4j2 logger classes |
| `src/main/java/reporting` | ExtentReports / Allure report setup |
| `src/main/java/utils` | Generic utilities (FileUtils, ExcelUtils, DBUtils) |
| `src/test/java` | Test classes (Web, API, Mobile) |
| `src/test/resources` | Config files & test data (`config.properties`, `mobile.properties`, `db.properties`, `testdata/`) |

---

## Prerequisites
- Java 11+  
- Maven 3.6+  
- IntelliJ IDEA / any Java IDE  
- Node.js (optional, for Appium Desktop)  
- Android Studio (for Android testing)  

---

## Installation
```bash
git clone https://github.com/automate-with-abdul/AI_Automation_Framework/
cd AI_Automation_Framework
mvn clean install
```

### Environment Variable (Ollama)
```powershell
setx OLLAMA_API_BASE "http://localhost:11434"
```
**Restart IntelliJ** after setting this.

---

## Configuration
All configurable values are in `src/test/resources/config.properties`:

| Property | Description |
|----------|-------------|
| `browser` | Chrome / Firefox / Edge |
| `baseUrl` | Web application URL |
| `mobilePlatform` | Android / iOS |
| `apiBaseUrl` | API base URL |

---

## Running Tests

| Test Type | Command |
|-----------|---------|
| Web UI | `mvn test -DsuiteXmlFile=testng.xml` |
| Mobile | `mvn test -DsuiteXmlFile=testng_mobile.xml` |
| API | `mvn test -DsuiteXmlFile=testng_api.xml` |

---

## Reporting & Logs

| Feature | Location |
|---------|----------|
| HTML Reports | `target/reports/` |
| Screenshots | `target/screenshots/` |
| Log Files | `target/logs/` |

---

## Self-Healing Locators
- Selenium WebDriver wrapped with Healenium `SelfHealingDriver`  
- Automatically heals broken locators  
- Reduces flaky failures in Web UI tests  

---

## Sample Test Sites

| Type | URL |
|------|-----|
| Web UI | [https://www.saucedemo.com](https://www.saucedemo.com) |
| Web UI | [https://demoqa.com](https://demoqa.com) |
| API | [https://reqres.in](https://reqres.in) |
| API | [https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com) |
| Mobile | [ApiDemos.apk](https://github.com/appium/java-client/tree/master/src/test/resources/apps) |

---

## Using Aider
- Framework was initially created using **Aider**  
- Add/modify test classes, POM classes, or utilities with Aider  
- Example:
```bash
aider --model ollama/llama3.1 .
```

---

## Dependencies (pom.xml highlights)
- Selenium Java  
- TestNG  
- WebDriverManager  
- Appium Java Client  
- REST Assured  
- ExtentReports / Allure  
- Log4j2  
- Healenium Web  
- Apache POI  
- Gson / Jackson  

---

## Contributing
1. Fork repository  
2. Create branch: `git checkout -b feature/xyz`  
3. Commit changes: `git commit -m "Add feature xyz"`  
4. Push branch: `git push origin feature/xyz`  
5. Open Pull Request  

---

## GitHub Repository
- [https://github.com/automate-with-abdul/AI_Automation_Framework/](https://github.com/automate-with-abdul/AI_Automation_Framework/)

---

## Contact
- **Author**: Abdul Mateen  
- **Email**: your.email@example.com  
- **LinkedIn**: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)

