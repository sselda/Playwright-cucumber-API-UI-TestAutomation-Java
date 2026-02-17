## Playwright Cucumber Backend (API) & UI Test Automation Framework (Java)

This project is a professional end-to-end Test Automation Framework built with Java, Playwright, Cucumber, and JUnit 5. It provides full coverage for both backend (API) testing and frontend (UI) testing within a unified and scalable architecture.

## The framework supports:

- UI automation using Playwright (browser-based testing)
- Backend API testing using Playwright APIRequestContext
- Hybrid test scenarios (API setup + UI validation)
- Contract testing using JSON Schema validation
- Token-based authentication (API-driven login for UI tests)
- Shared test context between backend and UI layers
- Tag-based execution (@ui, @api)
- GitHub Actions CI integration

The architecture follows clean code principles and design patterns such as Page Object Model (POM) and layered test separation. Backend tests validate business logic and API contracts, while UI tests ensure correct user interactions and frontend behavior.

This project demonstrates advanced automation strategies suitable for enterprise-level applications, combining backend verification, frontend validation, and CI/CD integration into a single maintainable framework.

## Overview

This project is a full-stack Test Automation Framework built with:

- Java 17
- Playwright (UI + API)
- Cucumber (BDD with Gherkin)
- JUnit 5 (JUnit Platform Suite)
- Maven
- JSON Schema Validation (Contract Testing)
- GitHub Actions (CI-ready)

### Key Design Patterns

- Page Object Model (POM)
- Shared TestContext
- Separate Hooks for UI and API
- Tag-based execution (`@ui`, `@api`)
- Contract validation using JSON Schema

## Features

### UI Testing
- Playwright-based browser automation
- Login flow
- Token-based authentication
- Session reuse support

### API Testing
- GET / POST requests
- Status code validation
- JSON body validation
- Contract testing with JSON Schema

### Hybrid Testing
- API setup + UI validation
- Shared state between layers
