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


## Feature Screenshots

### Admin Portal
![Admin Portal - Full](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/admin-full.png)
![Admin - Authentication](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/admin-auth.png)
![Admin - Doctor CRUD](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/admin-doctor-crud.png)
![Admin - Daily Report](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/admin-report-daily.png)
![Admin - Top Doctor Reports](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/admin-report-top.png)

### Doctor Portal
![Doctor Portal - Full](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-full.png)
![Doctor - Authentication](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-auth.png)
![Doctor - Availability](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-availability.png)
![Doctor - Appointments](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-appointments.png)
![Doctor - Create Prescription](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-prescription-create.png)
![Doctor - View Prescription](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/doctor-prescription-view.png)

### Patient Portal
![Patient Portal - Full](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-full.png)
![Patient - Register/Login](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-auth.png)
![Patient - Search Doctors](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-search.png)
![Patient - View Availability](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-availability.png)
![Patient - Book Appointment](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-booking.png)
![Patient - My Appointments](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-appointments.png)
![Patient - My Prescriptions](browser:/tmp/codex_browser_invocations/bc0ac14326602725/artifacts/artifacts/screens/patient-prescriptions.png)
