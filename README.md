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
