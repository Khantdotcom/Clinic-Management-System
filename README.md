# Clinic Management System

A modular-monolith Spring Boot clinic system with role-based portals for Admin, Doctor, and Patient.

## Features
- JWT authentication and role-based authorization
- Admin doctor CRUD
- Doctor availability and appointment views
- Patient doctor search + appointment booking + appointment/prescription views
- Prescription workflow
- Report endpoints backed by MySQL stored procedures
- Docker Compose and GitHub Actions CI

## Tech Stack
- Java 17, Spring Boot 3
- Spring Security, Spring Data JPA, Validation
- MySQL 8
- Plain HTML/CSS/JS frontends (3 simple portals)

## Quick Start
### With Docker
```bash
docker-compose up --build
```

### Local backend only
```bash
cd backend
mvn spring-boot:run
```

## API Docs
- API contract: `docs/api-contract.md`
- Schema design: `docs/schema-design.md`
- Feature showcase data: `docs/feature-showcase.md`
- SQL files: `db/schema.sql`, `db/stored-procedures.sql`, `db/seed.sql`

## Demo credentials
- Admin: `admin@clinic.com` / `Admin@123`
- Doctor: `doctor@clinic.com` / `Doctor@123`
- Patient: `patient@clinic.com` / `Patient@123`

## Sample cURL
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"email":"admin@clinic.com","password":"Admin@123"}'
```

## Feature Run (Sample Data) + Screenshots

The role-based portals include **Load Example Data** actions for each feature card. To run all features quickly with sample data:

```bash
python3 -m http.server 4173
```

Then open each page and click every **Load Example Data** button:
- `http://localhost:4173/frontend/admin/index.html`
- `http://localhost:4173/frontend/doctor/index.html`
- `http://localhost:4173/frontend/patient/index.html`

### Screenshots (max 5)

1. Admin full-page flow (auth, doctor CRUD, reports)
![Admin full page](browser:/tmp/codex_browser_invocations/29d5174ef281ad88/artifacts/docs/screenshots/admin-full.png)

2. Doctor full-page flow (auth, availability, appointments, prescriptions)
![Doctor full page](browser:/tmp/codex_browser_invocations/29d5174ef281ad88/artifacts/docs/screenshots/doctor-full.png)

3. Patient full-page flow (auth, search, availability, booking, history)
![Patient full page](browser:/tmp/codex_browser_invocations/29d5174ef281ad88/artifacts/docs/screenshots/patient-full.png)

4. Admin report output focus
![Admin report output](browser:/tmp/codex_browser_invocations/29d5174ef281ad88/artifacts/docs/screenshots/admin-report-output.png)

5. Patient booking output focus
![Patient booking output](browser:/tmp/codex_browser_invocations/29d5174ef281ad88/artifacts/docs/screenshots/patient-booking-output.png)
