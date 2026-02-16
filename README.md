# Playwright Cucumber API & UI Test Automation Framework (Java)

## Overview

This project is a full-stack Test Automation Framework built with:

- Java 17
- Playwright (UI + API)
- Cucumber (BDD with Gherkin)
- JUnit 5 (JUnit Platform Suite)
- Maven
- JSON Schema Validation (Contract Testing)
- GitHub Actions (CI-ready)

The framework supports:

- UI Automation
- API Automation
- Contract Testing (JSON Schema)
- Hybrid UI + API tests
- Shared Test Context
- Token-based authentication
- CI/CD integration

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
