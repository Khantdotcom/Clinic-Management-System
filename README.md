# Clinic Management System

A Spring Boot clinic system with role-based portals for Admin, Doctor, and Patient.

## Features
- JWT authentication and role-based authorization
- Admin doctor CRUD
- Doctor availability and appointment views
- Patient doctor search + appointment booking + appointment/prescription views
- Prescription workflow
- Report endpoints backed by MySQL stored procedures
- Docker Compose and GitHub Actions CI

### Screenshots of Features

1. Admin full-page flow (auth, doctor CRUD, reports)
<img width="1440" height="1800" alt="image" src="https://github.com/user-attachments/assets/28d791f2-518c-4b2c-8699-2f91c503e6ee" />
<img width="1440" height="1800" alt="image" src="https://github.com/user-attachments/assets/28d791f2-518c-4b2c-8699-2f91c503e6ee" />


2. Doctor portal (full page)
<img width="1440" height="2238" alt="image" src="https://github.com/user-attachments/assets/b75d53b8-bd01-4ee3-b0b2-788d2ab63bff" />
<img width="1440" height="2238" alt="image" src="https://github.com/user-attachments/assets/b75d53b8-bd01-4ee3-b0b2-788d2ab63bff" />


3. Patient portal 
<img width="1440" height="2470" alt="image" src="https://github.com/user-attachments/assets/aab19f2a-5ab0-4def-9eb4-208f7b542388" />
<img width="1440" height="2470" alt="image" src="https://github.com/user-attachments/assets/aab19f2a-5ab0-4def-9eb4-208f7b542388" />


4. Admin report output
<img width="663" height="297" alt="image" src="https://github.com/user-attachments/assets/0fa50263-7656-4722-943f-63ef25a9bfee" />
<img width="663" height="297" alt="image" src="https://github.com/user-attachments/assets/0fa50263-7656-4722-943f-63ef25a9bfee" />

5. Patient booking output 
<img width="1342" height="177" alt="image" src="https://github.com/user-attachments/assets/ebcb9620-8f1d-4d2d-9b2e-f124f353acd9" />
<img width="1342" height="177" alt="image" src="https://github.com/user-attachments/assets/ebcb9620-8f1d-4d2d-9b2e-f124f353acd9" />

## Tech Stack
- Java 17, Spring Boot 3
- Spring Security, Spring Data JPA, Validation
- MySQL 8
- Plain HTML/CSS/JS frontend

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

