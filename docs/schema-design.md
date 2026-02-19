# Schema Design (MySQL)

## Database
- **Database name:** `clinic_db`
- **Engine target:** MySQL 8+

## 1) users
| Column | Type | Constraints |
|---|---|---|
| id | BIGINT | PK, AUTO_INCREMENT |
| email | VARCHAR(255) | NOT NULL, UNIQUE |
| password | VARCHAR(255) | NOT NULL |
| full_name | VARCHAR(255) | NOT NULL |
| role | VARCHAR(20) | NOT NULL (`ADMIN`,`DOCTOR`,`PATIENT`) |
| specialty | VARCHAR(255) | NULL (doctor-only) |

## 2) patient
| Column | Type | Constraints |
|---|---|---|
| id | BIGINT | PK, AUTO_INCREMENT |
| full_name | VARCHAR(255) | NOT NULL |
| email | VARCHAR(255) | NOT NULL, UNIQUE |
| phone_number | VARCHAR(30) | NOT NULL, UNIQUE |

## 3) doctor_available_times
| Column | Type | Constraints |
|---|---|---|
| id | BIGINT | PK, AUTO_INCREMENT |
| doctor_id | BIGINT | NOT NULL, FK -> `users.id` |
| available_date | DATE | NOT NULL |
| start_time | TIME | NOT NULL |

## 4) appointments
| Column | Type | Constraints |
|---|---|---|
| id | BIGINT | PK, AUTO_INCREMENT |
| doctor_id | BIGINT | NOT NULL, FK -> `users.id` |
| patient_id | BIGINT | NOT NULL, FK -> `users.id` |
| appointment_date | DATE | NOT NULL |
| appointment_time | TIME | NOT NULL |
| status | VARCHAR(20) | NOT NULL (`BOOKED`,`CANCELLED`,`COMPLETED`) |

## 5) prescriptions
| Column | Type | Constraints |
|---|---|---|
| id | BIGINT | PK, AUTO_INCREMENT |
| appointment_id | BIGINT | NOT NULL, FK -> `appointments.id` |
| doctor_id | BIGINT | NOT NULL, FK -> `users.id` |
| diagnosis | VARCHAR(500) | NOT NULL |
| medications | TEXT | NOT NULL |
| notes | TEXT | NULL |

## Relationship summary
- `doctor_available_times.doctor_id` ➜ `users.id`
- `appointments.doctor_id` ➜ `users.id`
- `appointments.patient_id` ➜ `users.id`
- `prescriptions.appointment_id` ➜ `appointments.id`
- `prescriptions.doctor_id` ➜ `users.id`

## Stored procedures (assessment names)
- `GetDailyAppointmentReportByDoctor`
- `GetDoctorWithMostPatientsByMonth`
- `GetDoctorWithMostPatientsByYear`

## Stored procedures (internal aliases)
- `sp_daily_appointments_by_doctor`
- `sp_top_doctor_by_month`
- `sp_top_doctor_by_year`
